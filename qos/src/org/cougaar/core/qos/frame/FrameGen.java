/*
 * <copyright>
 *  
 *  Copyright 1997-2004 BBNT Solutions, LLC
 *  under sponsorship of the Defense Advanced Research Projects
 *  Agency (DARPA).
 * 
 *  You can redistribute this software and/or modify it under the
 *  terms of the Cougaar Open Source License as published on the
 *  Cougaar Open Source Website (www.cougaar.org).
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 * </copyright>
 */

package org.cougaar.core.qos.frame;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class FrameGen
    extends DefaultHandler
{
    private static final String DRIVER_PROPERTY = "org.xml.sax.driver";
    private static final String DRIVER_DEFAULT =
	"org.apache.crimson.parser.XMLReaderImpl";

    static {
	String driver = System.getProperty(DRIVER_PROPERTY);
	if (driver == null) 
	    System.setProperty(DRIVER_PROPERTY, DRIVER_DEFAULT);
    }

    private String package_name;
    private String dir_name;
    private PrintWriter writer;
    private String path;
    private ArrayList slots;
    private String current_prototype;

    public FrameGen(String path)
    {
	this.path = path;
    }

    public void parseProtoFile(File xml_file)
    {
	try {
	    XMLReader producer = XMLReaderFactory.createXMLReader();
	    DefaultHandler consumer = this; 
	    producer.setContentHandler(consumer);
	    producer.setErrorHandler(consumer);
	    URL url = xml_file.toURL();
	    producer.parse(url.toString());
	} catch (Throwable ex) {
	    ex.printStackTrace();
	    return;
	}
	System.out.println("Finished parsing " + xml_file);
    }


    public void startElement(String uri, String local, String name, 
			     Attributes attrs)
    {
	if (name.equals("frameset")) {
	    startFrameset(attrs);
	} else if (name.equals("prototypes")) {
	    // no-op
	} else if (name.equals("prototype")) {
	    startPrototype(attrs);
	} else if (name.equals("slot")) {
	    slot(attrs);
	} else if (name.equals("fork")) {
	    fork(attrs);
	} else if (name.equals("path")) {
	    startPath(attrs);
	} 
    }

    public void endElement(String uri, String local, String name)
    {
	if (name.equals("frameset")) {
	    endFrameset();
	} else if (name.equals("prototypes")) {
	    // no-op
	} else if (name.equals("prototype")) {
	    endPrototype();
	} else if (name.equals("path")) {
	    endPath();
	} 
    }

    // Not using this yet
    public void characters(char buf[], int offset, int length)
    {
    }



    static String fix_name(String name, boolean is_class)
    {
	if (is_class) {
	    // camelize, or at least initial cap
	    StringBuffer buf = new StringBuffer();
	    char[] name_chars = name.toCharArray();
	    boolean capitalize_next = true;
	    for (int i=0; i<name_chars.length; i++) {
		char next = name_chars[i];
		if (next == '-') {
		    capitalize_next = true;
		    continue;
		}
		if (capitalize_next) {
		    buf.append(Character.toUpperCase(next));
		} else {
		    buf.append(next);
		}
		capitalize_next = false;
	    }
	    return buf.toString();
	} else {
	    return name.replaceAll("-", "_");
	}
    }


    private void startFrameset(Attributes attrs)
    {
	
	String name = attrs.getValue("name");
	String pkg_prefix = attrs.getValue("package");

	String inheritance = attrs.getValue("frame-inheritance");
	if (!inheritance.equals("single")) {
	    throw new RuntimeException("Only single-inheritance FrameSets are supported!");
	}

	package_name = pkg_prefix +"."+ name;
	dir_name = path + File.separator+ 
	    package_name.replaceAll("\\.", File.separator);
	System.out.println("package=" +package_name+ " directory=" +dir_name);
    }


    private void beginPrototypeClass(String name, String parent)
    {
	writer.println("package " +package_name+ ";\n");
	writer.println("import org.cougaar.core.util.UID;");
	writer.println("import org.cougaar.core.qos.frame.FrameSet;");
	if (parent == null)
	    writer.println("import org.cougaar.core.qos.frame.DataFrame;");
	writer.println("\npublic class " +name);
	if (parent != null) {
	    writer.println("    extends " +fix_name(parent, true));
	} else {
	    writer.println("    extends DataFrame");
	}
	writer.println("{");
    }

    private void writeConstructors(String name)
    {
	String cname = fix_name(name, true);
	writer.println("\n\n    public " +cname + "(FrameSet frameSet,");
	writer.println("               UID uid)");
	writer.println("    {");
	writer.println("        super(frameSet, \"" +name+ "\", uid);");
	writer.println("    }");

	writer.println("\n\n    public " +cname + "(FrameSet frameSet,");
	writer.println("               String kind,");
	writer.println("               UID uid)");
	writer.println("    {");
	writer.println("        super(frameSet, kind, uid);");
	writer.println("    }");
    }

    private void writeAccessors(String slot)
    {
	String accessor_name = fix_name(slot, true);
	String fixed_name = fix_name(slot, false);
	writer.println("\n\n    public Object get" +accessor_name+ "()");
	writer.println("    {");
	writer.println("        if (" +fixed_name+ " != null)");
	writer.println("            return " +fixed_name+ ";");
	writer.println("        else");
	writer.println("            return getInheritedValue(this, \"" +slot+ "\");");
	writer.println("    }");

	writer.println("\n\n    public void set" +accessor_name+
		       "(Object new_value)");
	writer.println("    {");
	writer.println("        this." +fixed_name+ " = new_value;");
	writer.println("        addLocalSlot(\"" +slot+ "\");");
	writer.println("    }");
    }

    private void endPrototypeClass()
    {
	writeConstructors(current_prototype);
	// dump accessors
	for (int i=0; i<slots.size(); i++) {
	    String slot = (String) slots.get(i);
	    writeAccessors(slot);
	}
	writer.println("}");
	current_prototype = null;
    }

    private void startPrototype(Attributes attrs)
    {
	current_prototype = attrs.getValue("name");
	String name = fix_name(current_prototype, true);
	String parent = attrs.getValue("prototype");
	File out = new File(dir_name, name+".java");
	try {
	    FileWriter fw = new FileWriter(out);
	    writer = new PrintWriter(fw);
	} catch (java.io.IOException iox) {
	    iox.printStackTrace();
	    System.exit(-1);
	}
	beginPrototypeClass(name, parent);
	slots = new ArrayList();
    }

    private void endPrototype()
    {
	endPrototypeClass();
	writer.close();
    }

    private void startPath(Attributes attrs)
    {
	String name = attrs.getValue("name");
    }

    private void fork(Attributes attrs)
    {
	String role = attrs.getValue("role");
	String relation = attrs.getValue("relation");
    }

    private void endPath()
    {
    }

    
    private void slot(Attributes attrs)
    {
	String slot = attrs.getValue("name");
	slots.add(slot);
	writer.print("    private Object " + fix_name(slot, false));

	String path = attrs.getValue("path");
	String value = attrs.getValue("value");
        if (value != null)  writer.print(" = \"" +value+ "\"");
	writer.println(";");
    }

    private void endFrameset()
    {
	// no-op
    }





    public static void main(String[] args)
    {
	String path = args[0];
	FrameGen generator = new FrameGen(path);
	for (int i=1; i<args.length; i++) {
	    File file = new File(args[i]);
	    generator.parseProtoFile(file);
	}
    }

	    




}

