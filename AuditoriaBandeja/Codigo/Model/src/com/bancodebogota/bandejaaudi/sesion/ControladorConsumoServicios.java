package com.bancodebogota.bandejaaudi.sesion;


import com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.NAME_MAF_WS;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.PARAMETROS_APLICACION_WS;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.PARAMETROS_NOMBRE_PARAMETRO_WS_MAF;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.RUTA_GENERAL_DEL_MODELO;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.TARGETNAMESPACE_MAF_WS;
import com.bancodebogota.bandejaaudi.utilitarios.Log;
import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;
import com.bancodebogota.maf.MafServiceV2;
import com.bancodebogota.maf.MafServiceV2_Service;
import com.bancodebogota.maf.ws.types.ListaValoresArea;
import com.bancodebogota.maf.ws.types.ListaValoresTareaA;
import com.bancodebogota.maf.ws.types.ValorTarea;
import com.bancodebogota.maf.ws.types.ValoresArea;
import com.bancodebogota.maf.ws.types.ValoresTareaA;

import java.net.URL;

import java.util.List;

import javax.naming.InitialContext;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;


class ControladorConsumoServicios
{
    //--------------------------------------------------------------------------
    // Atributos de clase
    //--------------------------------------------------------------------------

    private MafServiceV2 servicioMAF;

    //--------------------------------------------------------------------------
    // Solitario
    //--------------------------------------------------------------------------

    private static ControladorConsumoServicios controladorConsumoServicios;

    /**
     * Devuelve una instancia única de la clase que implementa el controlador del consumo de servivios
     * @return instancia única del controlador del consumo de servivios
     * @throws WebServiceException Si no es posible obtener el controlador del consumo de servivios
     */
    static synchronized ControladorConsumoServicios getInstance()
    {
        if (controladorConsumoServicios == null)
            controladorConsumoServicios = new ControladorConsumoServicios();

        return controladorConsumoServicios;
    } //getInstance

    //--------------------------------------------------------------------------
    // Constructor de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     * @throws WebServiceException Si existe algún error instanciado el controlador
     */
    private ControladorConsumoServicios()
    {
        Log.getInstance().infoEjecucionMetodo("ControladorConsumoServicios", ControladorConsumoServicios.class);

        try
        {
            BandejaAUDIModel bandejaAUDIModel = (BandejaAUDIModel) new InitialContext().lookup(RUTA_GENERAL_DEL_MODELO);
            instanciarServicioMAF(bandejaAUDIModel);
        }
        catch (Exception e)
        {
            throw new WebServiceException("Error instanciando el controlador del consumo de servivios: " + e.getMessage(), e);
        }
    } //ControladorConsumoServicios

    /**
     * Instancia el servicio de MAF
     * @param bandejaAUDIModel Modelo para realizar consultas en la tabla de parámetros
     * @throws Exception Si ocurre un error instanciando el servicio
     */
    private void instanciarServicioMAF(BandejaAUDIModel bandejaAUDIModel) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("instanciarServicioMAF", ControladorConsumoServicios.class);

        if (bandejaAUDIModel == null)
            throw new IllegalArgumentException("El modelo no puede ser nulo.\n");

        try
        {
            URL uRLServicio = new URL(bandejaAUDIModel.obtenerValorEnTablaParametros(PARAMETROS_APLICACION_WS, PARAMETROS_NOMBRE_PARAMETRO_WS_MAF));
            servicioMAF = new MafServiceV2_Service(uRLServicio, new QName(TARGETNAMESPACE_MAF_WS, NAME_MAF_WS)).getMafServiceV2Port();
            if (servicioMAF == null)
                throw new Exception("Se obtuvo una instancia vacía luego de obtener el puerto.\n");
        }
        catch (Exception e)
        {
            throw new Exception("Error instanciando el servicio de MAF: " + e.getMessage(), e);
        }
    } //instanciarServicioMAF

    //--------------------------------------------------------------------------
    // Métodos implementados
    //--------------------------------------------------------------------------

    /**
     * Reinicia el solitario para volver a instanciar los servicios
     */
    void reiniciarSolitario()
    {
        controladorConsumoServicios = null;
    } //reiniciarSolitario

    /**
     * Consume el servicio de MAF para consultar los datos de las tareas a las que un usuario tiene permisos
     * @param usuario Usuario NT del usuario a consultar
     * @param dominio Dominio al que pertenece el usuario
     * @param idRol Identificador a nivel de BD del rol (Es opcional, si se envía lista solo la tarea asociada al rol, sino lista todas las tareas)
     * @param idAplicacion Identificador a nivel de BD de la aplicación
     * @param validarHorario Valida que este en un horario especifico si se requiere (Es opcional)
     * @return Lista con la información de la tarea o de las tareas consultadas
     * @throws Exception Si ocurre algún error consumiendo el servicio o si no se encuentran tareas con la información enviada
     */
    List<ValoresTareaA> consultarTareasPorFuncionarioPorRol(String usuario, String dominio, String idRol, String idAplicacion, String validarHorario) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("consultarTareasPorFuncionarioPorRol", ControladorConsumoServicios.class);

        if (esVacio(usuario))
            throw new IllegalArgumentException("El usuario no puede ser nulo ni vacío.\n");
        else if (esVacio(dominio))
            throw new IllegalArgumentException("El dominio no puede ser nulo ni vacío.\n");
        else if (esVacio(idAplicacion))
            throw new IllegalArgumentException("El identificador a nivel de BD de la aplicación no puede ser nulo ni vacío.\n");

        ListaValoresTareaA respuestaServicio = servicioMAF.obtenerTareasXFuncionarioXRol(usuario, dominio, idRol, idAplicacion, validarHorario);
        if (respuestaServicio.getCodigo().equalsIgnoreCase("1"))
            throw new Exception(respuestaServicio.getDescripcion() + " (Servicio de MAF -> obtenerTareasXFuncionarioXRol).\n");
        else if (respuestaServicio.getListaValoresTareaA() == null || respuestaServicio.getListaValoresTareaA().isEmpty())
            throw new Exception("La lista de tareas asociadas al usuario '" + usuario + "', dominio '" + dominio + "', identificador a nivel de BD del rol '" + idRol + "', identificador a nivel de BD de la aplicaión '" + idAplicacion + "' y validar horario '" + validarHorario + "' es nula o vacía . (Servicio de MAF -> obtenerTareasXFuncionarioXRol).\n");

        return respuestaServicio.getListaValoresTareaA();
    } //consultarTareasPorFuncionarioPorRol

    /**
     * Consume el servicio de MAF para obtener los datos de una tarea consultada por el identificador a nivel de BD
     * @param idTarea Identificador a nivel de BD de la la tarea a consultar
     * @return datos de la tarea consultada
     * @throws Exception Si ocurre algún error consumiendo el servicio o si no existe la tarea a consultar
     */
    ValoresTareaA consultarTareaPorId(String idTarea) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("consultarTareaPorId", ControladorConsumoServicios.class);

        if (esVacio(idTarea))
            throw new IllegalArgumentException("El identificador a nivel de BD de la tarea no puede ser nulo ni vacío.\n");

        ValorTarea respuestaServicio = servicioMAF.obtenerDatosTarea(idTarea);
        if (!respuestaServicio.getCodigo().equals("0"))
            throw new Exception(respuestaServicio.getDescripcion() + " (Servicio de MAF -> obtenerDatosTarea).\n");
        else if (respuestaServicio.getValoresTareasA() == null)
            throw new Exception("No existe la tarea con identificador a nivel de BD '" + idTarea + "'. (Servicio de MAF -> obtenerDatosTarea).\n");

        return respuestaServicio.getValoresTareasA();
    } //consultarTareaPorId

    /**
     * Consume el servicio de MAF para consultar los datos de las áreas en MAF apartir de un listado de identificadores a nivel de BD de áreas
     * @param listadoIdsAreas Listado de identificadores a nivel de BD de áreas
     * @return Listado con la información de las áreas consultadas
     * @throws Exception Si ocurre algún error consumiendo el servicio o si no existe las áreas a consultar
     */
    List<ValoresArea> consultarAreasPorIds(List<String> listadoIdsAreas) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("consultarEnMAFCodigosDeAreasPorIds", ControladorConsumoServicios.class);

        if (listadoIdsAreas == null || listadoIdsAreas.isEmpty())
            throw new IllegalArgumentException("La lista de identificadores a nivel de BD de las áreas no puede ser nula ni vacía.\n");

        ListaValoresArea respuestaServicio = servicioMAF.obtenerAreas(listadoIdsAreas);
        if (respuestaServicio.getCodigo().equalsIgnoreCase("1"))
            throw new Exception(respuestaServicio.getDescripcion() + " (Servicio de MAF -> obtenerAreas).\n");
        else if (respuestaServicio.getListaValoresArea() == null || respuestaServicio.getListaValoresArea().isEmpty())
            throw new Exception("La lista de áreas consultadas en MAF es nula o vacía . (Servicio de MAF -> obtenerAreas).\n");

        return respuestaServicio.getListaValoresArea();
    } //consultarAreasPorIds

}
