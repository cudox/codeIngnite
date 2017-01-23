package com.bancodebogota.bandejaaudi.utilitarios;


import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.LOCALE;
import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


public class UtilitariosFecha
{
    // -------------------------------------------------------------------------
    // Constantes de clase
    // -------------------------------------------------------------------------

    /** formateadores para las fechas */
    public static final SimpleDateFormat formateadorAnioMesDia = new SimpleDateFormat("yyyy/MM/dd");
    public static final SimpleDateFormat formateadorNombreDiaSemanaDiaMesAnioLocal = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", LOCALE);
    public static final SimpleDateFormat formateadorNombreDiaMesAnioLocal = new SimpleDateFormat("d 'de' MMMM 'de' yyyy", LOCALE);
    public static final SimpleDateFormat formateadorDiaMesAnioLocal = new SimpleDateFormat("d 'días del mes de' MMMM 'de' yyyy", LOCALE);
    public static final SimpleDateFormat formateadorNombreMesAnioLocal = new SimpleDateFormat("MMMM/yyyy", LOCALE);
    public static final SimpleDateFormat formateadorConMilisLocal = new SimpleDateFormat("EEE-dd-'a_las'-HH-'horas'-mm-'minutos'-ss-'segundos'-SSS-'milis'", LOCALE);
    public static final SimpleDateFormat formateadorHorasMinsSegsLocal = new SimpleDateFormat("HH:mm:ss", LOCALE);
    public static final SimpleDateFormat formateadorHorasMins = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat formateadorHorasMinsAmPm = new SimpleDateFormat("hh:mm a");
    public static final SimpleDateFormat formateadorDiaMesAnio = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat formateadorDiaMesAnioHorasMinutosSegundos = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    public static final SimpleDateFormat formateadorDiaMesAnioHorasMinutosAmPm = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
    public static final SimpleDateFormat formateadorAnioMesDiaConGuion = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat formateadorDiaMesAnioConGuion = new SimpleDateFormat("dd-MM-yyyy");

    // -------------------------------------------------------------------------
    // Métodos de clase
    // -------------------------------------------------------------------------

    /**
     * Convierte una fecha en formato de cadena a formato Date
     * @param cadena Cadena de la fecha
     * @param formateador Formataeador para formatear la cadena de texto
     * @return la fecha en formato solicitado
     * @exception IllegalArgumentException Si no es posible realizar el formateo
     */
    public static Date convertirCadenaAFecha(DateFormat formateador, String cadena)
    {
        if (formateador == null)
            throw new IllegalArgumentException("El formateador no puede ser nulo.\n");
        else if (esVacio(cadena))
            throw new IllegalArgumentException("La cadena no puede ser nula ni vacía.\n");

        try
        {
            return formateador.parse(cadena);
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException("No es posible convetir la cadena: " + cadena + " en el formato solicitado.\n");
        }
    } //convertirCadenaAFecha
}
