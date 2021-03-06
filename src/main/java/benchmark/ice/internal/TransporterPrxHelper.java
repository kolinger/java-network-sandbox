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

public final class TransporterPrxHelper extends Ice.ObjectPrxHelperBase implements TransporterPrx
{
    private static final String __transport_name = "transport";

    public void transport(Message msg)
    {
        transport(msg, null, false);
    }

    public void transport(Message msg, java.util.Map<String, String> __ctx)
    {
        transport(msg, __ctx, true);
    }

    private void transport(Message msg, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        final Ice.Instrumentation.InvocationObserver __observer = IceInternal.ObserverHelper.get(this, "transport", __ctx);
        int __cnt = 0;
        try
        {
            while(true)
            {
                Ice._ObjectDel __delBase = null;
                try
                {
                    __delBase = __getDelegate(false);
                    _TransporterDel __del = (_TransporterDel)__delBase;
                    __del.transport(msg, __ctx, __observer);
                    return;
                }
                catch(IceInternal.LocalExceptionWrapper __ex)
                {
                    __handleExceptionWrapper(__delBase, __ex, __observer);
                }
                catch(Ice.LocalException __ex)
                {
                    __cnt = __handleException(__delBase, __ex, null, __cnt, __observer);
                }
            }
        }
        finally
        {
            if(__observer != null)
            {
                __observer.detach();
            }
        }
    }

    public Ice.AsyncResult begin_transport(Message msg)
    {
        return begin_transport(msg, null, false, null);
    }

    public Ice.AsyncResult begin_transport(Message msg, java.util.Map<String, String> __ctx)
    {
        return begin_transport(msg, __ctx, true, null);
    }

    public Ice.AsyncResult begin_transport(Message msg, Ice.Callback __cb)
    {
        return begin_transport(msg, null, false, __cb);
    }

    public Ice.AsyncResult begin_transport(Message msg, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_transport(msg, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_transport(Message msg, Callback_Transporter_transport __cb)
    {
        return begin_transport(msg, null, false, __cb);
    }

    public Ice.AsyncResult begin_transport(Message msg, java.util.Map<String, String> __ctx, Callback_Transporter_transport __cb)
    {
        return begin_transport(msg, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_transport(Message msg, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __transport_name, __cb);
        try
        {
            __result.__prepare(__transport_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__startWriteParams(Ice.FormatType.DefaultFormat);
            msg.__write(__os);
            __result.__endWriteParams();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public void end_transport(Ice.AsyncResult __result)
    {
        __end(__result, __transport_name);
    }

    public static TransporterPrx checkedCast(Ice.ObjectPrx __obj)
    {
        TransporterPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof TransporterPrx)
            {
                __d = (TransporterPrx)__obj;
            }
            else
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    TransporterPrxHelper __h = new TransporterPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static TransporterPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        TransporterPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof TransporterPrx)
            {
                __d = (TransporterPrx)__obj;
            }
            else
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    TransporterPrxHelper __h = new TransporterPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static TransporterPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        TransporterPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    TransporterPrxHelper __h = new TransporterPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static TransporterPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        TransporterPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    TransporterPrxHelper __h = new TransporterPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static TransporterPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        TransporterPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof TransporterPrx)
            {
                __d = (TransporterPrx)__obj;
            }
            else
            {
                TransporterPrxHelper __h = new TransporterPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static TransporterPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        TransporterPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            TransporterPrxHelper __h = new TransporterPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::internal::Transporter"
    };

    public static String ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM __createDelegateM()
    {
        return new _TransporterDelM();
    }

    protected Ice._ObjectDelD __createDelegateD()
    {
        return new _TransporterDelD();
    }

    public static void __write(IceInternal.BasicStream __os, TransporterPrx v)
    {
        __os.writeProxy(v);
    }

    public static TransporterPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            TransporterPrxHelper result = new TransporterPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
