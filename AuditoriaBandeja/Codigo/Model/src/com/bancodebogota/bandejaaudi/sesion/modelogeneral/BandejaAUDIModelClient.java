package com.bancodebogota.bandejaaudi.sesion.modelogeneral;

import java.util.Hashtable;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class BandejaAUDIModelClient
{
    public static void main(String[] args)
    {
        try
        {
            final Context context = getInitialContext();
            BandejaAUDIModel bandejaAUDIModel = (BandejaAUDIModel) context.lookup("BandejaAUDIModel#com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel");
        }
        catch (CommunicationException ex)
        {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException
    {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://10.84.64.51:7101");
        return new InitialContext( env );
    }
}
