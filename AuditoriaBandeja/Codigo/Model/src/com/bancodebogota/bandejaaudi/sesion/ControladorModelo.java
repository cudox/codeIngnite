package com.bancodebogota.bandejaaudi.sesion;


import com.bancodebogota.bandejaaudi.dtos.servicio.respuesta.ColumnaBandeja;
import com.bancodebogota.bandejaaudi.dtos.servicio.respuesta.RegistroBandeja;
import com.bancodebogota.bandejaaudi.dtos.servicio.respuesta.RespuestaBandeja;
import com.bancodebogota.bandejaaudi.entidades.AppSolicitudUsuario;
import com.bancodebogota.bandejaaudi.entidades.AudiUsuario;
import com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel;
import com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModelBean;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.CODIGO_TIPO_USUARIO_ADMIN;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.CODIGO_TIPO_USUARIO_COOR;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.DESARROLLANDO;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.ENTIDAD_CODIGO;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.ENTIDAD_ESTADO;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.ESTADO_ENTIDAD_ACTIVO;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.ES_BOLSA;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.NO_ES_BOLSA;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.REALIZAR_PRUEBA_AUDITORIA;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.REVISAR_PRUEBA_AUDITORIA;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.RUTA_GENERAL_DEL_MODELO;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.TIPO_ACCESO_EDICION;
import com.bancodebogota.bandejaaudi.utilitarios.Log;
import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;
import com.bancodebogota.maf.ws.types.ValoresArea;
import com.bancodebogota.maf.ws.types.ValoresTareaA;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.naming.InitialContext;


public class ControladorModelo
{
    //--------------------------------------------------------------------------
    // Atributos de clase
    //--------------------------------------------------------------------------

    private BandejaAUDIModel bandejaAUDIModel;

    //--------------------------------------------------------------------------
    // Solitario
    //--------------------------------------------------------------------------

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
     * @throws IllegalStateException Si existe algún error instanciado el controlador
     */
    private ControladorModelo()
    {
        Log.getInstance().infoEjecucionMetodo("ControladorModelo", ControladorModelo.class);

        try
        {
            bandejaAUDIModel = (BandejaAUDIModel) new InitialContext().lookup(RUTA_GENERAL_DEL_MODELO);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Error instanciando el controlador del modelo: " + e.getMessage(), e);
        }
    } //ControladorModelo

    /**
     * Sobreescritura de método clone que impide que sea clonado el singleton
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    //--------------------------------------------------------------------------
    // Métodos implementados
    //--------------------------------------------------------------------------

    /**
     * Reinicia el solitario para volver a instanciar los servicios
     */
    public void reiniciarSolitario()
    {
        controladorModelo = null;
        ControladorConsumoServicios.getInstance().reiniciarSolitario();
    } //reiniciarSolitario

    /**
     * Obtiene los registros a mostrar en la bandeja
     * @param callback Callback del llamado RESTFul
     * @param ppe Parámetro enviado en la URL para auntenticar el usuario en el portal
     * @param sid Parámetro enviado en la URL para auntenticar el usuario en el portal
     * @param idrol Parámetro enviado en la URL el cual es el identificador a nivel de BD del rol
     * @param codeapp Parámetro enviado en la URL el cual es el código de la tarea (debe ser el mismo código de la opción del portal)
     * @param idapp Parámetro enviado en la URL el cual es el identificador a nivel de BD de la aplicación
     * @param usuario Parámetro enviado en la URL del usuario de red del usuario logueado
     * @param dominio Parámetro enviado en la URL del dominio del usuario logueado
     * @return Respuesta que contiene los registros consultados a mostrar en la bandeja
     */
    public RespuestaBandeja obenerRegistrosAMostrarEnBandeja(String callback, String ppe, String sid, String idrol, String codeapp, String idapp, String usuario, String dominio)
    {
        Log.getInstance().infoEjecucionMetodo("obtenerRegistrosAMostrarEnBandeja", BandejaAUDIModelBean.class);

        if (esVacio(callback))
            throw new IllegalArgumentException("El callback no puede ser nulo ni vacío.\n");
        else if (esVacio(ppe))
            throw new IllegalArgumentException("El ppe no puede ser nulo ni vacío.\n");
        else if (esVacio(sid))
            throw new IllegalArgumentException("El sid no puede ser nulo ni vacío.\n");
        else if (esVacio(idrol))
            throw new IllegalArgumentException("El identificador a nivel de BD del rol no puede ser nulo ni vacío.\n");
        else if (esVacio(codeapp))
            throw new IllegalArgumentException("El código de la tarea no puede ser nulo ni vacío.\n");
        else if (esVacio(idapp))
            throw new IllegalArgumentException("El identificador a nivel de BD del la aplicación no puede ser nulo ni vacío.\n");
        else if (esVacio(usuario))
            throw new IllegalArgumentException("El usuario no puede ser nulo ni vacío.\n");
        else if (esVacio(dominio))
            throw new IllegalArgumentException("El dominio no puede ser nulo ni vacío.\n");

        Date tiempoInicial = new Date();
        StringBuilder respuesta = new StringBuilder();
        List<ColumnaBandeja> etiquetas = new ArrayList<ColumnaBandeja>();
        List<RegistroBandeja> registros = new ArrayList<RegistroBandeja>();
        try
        {
            List<ValoresTareaA> tareasXFuncionarioXRol = ControladorConsumoServicios.getInstance().consultarTareasPorFuncionarioPorRol(usuario, dominio, idrol, idapp, "");
            if (tareasXFuncionarioXRol.isEmpty())
                respuesta.append("El funcionario " + usuario + " se encuentra mal parametrizado en MAF.\n");
            else
            {
                Set<String> conjuntoIdsTareas = new HashSet<String>();
                Set<String> conjuntoIdsAreas = new HashSet<String>();
                Map<String,String> conjuntoNombreTareas = new HashMap<String,String>();
                for (ValoresTareaA valoresTareaA : tareasXFuncionarioXRol)
                {
                    conjuntoIdsTareas.add(valoresTareaA.getIdTarea());
                    conjuntoIdsAreas.add(valoresTareaA.getIdArea());
                    conjuntoNombreTareas.put(valoresTareaA.getIdTarea(), valoresTareaA.getNombreTarea());
                }

                List<String> listadoIdsTareas = new ArrayList<String>(conjuntoIdsTareas);
                List<String> listadoCodigosAreas = new ArrayList<String>();
                for (ValoresArea valoresArea : ControladorConsumoServicios.getInstance().consultarAreasPorIds(new ArrayList<String>(conjuntoIdsAreas)))
                    listadoCodigosAreas.add(valoresArea.getCodigoArea());
                
                Map<String, List<AppSolicitudUsuario>> idsTareaYSolicitudes = obtenerMapaDeIdsTareasYListadoSolicitudesUsuario(listadoIdsTareas, listadoCodigosAreas, usuario, dominio);
                Map<String, List<AppSolicitudUsuario>> idsTareaYSolicitudesBolsa = obtenerMapaDeIdsTareasYListadoSolicitudesBolsa(listadoIdsTareas, listadoCodigosAreas, idapp);
                // TODO Revisar esta consulta LNINO8
                //Map<String, String> listaTareasPrevias = obtenerMapadeSolicitudUsuarioYTareaPrevia(idsTareaYSolicitudes, idsTareaYSolicitudesBolsa, idapp);
                //Map<String, AppSolicitudUsuario> listaTareasPrevias = obtenerMapadeSolicitudUsuarioYTareaPrevia(listadoIdsTareas, usuario, dominio, idapp);
                    
                if (!idsTareaYSolicitudes.isEmpty() || !idsTareaYSolicitudesBolsa.isEmpty())
                {
                    //etiquetas = armarEtiquetas();
                    if (!idsTareaYSolicitudes.isEmpty())
                        registros.addAll(construirRegistrosBandejaDeSolicitudesUsuario(conjuntoNombreTareas, tareasXFuncionarioXRol, idsTareaYSolicitudes, usuario, ppe, sid, idrol, NO_ES_BOLSA, codeapp, idapp));

                    if (!idsTareaYSolicitudesBolsa.isEmpty())
                        registros.addAll(construirRegistrosBandejaDeSolicitudesUsuario(conjuntoNombreTareas, tareasXFuncionarioXRol, idsTareaYSolicitudesBolsa, usuario, ppe, sid, idrol, ES_BOLSA, codeapp, idapp));
                }
                else
                    respuesta.append("No hay registros para mostrar.\n");
            }
        }
        catch (Exception e)
        {
            if (e.getMessage() == null)
                respuesta.append("Error GRAVE: excepción nula.\n");
            else
                respuesta.append(e.getMessage());

            Log.getInstance().severe(e);
        }
        
        //
        AudiUsuario audiUsuario = (AudiUsuario)bandejaAUDIModel.consultarEntidadPorAtributosUnicos(AudiUsuario.class, new SimpleEntry<String, Object>(ENTIDAD_CODIGO, usuario.toUpperCase()), new SimpleEntry<String, Object>(ENTIDAD_ESTADO, ESTADO_ENTIDAD_ACTIVO));
        RespuestaBandeja respuestaServicio = respuesta.toString().isEmpty() ? new RespuestaBandeja("0", "La consulta se realizó con éxtio.\n", true, armarEtiquetas(audiUsuario.getAudiTipousuario().getCodigo(), codeapp), registros) : new RespuestaBandeja("1", respuesta.toString(), false, etiquetas, registros);
        if (DESARROLLANDO)
            Log.getInstance().info("Respuesta del WS para la operación 'obtenerRegistrosAMostrarEnBandeja': " + respuestaServicio.getDescripcion() + ". Tiempo en segundos: " + (new Date().getTime() - tiempoInicial.getTime()) / 1000);

        return respuestaServicio;
    } //obtenerRegistrosAMostrarEnBandeja
    
    /**
     * Construye los registros a mostrar en la bandeja por appSolicitud de usuario
     * @param tareasXFuncionarioXRol Lista de tareas de un funcinario por rol
     * @param idsTareasYSolicitudes Mapa que contiene en la llave el identificador a nivel de BD de la tarea y en el valor la lista de las solicitudes a mostrar (solicitudes hijas agrupadas por padre)
     * @param usuario Usuario al que pertenecen los registros a consultar
     * @param ppe Parámetro del PPE
     * @param sid Parámetro del PPE
     * @param idrol identificador a nivel de BD del rol
     * @param bolsa Determina si es bolsa o no
     * @param codeapp Código de la aplicación en el PPE
     * @param idapp Identificador a nivel de BD de la aplicación
     * @return Lista que contiene la información de los refguistros a pintar en la bandeja
     * @throws Exception Si ocurre algún error consultando la tarea en MAF
     */
    private List<RegistroBandeja> construirRegistrosBandejaDeSolicitudesUsuario(Map<String, String> nombresYIDsTareasMAF, List<ValoresTareaA> tareasXFuncionarioXRol, Map<String, List<AppSolicitudUsuario>> idsTareasYSolicitudes, String usuario, String ppe, String sid, String idrol, boolean bolsa, String codeapp, String idapp) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("construirRegistrosBandejaDeSolicitudesUsuario", BandejaAUDIModelBean.class);

        List<RegistroBandeja> registrosBandeja = new ArrayList<RegistroBandeja>();
        StringBuilder url = new StringBuilder();
        String nombreTarea;
        for (Entry<String, List<AppSolicitudUsuario>> codigoTareaYSolicitudes : idsTareasYSolicitudes.entrySet())
        {
            url.setLength(0);
            url.append(obtenerURLYCodeAppDeTareaEnLista(tareasXFuncionarioXRol, codigoTareaYSolicitudes.getKey()));
            if (url.indexOf("?") != -1)
                url.append("&");
            else
                url.append("?");

            for (AppSolicitudUsuario solicitudUsuario : codigoTareaYSolicitudes.getValue())
            {
                nombreTarea = consultarNombreDeTareaMAF(nombresYIDsTareasMAF, solicitudUsuario.getIdTarea());
                String usuarioPrevio = (solicitudUsuario.getAppSolicitudUsuario() != null) ? solicitudUsuario.getAppSolicitudUsuario().getUsuario() : "N/A";
                if (bolsa)
                    registrosBandeja.add(new RegistroBandeja(nombreTarea, solicitudUsuario, url.toString() + "solicitudId=" + solicitudUsuario.getAppSolicitud().getId() + "&usuario=" + usuario + "&ppe=" + ppe + "&sid=" + sid + "&idrol=" + idrol + "&TA=" + TIPO_ACCESO_EDICION + "&idapp=" + idapp, solicitudUsuario.getId(), usuarioPrevio));
                else
                    registrosBandeja.add(new RegistroBandeja(nombreTarea, solicitudUsuario, url.toString() + "solicitudId=" + solicitudUsuario.getAppSolicitud().getId() + "&usuario=" + usuario + "&ppe=" + ppe + "&sid=" + sid + "&idrol=" + idrol + "&TA=" + TIPO_ACCESO_EDICION + "&idapp=" + idapp, "0", usuarioPrevio));
            }
        }
        return registrosBandeja;
    } //construirRegistrosBandejaDeSolicitudesUsuario

    /**
     * Obtiene la URL asociada a una tarea concatenada con el códido (codeapp), que se busca por el id de la tarea en una lista de tareas
     * @param tareasXFuncionarioXRol Lista de tareas del funcionario y por rol
     * @param idTarea Identificador a nivel de BD de la tarea a buscar en la lista
     * @return URL asociada a la tarea de MAF
     * @throws Exception Si la tarea no existe en la lista
     */
    private String obtenerURLYCodeAppDeTareaEnLista(List<ValoresTareaA> tareasXFuncionarioXRol, String idTarea) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("obtenerURLYCodeAppDeTareaEnLista", BandejaAUDIModelBean.class);

        if (tareasXFuncionarioXRol == null || tareasXFuncionarioXRol.isEmpty())
            throw new IllegalArgumentException("La lista de información de las tareas no puede ser nulo ni vacío.\n");
        else if (esVacio(idTarea))
            throw new IllegalArgumentException("El Identificador a nivel de BD de la tarea no puede ser nulo ni vacío.\n");

        for (ValoresTareaA valoresTareaA : tareasXFuncionarioXRol)
        {
            if (valoresTareaA.getIdTarea().equals(idTarea))
                return valoresTareaA.getUrl() + "?codeapp=" + valoresTareaA.getCodigoTarea();
        }

        throw new Exception("La tarea con identificador a nivel de BD '" + idTarea + "' no existe en la lista enviada.\n");
    } //obtenerURLDeTareaEnLista

    /**
     * Construye un Mapa con el listado de solicitudes de un usuario relacionadas a una tarea
     * @param listadoIdsTareas Listado de identificadores a nivel de BD de las tareas
     * @param listadoCodigosAreas Listado de identificadores a nivel de BD de las tareas
     * @param usuario Usuario NT
     * @param dominio Dominio del usuario
     * @return Mapa que contiene en la llave el id de la tarea y en el valor el listado de solicitudes usuario asociados a la tarea
     * @throws Exception Si ocurre un error construyendo el mapa de solicitudes y tareas
     */
    private Map<String, List<AppSolicitudUsuario>> obtenerMapaDeIdsTareasYListadoSolicitudesUsuario(List<String> listadoIdsTareas, List<String> listadoCodigosAreas, String usuario, String dominio) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("obtenerMapaDeIdsTareasYListadoSolicitudesUsuario", BandejaAUDIModelBean.class);

        if (listadoIdsTareas == null || listadoIdsTareas.isEmpty())
            throw new IllegalArgumentException("El listado de identificadores a nivel de BD de las tareas no puede ser nulo ni vacío.\n");
        else if (esVacio(dominio))
            throw new IllegalArgumentException("El dominio no puede ser nulo ni vacío.\n");
        else if (esVacio(usuario))
            throw new IllegalArgumentException("El usuario no puede ser nulo ni vacío.\n");

        Map<String, List<AppSolicitudUsuario>> idsTareasYSolicitudes = new HashMap<String, List<AppSolicitudUsuario>>();
        for (AppSolicitudUsuario solicitudUsuario : (List<AppSolicitudUsuario>) bandejaAUDIModel.consultarSolicitudesAsignadasAUnUsuario(listadoIdsTareas, listadoCodigosAreas, usuario, dominio))
        {
            if (!idsTareasYSolicitudes.containsKey(solicitudUsuario.getIdTarea()))
                idsTareasYSolicitudes.put(solicitudUsuario.getIdTarea(), new ArrayList<AppSolicitudUsuario>());

            idsTareasYSolicitudes.get(solicitudUsuario.getIdTarea()).add(solicitudUsuario);
        }

        return idsTareasYSolicitudes;
    } //obtenerMapaDeIdsTareasYListadoSolicitudesUsuario

    /**
     * Construye un Mapa con el listado de solicitudes usuario que se encuentran en bolsa relacionadas a una Tarea
     * @param listadoIdsTareas Listado de identificadores de base de datos de las tareas
     * @param listadoCodigosAreas Listado de los Códigos de las Áreas
     * @param idAplicacion Identificador de base de datos de la Aplicación
     * @return Mapa con el listados de solicitudes en bolsa relacionadas a una Tarea
     * @throws Exception Si ocurre un error construyendo el Mapa de solicitudes usuario que se encuentran en bolsa
     */
    private Map<String, List<AppSolicitudUsuario>> obtenerMapaDeIdsTareasYListadoSolicitudesBolsa(List<String> listadoIdsTareas, List<String> listadoCodigosAreas, String idAplicacion) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("obtenerMapaDeIdsTareasYListadoSolicitudesBolsa", BandejaAUDIModelBean.class);

        if (listadoIdsTareas == null || listadoIdsTareas.isEmpty())
            throw new IllegalArgumentException("El listado de identificadores a nivel de base de datos de las Tareas no puede ser nulo ni vacío.\n");
        else if (listadoCodigosAreas == null || listadoCodigosAreas.isEmpty())
            throw new IllegalArgumentException("El listado de los códigos de las Areas no puede ser nulo ni vacío.\n");
        else if (esVacio(idAplicacion))
            throw new IllegalArgumentException("El identificador a nivel de base de datos de la aplicación no puede ser nulo ni vacío.\n");

        Map<String, List<AppSolicitudUsuario>> idsTareasYSolicitudes = new HashMap<String, List<AppSolicitudUsuario>>();
        for (AppSolicitudUsuario solicitudUsuario : (List<AppSolicitudUsuario>) bandejaAUDIModel.consultarSolicitudesEnAsignacionBolsa(listadoIdsTareas, listadoCodigosAreas, idAplicacion))
        {
            if (!idsTareasYSolicitudes.containsKey(solicitudUsuario.getIdTarea()))
                idsTareasYSolicitudes.put(solicitudUsuario.getIdTarea(), new ArrayList<AppSolicitudUsuario>());

            idsTareasYSolicitudes.get(solicitudUsuario.getIdTarea()).add(solicitudUsuario);
        }

        return idsTareasYSolicitudes;
    } //obtenerMapaDeIdsTareasYListadoSolicitudesBolsa
    
    /**
     * Consulta el nombre de la tarea de MAF por el ID de la tarea
     * @param nombresYIDsTareasMAF Contiene los IDS y los nombres de las tareas de MAF obtenidas en el servicio
     * @param tareaID Identificador de la tarea de MAF que se desea encontrar en el mapa.
     * @return nombreTarea Nombre de la tarea de MAF
     * @throws Exception Si ocurre un error al recorrer el mapa o si no se encuentra el ID en el.
     * */
    private String consultarNombreDeTareaMAF(Map<String, String> nombresYIDsTareasMAF, String tareaID) throws Exception {
        for (Entry<String, String> nombreYIDTareaMAF : nombresYIDsTareasMAF.entrySet()){
            if(tareaID.equals(nombreYIDTareaMAF.getKey())){
                return nombreYIDTareaMAF.getValue();
            }
        }
        throw new Exception("La tarea con identificador '" + tareaID + "' no se encontro en la lista obtenidad del Servicio de MAF.\n");
    }
    
    /**
     * Arma las Etiquetas que van en la bandeja
     * @return Lista con las etiquetas que muestra la bandeja
     * */
    private List<ColumnaBandeja> armarEtiquetas(String codigoTipoUsuario, String codigoTarea){
        if (esVacio(codigoTipoUsuario))
            throw new IllegalArgumentException("El código del tipo de usuario no puede ser nulo ni vacío.\n");
        if (esVacio(codigoTarea))
            throw new IllegalArgumentException("El código de la tare no puede ser nulo ni vacío.\n");
        
        List<ColumnaBandeja> etiquetas = new ArrayList<ColumnaBandeja>();
        etiquetas.add(new ColumnaBandeja("numeroSolicitud", "N° Solicitud", ""));
        etiquetas.add(new ColumnaBandeja("codigoObjeto", "Código objeto", ""));
        etiquetas.add(new ColumnaBandeja("nombreObjeto", "Nombre objeto", ""));
        etiquetas.add(new ColumnaBandeja("fechaProgramadaInicio", "Fecha programada inicio", ""));
        etiquetas.add(new ColumnaBandeja("fechaProgramadaFin", "Fecha programada fin", ""));
        if(REALIZAR_PRUEBA_AUDITORIA.equals(codigoTarea) || REVISAR_PRUEBA_AUDITORIA.equals(codigoTarea))
            etiquetas.add(new ColumnaBandeja("nombrePrueba", "Nombre prueba", ""));
        if(CODIGO_TIPO_USUARIO_COOR.equals(codigoTipoUsuario) || CODIGO_TIPO_USUARIO_ADMIN.equals(codigoTipoUsuario))
            etiquetas.add(new ColumnaBandeja("analista", "Analista", ""));
        etiquetas.add(new ColumnaBandeja("estadoObjeto", "Estado", ""));        
        etiquetas.add(new ColumnaBandeja("nombreTarea", "Nombre de la Tarea", "hide nombreTarea"));
        etiquetas.add(new ColumnaBandeja("estado", "Estado Tarea", "hide estadoTarea"));
        etiquetas.add(new ColumnaBandeja("url", "url", "hide url"));
        etiquetas.add(new ColumnaBandeja("bolsaId", "bolsaId", "hide bolsaId"));
        return etiquetas;
    }//armarEtiquetas
}
