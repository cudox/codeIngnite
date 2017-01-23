package com.bancodebogota.bandejaaudi.sesion.modelogeneral;


import java.util.List;
import java.util.Map.Entry;

import javax.ejb.Local;


@Local
public interface BandejaAUDIModelLocal
{
    /**
     * @see com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel
     */
    public String obtenerValorEnTablaParametros(String nombreAplicacion, String nombreParametro) throws Exception;
    
    /**
     * @see com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel
     */
     public List<?> consultarSolicitudesAsignadasAUnUsuario(List<String> listadoIdsTareas, List<String> codigosArea, String usuario, String dominio) throws Exception;
    
    /**
     * @see com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel
     */
     public List<?> consultarSolicitudesEnAsignacionBolsa(List<String> listadoIdsTareas, List<String> listadoCodigosAreas, String idAplicacion) throws Exception;
    
    /**
     * @see com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel
     */
    public Object consultarEntidadPorAtributosUnicos(Class<?> claseEntidad, Entry<String, Object>... camposValores);
}
