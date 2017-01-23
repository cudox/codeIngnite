package com.bancodebogota.bandejaaudi.webservice.v1;


import com.bancodebogota.bandejaaudi.sesion.ControladorModelo;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import net.sf.json.JSONObject;


@Path("RestfulBandejaAUDI")
public class Bandeja
{

    @GET
    @Produces("application/json;charset=UTF-8")
    public String obtenerDatos(@DefaultValue("1")
        @QueryParam("callback")
        String funcion, @QueryParam("ppe")
        String ppe, @QueryParam("sid")
        String sid, @QueryParam("idrol")
        String idRol, @QueryParam("codeapp")
        String codeapp, @QueryParam("idapp")
        String idAplicacion, @QueryParam("usuario")
        String usuario, @QueryParam("dominio")
        String dominio)
    {
        JSONObject json = new JSONObject();
        json.put("datos", ControladorModelo.getInstance().obenerRegistrosAMostrarEnBandeja(funcion, ppe, sid, idRol, codeapp, idAplicacion, usuario, dominio));
        return funcion + "(" + json.toString() + ")";
    } //obtenerDatos
}
