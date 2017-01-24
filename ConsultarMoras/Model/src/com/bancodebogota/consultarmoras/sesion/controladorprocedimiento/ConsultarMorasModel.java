package com.bancodebogota.consultarmoras.sesion.controladorprocedimiento;

import java.util.HashMap;

import javax.ejb.Remote;


@Remote
public interface ConsultarMorasModel
{
    public HashMap<String, Object> consultarMoras(String tipoDocumento, String numeroDocumento) throws Exception;
}
