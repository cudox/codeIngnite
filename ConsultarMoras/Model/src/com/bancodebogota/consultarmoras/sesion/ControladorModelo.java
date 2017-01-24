package com.bancodebogota.consultarmoras.sesion;


import com.bancodebogota.consultarmoras.sesion.controladorprocedimiento.ConsultarMorasModel;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;


public class ControladorModelo
{
    ConsultarMorasModel consultarMorasModel;
    
    private static ControladorModelo controladorModelo;

    /**
     * Devuelve una instancia única de la clase que implementa el controlador del modelo
     * @return instancia única del controlador del modelo
     * @throws IllegalStateException Si no es posible obtener el controlador del modelo
     */
    public static synchronized ControladorModelo getInstance()
    {
        if (controladorModelo == null)
            controladorModelo = new ControladorModelo();

        return controladorModelo;
    } //getInstance

    //--------------------------------------------------------------------------
    // Constructor de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     * @throws IllegalStateException Si existe algún error instanciado el controlador o hay algún error en la consulta de la lista
     */
    private ControladorModelo()
    {
        try
        {
            final Context ic = new InitialContext();
            consultarMorasModel = (ConsultarMorasModel) ic.lookup("ConsultarMorasModel#com.bancodebogota.consultarmoras.sesion.controladorprocedimiento.ConsultarMorasModel");
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Error instanciando el controlador del modelo: " + e.getMessage(), e);
        }
    } //ControladorModelo
    
    public void consultaMoras() throws Exception
    {
        Map<String, Object> obj = consultarMorasModel.consultarMoras("C", "80141414");
        System.out.println(obj);
    }//ConsultaMoras
}
