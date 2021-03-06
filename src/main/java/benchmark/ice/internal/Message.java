// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `slices.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package benchmark.ice.internal;

public class Message implements java.lang.Cloneable, java.io.Serializable
{
    public String sender;

    public String receiver;

    public String content;

    public Message()
    {
    }

    public Message(String sender, String receiver, String content)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Message _r = null;
        if(rhs instanceof Message)
        {
            _r = (Message)rhs;
        }

        if(_r != null)
        {
            if(sender != _r.sender)
            {
                if(sender == null || _r.sender == null || !sender.equals(_r.sender))
                {
                    return false;
                }
            }
            if(receiver != _r.receiver)
            {
                if(receiver == null || _r.receiver == null || !receiver.equals(_r.receiver))
                {
                    return false;
                }
            }
            if(content != _r.content)
            {
                if(content == null || _r.content == null || !content.equals(_r.content))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::internal::Message");
        __h = IceInternal.HashUtil.hashAdd(__h, sender);
        __h = IceInternal.HashUtil.hashAdd(__h, receiver);
        __h = IceInternal.HashUtil.hashAdd(__h, content);
        return __h;
    }

    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(sender);
        __os.writeString(receiver);
        __os.writeString(content);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        sender = __is.readString();
        receiver = __is.readString();
        content = __is.readString();
    }

    public static final long serialVersionUID = -323736997L;
}
