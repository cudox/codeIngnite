package com.bancodebogota.bandejaaudi.sesion.modelogeneral;


import com.bancodebogota.bandejaaudi.utilitarios.Log;
import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(name = "BandejarAUDIModel", mappedName = "BandejaAUDIModel")
public class BandejaAUDIModelBean implements BandejaAUDIModel, BandejaAUDIModelLocal
{

    /** em - Adminsitrador de persistencia de las entidades */
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    //--------------------------------------------------------------------------
    // Métodos de clase
    //--------------------------------------------------------------------------

    /**
     * @see com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel
     */
    public List<?> consultarSolicitudesAsignadasAUnUsuario(List<String> listadoIdsTareas, List<String> listadoCodigosArea, String usuario, String dominio) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("consultarSolicitudesUsuario", BandejaAUDIModelBean.class);

        if (listadoIdsTareas == null || listadoIdsTareas.isEmpty())
            throw new IllegalArgumentException("La lista de identificadores a nivel de BD de las tareas no puede ser nula ni vacía.\n");
        if (listadoCodigosArea == null || listadoCodigosArea.isEmpty())
            throw new IllegalArgumentException("La lista de códigos de áreas no puede ser nula ni vacía.\n");
        else if (esVacio(dominio))
            throw new IllegalArgumentException("El dominio no puede ser nulo ni vacío.\n");
        else if (esVacio(usuario))
            throw new IllegalArgumentException("El usuario no puede ser nulo ni vacío.\n");

        List<?> solicitudesConsultadas;
        try
        {
            String consulta = "";
            consulta += "SELECT su ";
            consulta += "FROM AppSolicitudUsuario su ";
            consulta += "WHERE su.idTarea IN :idsTarea ";
            consulta += "AND su.area IN :codigosArea ";
            consulta += "AND su.usuario =:usuario ";
            consulta += "AND su.dominio =:dominio ";
            consulta += "AND su.visible =:visible ";
            consulta += "AND su.visibleBandeja =:visible ";

            Query query = em.createQuery(consulta);
            query.setParameter("idsTarea", listadoIdsTareas);
            query.setParameter("codigosArea", listadoCodigosArea);
            query.setParameter("usuario", usuario.toUpperCase());
            query.setParameter("dominio", dominio.toUpperCase());
            query.setParameter("visible", true);
            solicitudesConsultadas = query.getResultList();
        }
        catch (Exception e)
        {
            throw new Exception("Ocurrió un error consultando las solicitudes usuario: " + e.getMessage(), e);
        }

        return solicitudesConsultadas;
    } //consultarSolicitudesUsuario

    /**
     * @see com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel
     */
    public List<?> consultarSolicitudesEnAsignacionBolsa(List<String> listadoIdsTareas, List<String> listadoCodigosAreas, String idAplicacion) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("consultarSolicitudesBolsa", BandejaAUDIModelBean.class);

        if (listadoIdsTareas == null || listadoIdsTareas.isEmpty())
            throw new IllegalArgumentException("La lista de identificadores a nivel de BD de las tareas no puede ser nula ni vacia.\n");
        else if (listadoCodigosAreas == null || listadoCodigosAreas.isEmpty())
            throw new IllegalArgumentException("El listado de los códigos de las Areas no puede ser nulo ni vacío.\n");
        else if (esVacio(idAplicacion))
            throw new IllegalArgumentException("El identificador a nivel de base de datos de la aplicación no puede ser nulo ni vacío.\n");

        List<?> solicitudesBolsaConsultadas;
        try
        {
            String where = "";
            if (listadoCodigosAreas.size() == 1)
                where = "SB.area in :codigosAreas AND SB.idTarea in :idTareas AND ";
            else if (listadoCodigosAreas.size() > 1)
            {
                for (int i = 0; i < listadoCodigosAreas.size(); i++)
                {
                    if (i != 0)
                        where += " OR ";

                    if (i == 0)
                        where += "(";

                    where = where + "(SB.area = '" + listadoCodigosAreas.get(i) + "' AND SB.idTarea = '" + listadoCodigosAreas.get(i) + "')";
                    if (i == listadoCodigosAreas.size() - 1)
                        where += ") AND ";
                }
            }

            String consulta = "";
            consulta += "SELECT SB ";
            consulta += "FROM AppSolicitudUsuario SB ";
            consulta += "WHERE " + where + " SB.visible = :visible AND SB.visibleBandeja = :visible AND SB.bolsa= :bolsa ";
            consulta += "AND SB.appSolicitud.appAplicacion.id = :idApp ";
            consulta += "ORDER BY SB.appSolicitud.prioritaria DESC ";
            Query query = em.createQuery(consulta);
            query.setParameter("visible", true);
            query.setParameter("bolsa", true);
            query.setParameter("idApp", idAplicacion);
            if (listadoCodigosAreas.size() == 1)
            {
                query.setParameter("idTareas", listadoIdsTareas);
                query.setParameter("codigosAreas", listadoCodigosAreas);
            }

            solicitudesBolsaConsultadas = query.getResultList();
        }
        catch (Exception e)
        {
            throw new Exception("Ocurrió un error consultando las solicitudes usuario: " + e.getMessage(), e);

        }
        return solicitudesBolsaConsultadas;
    } //consultarSolicitudesBolsa

    /**
     * @see com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel
     */
    public String obtenerValorEnTablaParametros(String nombreAplicacion, String nombreParametro) throws Exception
    {
        Log.getInstance().infoEjecucionMetodo("obtenerValorEnTablaParametros", BandejaAUDIModelBean.class);

        if (esVacio(nombreAplicacion))
            throw new IllegalArgumentException("El nombre de la aplicación no puede ser nulo ni vacío.\n");
        else if (esVacio(nombreParametro))
            throw new IllegalArgumentException("El nombre del parámetro no puede ser nulo ni vacío.\n");

        try
        {
            String consulta = "SELECT p.valor FROM PpeAppParametros p where p.aplicacion =:nombreAplicacion AND p.nombreparametro =:nombreParametro";
            Query query = em.createQuery(consulta);
            query.setParameter("nombreAplicacion", nombreAplicacion);
            query.setParameter("nombreParametro", nombreParametro);
            String valor = (String) query.getSingleResult();
            return valor;
        }
        catch (NoResultException e)
        {
            throw new Exception("El valor en la tabla de parámetros para la llave compuesta nombreAplicacion='" + nombreAplicacion + "' y nombreParametro='" + nombreParametro + "', no existe, por favor actualice y vuelva a intentar.\n", e);
        }
        catch (NonUniqueResultException e)
        {
            throw new Exception("El valor en la tabla de parámetros para la llave compuesta nombreAplicacion='" + nombreAplicacion + "' y nombreParametro='" + nombreParametro + "', tiene mas de un resultado, por favor actualice y vuelva a intentar.\n", e);
        }
    } //obtenerValorEnTablaParametros

    /**
     * @see com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel
     */
    public Object consultarEntidadPorAtributosUnicos(Class<?> claseEntidad, Entry<String, Object>... atributosValores)
    {
        if (claseEntidad == null)
            throw new IllegalArgumentException("La clase de la entidad a consultar no puede ser nula.\n");
        else if (atributosValores == null || atributosValores.length == 0)
            throw new IllegalArgumentException("La lista de atributos valores de la entidad a consultar no puede ser nula ni vacía.\n");

        Entry<Query, StringBuilder> queryYMensajeCamposValores = construirQueryYMensajeCamposValores(claseEntidad, atributosValores);
        try
        {
            return queryYMensajeCamposValores.getKey().getSingleResult();
        }
        catch (NoResultException e)
        {
            throw new NoResultException("La entidad '" + claseEntidad.getSimpleName() + "' con " + queryYMensajeCamposValores.getValue().substring(0, queryYMensajeCamposValores.getValue().length() - 2) + " no existe, por favor actualice y vuelva a intentar: " + e.getMessage());
        }
        catch (NonUniqueResultException e)
        {
            throw new NonUniqueResultException("La entidad '" + claseEntidad.getSimpleName() + "' con " + queryYMensajeCamposValores.getValue().substring(0, queryYMensajeCamposValores.getValue().length() - 2) + " tiene mas de un resultado, por favor actualice y vuelva a intentar: " + e.getMessage());
        }
    } //consultarEntidadPorCamposUnicos
    
    /**
     * Construye el query y el mensaje asociado a una consulta de una entidad por campos y valores
     * @param claseEntidad Clase de la entidad a consultar
     * @param atributosValores Lista de atributos y valores de la entidad a consultar (el valor de un atributo puede ser nulo)
     * @return entry que contiene en la llave el query listo para ser ejecutado con getSingleResult o getResultList, y en el valor el mensaje de los atributos y valores asociados a la consulta
     */
    private Entry<Query, StringBuilder> construirQueryYMensajeCamposValores(Class<?> claseEntidad, Entry<String, Object>... atributosValores)
    {
        if (claseEntidad == null)
            throw new IllegalArgumentException("La clase de la entidad a consultar no puede ser nula.\n");
        else if (atributosValores == null || atributosValores.length == 0)
            throw new IllegalArgumentException("La lista de atributos valores de la entidad a consultar no puede ser nula ni vacía.\n");

        StringBuilder mensajesCamposValores = new StringBuilder();
        StringBuilder camposValoresCondicion = new StringBuilder();
        int contadorParametros = 0;
        for (Entry<String, Object> campoValor : atributosValores)
        {
            camposValoresCondicion.append("o." + campoValor.getKey() + " ");
            mensajesCamposValores.append(campoValor.getKey() + " ");
            if (campoValor.getValue() == null)
            {
                camposValoresCondicion.append("IS NULL AND ");
                mensajesCamposValores.append("nulo, ");
            }
            else
            {
                camposValoresCondicion.append("=:parametro" + contadorParametros + " AND ");
                mensajesCamposValores.append("='" + campoValor.getValue().toString() + "', ");
                contadorParametros++;
            }
        }

        String consulta = "SELECT o FROM " + claseEntidad.getSimpleName() + " o WHERE " + camposValoresCondicion.substring(0, camposValoresCondicion.length() - 5);
        Query query = em.createQuery(consulta);
        contadorParametros = 0;
        for (Entry<String, Object> campoValor : atributosValores)
        {
            if (campoValor.getValue() != null)
            {
                query.setParameter("parametro" + contadorParametros, campoValor.getValue());
                contadorParametros++;
            }
        }

        return new SimpleEntry<Query, StringBuilder>(query, mensajesCamposValores);
    } //construirQueryYMensajeCamposValores
}
