// Skeleton class generated by rmic, do not edit.
// Contents subject to change without notice.

package org.cougaar.lib.quo;

public final class MTInstrumentedInstrumentedServerDelegate_object_Skel
    implements java.rmi.server.Skeleton
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("org.cougaar.core.mts.MessageAddress getMessageAddress()"),
	new java.rmi.server.Operation("void ignoreBytes(byte[])"),
	new java.rmi.server.Operation("void ignoreCompressedBytes(byte[])"),
	new java.rmi.server.Operation("void ignoreCompressedMessage(org.cougaar.lib.mquo.Zippy)"),
	new java.rmi.server.Operation("com.bbn.quo.instr.corba.Trace_rec receiveCompressedMessage(com.bbn.quo.instr.corba.Trace_rec, org.cougaar.lib.mquo.Zippy)"),
	new java.rmi.server.Operation("void receiveOnlyBytes(byte[])"),
	new java.rmi.server.Operation("void receiveOnlyCompressedBytes(byte[])"),
	new java.rmi.server.Operation("void receiveOnlyCompressedMessage(org.cougaar.lib.mquo.Zippy)"),
	new java.rmi.server.Operation("com.bbn.quo.instr.corba.Trace_rec rerouteMessage(com.bbn.quo.instr.corba.Trace_rec, org.cougaar.core.mts.AttributedMessage)")
    };
    
    private static final long interfaceHash = 6533291143575432253L;
    
    public java.rmi.server.Operation[] getOperations() {
	return (java.rmi.server.Operation[]) operations.clone();
    }
    
    public void dispatch(java.rmi.Remote obj, java.rmi.server.RemoteCall call, int opnum, long hash)
	throws java.lang.Exception
    {
	if (opnum < 0) {
	    if (hash == -6029056381873570415L) {
		opnum = 0;
	    } else if (hash == 1107025521516391893L) {
		opnum = 1;
	    } else if (hash == -3247333393572153926L) {
		opnum = 2;
	    } else if (hash == -2328156424711128505L) {
		opnum = 3;
	    } else if (hash == -3541469534832191741L) {
		opnum = 4;
	    } else if (hash == -8825285440700275413L) {
		opnum = 5;
	    } else if (hash == 5513937421549448622L) {
		opnum = 6;
	    } else if (hash == -6557596854227280392L) {
		opnum = 7;
	    } else if (hash == -3214341764718700490L) {
		opnum = 8;
	    } else {
		throw new java.rmi.UnmarshalException("invalid method hash");
	    }
	} else {
	    if (hash != interfaceHash)
		throw new java.rmi.server.SkeletonMismatchException("interface hash mismatch");
	}
	
	org.cougaar.lib.quo.MTInstrumentedInstrumentedServerDelegate_object server = (org.cougaar.lib.quo.MTInstrumentedInstrumentedServerDelegate_object) obj;
	switch (opnum) {
	case 0: // getMessageAddress()
	{
	    call.releaseInputStream();
	    org.cougaar.core.mts.MessageAddress $result = server.getMessageAddress();
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeObject($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 1: // ignoreBytes(byte[])
	{
	    byte[] $param_arrayOf_byte_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_arrayOf_byte_1 = (byte[]) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.ignoreBytes($param_arrayOf_byte_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 2: // ignoreCompressedBytes(byte[])
	{
	    byte[] $param_arrayOf_byte_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_arrayOf_byte_1 = (byte[]) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.ignoreCompressedBytes($param_arrayOf_byte_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 3: // ignoreCompressedMessage(Zippy)
	{
	    org.cougaar.lib.mquo.Zippy $param_Zippy_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Zippy_1 = (org.cougaar.lib.mquo.Zippy) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.ignoreCompressedMessage($param_Zippy_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 4: // receiveCompressedMessage(Trace_rec, Zippy)
	{
	    com.bbn.quo.instr.corba.Trace_rec $param_Trace_rec_1;
	    org.cougaar.lib.mquo.Zippy $param_Zippy_2;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Trace_rec_1 = (com.bbn.quo.instr.corba.Trace_rec) in.readObject();
		$param_Zippy_2 = (org.cougaar.lib.mquo.Zippy) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    com.bbn.quo.instr.corba.Trace_rec $result = server.receiveCompressedMessage($param_Trace_rec_1, $param_Zippy_2);
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeObject($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 5: // receiveOnlyBytes(byte[])
	{
	    byte[] $param_arrayOf_byte_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_arrayOf_byte_1 = (byte[]) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.receiveOnlyBytes($param_arrayOf_byte_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 6: // receiveOnlyCompressedBytes(byte[])
	{
	    byte[] $param_arrayOf_byte_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_arrayOf_byte_1 = (byte[]) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.receiveOnlyCompressedBytes($param_arrayOf_byte_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 7: // receiveOnlyCompressedMessage(Zippy)
	{
	    org.cougaar.lib.mquo.Zippy $param_Zippy_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Zippy_1 = (org.cougaar.lib.mquo.Zippy) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.receiveOnlyCompressedMessage($param_Zippy_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 8: // rerouteMessage(Trace_rec, AttributedMessage)
	{
	    com.bbn.quo.instr.corba.Trace_rec $param_Trace_rec_1;
	    org.cougaar.core.mts.AttributedMessage $param_AttributedMessage_2;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Trace_rec_1 = (com.bbn.quo.instr.corba.Trace_rec) in.readObject();
		$param_AttributedMessage_2 = (org.cougaar.core.mts.AttributedMessage) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    com.bbn.quo.instr.corba.Trace_rec $result = server.rerouteMessage($param_Trace_rec_1, $param_AttributedMessage_2);
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeObject($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	default:
	    throw new java.rmi.UnmarshalException("invalid method number");
	}
    }
}