package com.bancodebogota.consultarmoras.utilitarios;

import java.util.Locale;

public class ConstantesModelo
{

    /**
     * Constructor por defecto
     */
    private ConstantesModelo(){}
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
    public static final String RUTA_LOG = "logsPPE\\LogsServicioConsultarMoras\\";
    public static final String NOMBRE_LOG = "LogServicioConsultarMoras";
    public static final boolean ESCRIBIR_TRAZA_METODOS_EN_LOG = false;
    
    /**
     * Locale para formato de fechas y números de la aplicación
     */
    public static final Locale LOCALE = new Locale("es", "CO");
    
    /**
     * Rutas para instanciar modelos con lookup
     */
    public static final String RUTA_MODELO_PROCEDIMIENTO = "jdbc/MDT/MntoCarteraConsolidadaDS";
    
    /**
     * Llamado de procedimiento almacenado
     */
    public static final String LLAMADO_PROCEDIMIENTO = "{call CARTERA.SERVICIOS.CONSULTAR_MORAS(?,?,?,?,?)}";
}
