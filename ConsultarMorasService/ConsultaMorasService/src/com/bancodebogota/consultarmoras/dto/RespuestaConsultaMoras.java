package com.bancodebogota.consultarmoras.dto;


import static com.bancodebogota.consultarmoras.utilitarios.UtilitariosTexto.esVacio;

import java.io.Serializable;

public class RespuestaConsultaMoras implements Serializable
{
    @SuppressWarnings("compatibility:-1655084876242943466")
    private static final long serialVersionUID = 4928979708476048262L;
    
    private int respuestaCod;
    private String respuestaMsj;
    private String respuestaDat;
    
    public RespuestaConsultaMoras()
    {
    }
       
    public RespuestaConsultaMoras(int respuestaCod, String respuestaMsj, String respuestaDat)
    {
        if(esVacio(respuestaMsj))
            throw new IllegalArgumentException("El mensaje de la respuesta no puede ser nulo ni vacío.\n");
        if(esVacio(respuestaDat))
            throw new IllegalArgumentException("Los datos de la respuesta no pueden ser nulos ni vacíos.\n");
        
        this.respuestaCod = respuestaCod;
        this.respuestaMsj = respuestaMsj;
        this.respuestaDat = respuestaDat;
    }

    public void setRespuestaCod(int respuestaCod)
    {
        this.respuestaCod = respuestaCod;
    }

    public int getRespuestaCod()
    {
        return respuestaCod;
    }

    public void setRespuestaMsj(String respuestaMsj)
    {
        this.respuestaMsj = respuestaMsj;
    }

    public String getRespuestaMsj()
    {
        return respuestaMsj;
    }

    public void setRespuestaDat(String respuestaDat)
    {
        this.respuestaDat = respuestaDat;
    }

    public String getRespuestaDat()
    {
        return respuestaDat;
    }
}
