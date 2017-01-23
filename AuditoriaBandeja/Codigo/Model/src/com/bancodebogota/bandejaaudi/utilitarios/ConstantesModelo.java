package com.bancodebogota.bandejaaudi.utilitarios;

import java.util.Locale;


public class ConstantesModelo {

    /*
     **********************************************************************************
     *
     * Constantes propias de la aplicación
     *
     **********************************************************************************
     */

    /**
     * Log de la aplicación
     */
    public static final String RUTA_LOG = "logsPPE\\LogsBandejaAUDI\\";
    public static final String NOMBRE_LOG = "LogBandejaAUDI";
    public static final boolean ESCRIBIR_TRAZA_METODOS_EN_LOG = false;

    /** 
     * Locale para formato de fechas y números de la aplicación
     */
    public static final Locale LOCALE = new Locale("es", "CO");
    
    /**
     * Determina si se está desarrollando o no
     */
    public static final boolean DESARROLLANDO = false;
    
    /**
     * Valores de BolsaId
     */
    public static final boolean ES_BOLSA = true;
    public static final boolean NO_ES_BOLSA = false;

    /**
     * Rutas para instanciar modelos con lookup 
     */
    public static final String RUTA_GENERAL_DEL_MODELO = "BandejaAUDIModel#com.bancodebogota.bandejaaudi.sesion.modelogeneral.BandejaAUDIModel";
                                                          
    /**
     * Valores para definir los tipos de acceso a las pantallas y/o pestañas
     */
    public static final String TIPO_ACCESO_EDICION = "E";
    
    
    /**
     * Código y Nombre de la tarea de radicación del Flujo
     * TODO cambiar por las tareas necesarias para Auditorías
     */
     public static final String REALIZAR_PRUEBA_AUDITORIA = "AUDI_REAL_PRUE_AUDI";
     public static final String REVISAR_PRUEBA_AUDITORIA = "AUDI_REV_PRUE_AUDI";
     public static final String NOMBRE_RADICAR_SOLICITUD_CESANTIAS = "RADICAR NUEVA SOLICITUD";
     public static final String CODIGO_TIPO_USUARIO_COOR = "COOR";
     public static final String CODIGO_TIPO_USUARIO_ADMIN = "ADMIN";
    
    /*
     **********************************************************************************
     *
     * Valores de campos en tablas y parámetros de los servicios consumidos
     *
     **********************************************************************************
     */
    
    /**
     * Valores del campo APLICACION de la tabla PPE_APP_PARAMETROS
     */
    public static final String PARAMETROS_APLICACION_WS = "WS";

    /**
     * Valores del campo NOMBRE PARAMETRO de la tabla PPE_APP_PARAMETROS
     */
    public static final String PARAMETROS_NOMBRE_PARAMETRO_WS_MAF = "MAF_WS_V2";
    public static final String PARAMETROS_NOMBRE_PARAMETRO_WS_OFICINAS = "CONSULTA_OFICINAS_V1_1";

    /**
     * TargetNamespace y Name de servicios web consumidos
     */
    public static final String TARGETNAMESPACE_MAF_WS = "http://bancodebogota.com/maf/v2";
    public static final String NAME_MAF_WS = "MafServiceV2";
    public static final String TARGETNAMESPACE_OFICINAS_WS = "http://bancodebogota.com/WSConsultaOficinas/Oficinas/v1_1";
    public static final String NAME_OFICINAS_WS = "OficinasService1_1";
    
    /**
     * Nombres de los campos únicos en las entidades de la apliación (generales)
     */
    public static final String ENTIDAD_CODIGO = "codigo";
    public static final String ENTIDAD_ESTADO = "estado";
    
    /**
     * Valores para campos que definen estados en las entidades
     */
    public static final String ESTADO_ENTIDAD_ACTIVO = "1";
}
