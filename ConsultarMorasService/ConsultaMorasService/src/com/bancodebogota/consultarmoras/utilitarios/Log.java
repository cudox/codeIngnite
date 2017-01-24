package com.bancodebogota.consultarmoras.utilitarios;


import static com.bancodebogota.consultarmoras.utilitarios.ConstantesModelo.NOMBRE_LOG;
import static com.bancodebogota.consultarmoras.utilitarios.ConstantesModelo.RUTA_LOG;
import static com.bancodebogota.consultarmoras.utilitarios.UtilitariosTexto.esVacio;
import static com.bancodebogota.consultarmoras.utilitarios.UtilitariosTexto.obtenerExcepcionConStackTrace;

import java.io.File;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Log {
    
    //--------------------------------------------------------------------------
    // Atributo de clase
    //--------------------------------------------------------------------------
    
    private Logger logger;
    
    //--------------------------------------------------------------------------
    // Solitario
    //--------------------------------------------------------------------------
    
    private static Log log;
    
    /**
     * Devuelve una instancia �nica de la clase que implementa el Log de la apliaci�n
     * @return instancia �nica del Log de la aplicaci�n
     */
    public static synchronized Log getInstance() 
    {
        if (log == null)
            log = new Log();
        
        return log;
    }//getInstance
    
    /**
     * Sobreescritura de m�todo clone que impide que sea clonado el singleton
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    //--------------------------------------------------------------------------
    // Constructor de clase
    //--------------------------------------------------------------------------
        
    /**
     * Constructor por defecto
     */
    private Log() 
    {        
        try 
        {   
            File carpetaLog = new File(RUTA_LOG);
            if (!carpetaLog.exists())
                carpetaLog.mkdirs();
            
            String rutaYNombreLog = RUTA_LOG + NOMBRE_LOG;
            logger = Logger.getLogger(rutaYNombreLog);
            logger.setLevel(Level.ALL);
            Calendar fechaActual = new GregorianCalendar();
            String fecha = fechaActual.get(Calendar.DATE)+"-"+(fechaActual.get(Calendar.MONTH)+1)+"-"+fechaActual.get(Calendar.YEAR);
            rutaYNombreLog += "_" + fecha + ".log";
            FileHandler handler = new FileHandler(rutaYNombreLog, true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        } 
        catch (Exception e) 
        {
            new IllegalStateException("Ocurri� un error creando el log de la aplicaci�n: "+e.getMessage());
        }
    }//Logs
    
    //--------------------------------------------------------------------------
    // M�todos implementados
    //--------------------------------------------------------------------------
    
    /**
     * Adiciona un mensaje informativo al log
     * @param mensaje Mensaje informativo que se adicionar� al log
     */
    public void info(String mensaje)
    {
        logger.info(esVacio(mensaje) ? "Mensaje vac�o o nulo." : mensaje);
    }//info
    
    /**
     * Adiciona un mensaje de error al log a partir de un mensaje
     * @param mensaje Mensaje de error que se adicionar� al log
     */
    public void severe(String mensaje)
    {
        logger.severe(esVacio(mensaje) ? "Mensaje vac�o o nulo." : mensaje);
    }//severe
    
    /**
     * Adiciona un mensaje de error al log a partir de una exepci�n
     * @param excepcion Excepci�n con la traza del error
     */
    public void severe(Exception excepcion)
    {
        if (excepcion == null)
            throw new IllegalArgumentException("La excepci�n no puede ser nula.\n");
        
        logger.severe(excepcion.getMessage()+"\nDescripci�n t�cnica de la excepci�n: \n"+obtenerExcepcionConStackTrace(excepcion));
    }//severe
  
    /**
     * Adiciona un mensaje de error al log a partir de un mensaje y una exepci�n
     * @param mensaje Mensaje de error que se adicionar� al log
     * @param excepcion Excepci�n con la traza del error
     */
    public void severe(String mensaje, Exception excepcion)
    {
        if (excepcion == null)
            throw new IllegalArgumentException("La excepci�n no puede ser nula.\n");
        
        logger.severe((esVacio(mensaje) ? "Mensaje vac�o o nulo." : mensaje)+"\nMensaje de la excepci�n: "+excepcion.getMessage()+"\nDescripci�n t�cnica de la excepci�n: \n"+obtenerExcepcionConStackTrace(excepcion));
    }//severe
  
}
