package com.bancodebogota.consultarmoras.sesion.controladorprocedimiento;

import java.util.HashMap;

import javax.ejb.Local;


@Local
public interface ConsultarMorasModelLocal
{
    public HashMap<String, Object> consultarMoras(String tipoDocumento, String numeroDocumento) throws Exception;
}
