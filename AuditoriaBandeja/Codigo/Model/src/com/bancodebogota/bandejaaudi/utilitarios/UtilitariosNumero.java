package com.bancodebogota.bandejaaudi.utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UtilitariosNumero
{
    // -------------------------------------------------------------------------
    // Constantes de clase
    // -------------------------------------------------------------------------

    /** formateadores para los números */
    public static final DecimalFormat formateadorSeparadorMiles = new DecimalFormat("###,###.00");

    // -------------------------------------------------------------------------
    // Métodos de clase
    // -------------------------------------------------------------------------

    /**
     * Método que formatea un número
     * @param formato Formato con el cual se quiere formatear el número
     * @param numero Número al que se le dará formato
     * @return número en el formato requerido
     */
    public static String formatearNumero(NumberFormat formato, Double numero)
    {
        if (formato == null)
            throw new IllegalArgumentException("El formato no puede ser nulo.\n");
        else if (numero == null)
            throw new IllegalArgumentException("El número no puede ser nulo.\n");

        return formato.format(numero);
    } //formatearNumero
}
