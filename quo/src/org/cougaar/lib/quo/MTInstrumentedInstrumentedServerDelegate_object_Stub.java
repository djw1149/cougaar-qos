// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package org.cougaar.lib.quo;

public final class MTInstrumentedInstrumentedServerDelegate_object_Stub
    extends java.rmi.server.RemoteStub
    implements org.cougaar.lib.quo.MTInstrumented, java.rmi.Remote
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("org.cougaar.core.society.MessageAddress getMessageAddress()"),
	new java.rmi.server.Operation("void ignoreBytes(byte[])"),
	new java.rmi.server.Operation("void ignoreCompressedBytes(byte[])"),
	new java.rmi.server.Operation("void ignoreCompressedMessage(org.cougaar.lib.quo.Zippy)"),
	new java.rmi.server.Operation("com.bbn.quo.instr.corba.Trace_rec receiveCompressedMessage(com.bbn.quo.instr.corba.Trace_rec, org.cougaar.lib.quo.Zippy)"),
	new java.rmi.server.Operation("void receiveOnlyBytes(byte[])"),
	new java.rmi.server.Operation("void receiveOnlyCompressedBytes(byte[])"),
	new java.rmi.server.Operation("void receiveOnlyCompressedMessage(org.cougaar.lib.quo.Zippy)"),
	new java.rmi.server.Operation("com.bbn.quo.instr.corba.Trace_rec rerouteMessage(com.bbn.quo.instr.corba.Trace_rec, org.cougaar.core.society.Message)")
    };
    
    private static final long interfaceHash = 697412853093013106L;
    
    private static final long serialVersionUID = 2;
    
    private static boolean useNewInvoke;
    private static java.lang.reflect.Method $method_getMessageAddress_0;
    private static java.lang.reflect.Method $method_ignoreBytes_1;
    private static java.lang.reflect.Method $method_ignoreCompressedBytes_2;
    private static java.lang.reflect.Method $method_ignoreCompressedMessage_3;
    private static java.lang.reflect.Method $method_receiveCompressedMessage_4;
    private static java.lang.reflect.Method $method_receiveOnlyBytes_5;
    private static java.lang.reflect.Method $method_receiveOnlyCompressedBytes_6;
    private static java.lang.reflect.Method $method_receiveOnlyCompressedMessage_7;
    private static java.lang.reflect.Method $method_rerouteMessage_8;
    
    static {
	try {
	    java.rmi.server.RemoteRef.class.getMethod("invoke",
		new java.lang.Class[] {
		    java.rmi.Remote.class,
		    java.lang.reflect.Method.class,
		    java.lang.Object[].class,
		    long.class
		});
	    useNewInvoke = true;
	    $method_getMessageAddress_0 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("getMessageAddress", new java.lang.Class[] {});
	    $method_ignoreBytes_1 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("ignoreBytes", new java.lang.Class[] {byte[].class});
	    $method_ignoreCompressedBytes_2 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("ignoreCompressedBytes", new java.lang.Class[] {byte[].class});
	    $method_ignoreCompressedMessage_3 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("ignoreCompressedMessage", new java.lang.Class[] {org.cougaar.lib.quo.Zippy.class});
	    $method_receiveCompressedMessage_4 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("receiveCompressedMessage", new java.lang.Class[] {com.bbn.quo.instr.corba.Trace_rec.class, org.cougaar.lib.quo.Zippy.class});
	    $method_receiveOnlyBytes_5 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("receiveOnlyBytes", new java.lang.Class[] {byte[].class});
	    $method_receiveOnlyCompressedBytes_6 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("receiveOnlyCompressedBytes", new java.lang.Class[] {byte[].class});
	    $method_receiveOnlyCompressedMessage_7 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("receiveOnlyCompressedMessage", new java.lang.Class[] {org.cougaar.lib.quo.Zippy.class});
	    $method_rerouteMessage_8 = org.cougaar.lib.quo.MTInstrumented.class.getMethod("rerouteMessage", new java.lang.Class[] {com.bbn.quo.instr.corba.Trace_rec.class, org.cougaar.core.society.Message.class});
	} catch (java.lang.NoSuchMethodException e) {
	    useNewInvoke = false;
	}
    }
    
    // constructors
    public MTInstrumentedInstrumentedServerDelegate_object_Stub() {
	super();
    }
    public MTInstrumentedInstrumentedServerDelegate_object_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of getMessageAddress()
    public org.cougaar.core.society.MessageAddress getMessageAddress()
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_getMessageAddress_0, null, -3927034548767378042L);
		return ((org.cougaar.core.society.MessageAddress) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0, interfaceHash);
		ref.invoke(call);
		org.cougaar.core.society.MessageAddress $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (org.cougaar.core.society.MessageAddress) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of ignoreBytes(byte[])
    public void ignoreBytes(byte[] $param_arrayOf_byte_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		ref.invoke(this, $method_ignoreBytes_1, new java.lang.Object[] {$param_arrayOf_byte_1}, 1107025521516391893L);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 1, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_arrayOf_byte_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		ref.done(call);
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of ignoreCompressedBytes(byte[])
    public void ignoreCompressedBytes(byte[] $param_arrayOf_byte_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		ref.invoke(this, $method_ignoreCompressedBytes_2, new java.lang.Object[] {$param_arrayOf_byte_1}, -3247333393572153926L);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 2, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_arrayOf_byte_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		ref.done(call);
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of ignoreCompressedMessage(Zippy)
    public void ignoreCompressedMessage(org.cougaar.lib.quo.Zippy $param_Zippy_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		ref.invoke(this, $method_ignoreCompressedMessage_3, new java.lang.Object[] {$param_Zippy_1}, -4802326987998186550L);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 3, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_Zippy_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		ref.done(call);
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of receiveCompressedMessage(Trace_rec, Zippy)
    public com.bbn.quo.instr.corba.Trace_rec receiveCompressedMessage(com.bbn.quo.instr.corba.Trace_rec $param_Trace_rec_1, org.cougaar.lib.quo.Zippy $param_Zippy_2)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_receiveCompressedMessage_4, new java.lang.Object[] {$param_Trace_rec_1, $param_Zippy_2}, 7390977774772848672L);
		return ((com.bbn.quo.instr.corba.Trace_rec) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 4, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_Trace_rec_1);
		    out.writeObject($param_Zippy_2);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		com.bbn.quo.instr.corba.Trace_rec $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (com.bbn.quo.instr.corba.Trace_rec) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of receiveOnlyBytes(byte[])
    public void receiveOnlyBytes(byte[] $param_arrayOf_byte_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		ref.invoke(this, $method_receiveOnlyBytes_5, new java.lang.Object[] {$param_arrayOf_byte_1}, -8825285440700275413L);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 5, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_arrayOf_byte_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		ref.done(call);
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of receiveOnlyCompressedBytes(byte[])
    public void receiveOnlyCompressedBytes(byte[] $param_arrayOf_byte_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		ref.invoke(this, $method_receiveOnlyCompressedBytes_6, new java.lang.Object[] {$param_arrayOf_byte_1}, 5513937421549448622L);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 6, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_arrayOf_byte_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		ref.done(call);
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of receiveOnlyCompressedMessage(Zippy)
    public void receiveOnlyCompressedMessage(org.cougaar.lib.quo.Zippy $param_Zippy_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		ref.invoke(this, $method_receiveOnlyCompressedMessage_7, new java.lang.Object[] {$param_Zippy_1}, 7111391360797476704L);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 7, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_Zippy_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		ref.done(call);
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of rerouteMessage(Trace_rec, Message)
    public com.bbn.quo.instr.corba.Trace_rec rerouteMessage(com.bbn.quo.instr.corba.Trace_rec $param_Trace_rec_1, org.cougaar.core.society.Message $param_Message_2)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_rerouteMessage_8, new java.lang.Object[] {$param_Trace_rec_1, $param_Message_2}, 8860286475021932364L);
		return ((com.bbn.quo.instr.corba.Trace_rec) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 8, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_Trace_rec_1);
		    out.writeObject($param_Message_2);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		com.bbn.quo.instr.corba.Trace_rec $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (com.bbn.quo.instr.corba.Trace_rec) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
