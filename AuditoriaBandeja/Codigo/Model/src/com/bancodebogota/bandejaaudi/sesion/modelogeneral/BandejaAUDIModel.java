package com.bancodebogota.bandejaaudi.sesion.modelogeneral;


import java.util.List;
import java.util.Map.Entry;

import javax.ejb.Remote;


@Remote
public interface BandejaAUDIModel
{
     /**
      * Consulta en la tabla de par�metros un registro definido por la llave primaria compuesta por el nombreCliente de la aplicaci�n y el nombreCliente del par�metro
      * @param nombreAplicacion Nombre de la aplicaci�n
      * @param nombreParametro Nombre del par�metro
      * @return El valor consultado
      * @throws Exception Si no existe el registro con llave primaria compuesta nombreAplicacion y nombreParametro
      */
    public String obtenerValorEnTablaParametros(String nombreAplicacion, String nombreParametro) throws Exception;
    
    /**
     * Consulta las solicitudes que tiene un funcionario asignadas
     * @param listadoIdsTareas Listado de identificadores de base de datos de las tareas
     * @param codigosArea Lista con los c�digos de las �reas
     * @param usuario Usuario NT del Funcionario
     * @param dominio Dominio del Funcionario
     * @return Lista
     * @throws Exception Si ocurre un error consultando las solicitudes que tiene el funcionario asignadas
     */
    public List<?> consultarSolicitudesAsignadasAUnUsuario(List<String> listadoIdsTareas, List<String> codigosArea, String usuario, String dominio) throws Exception;
    
    /**
     * Consulta las solicitudes usuario que se encuentran en asignaci�n bolsa
     * @param listadoIdsTareas Listado de identificadores de base de datos de las tareas
     * @param listadoCodigosAreas Listado de los C�digos de las �reas
     * @param idAplicacion Identificador de base de datos de la Aplicaci�n
     * @return Lista
     * @throws Exception Si ocurre un error consultando las solicitudes usuario que se encuentran en asignaci�n bolsa
     */
    public List<?> consultarSolicitudesEnAsignacionBolsa(List<String> listadoIdsTareas, List<String> listadoCodigosAreas, String idAplicacion) throws Exception;
    
    /**
     * Consulta una entidad actualizada a partir de los valores de atributos �nicos recibidos; la estructura de la consulta es la siguiente:
     * SELECT o FROM {claseEntidad} o WHERE {camposValores separados por AND}
     * @param claseEntidad Clase de la entidad a consultar
     * @param atributosValores Lista de atributos y valores de la entidad a consultar (el valor de un atributo puede ser nulo)
     * @return La entidad consultada
     * @throws NoResultException si la entidad consultada no existe
     * @throws NonUniqueResultException si existe m�s de una entidad
     */
    public Object consultarEntidadPorAtributosUnicos(Class<?> claseEntidad, Entry<String, Object>... atributosValores);
}
