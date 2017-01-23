package com.bancodebogota.bandejaaudi.utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UtilitariosNumero
{
    // -------------------------------------------------------------------------
    // Constantes de clase
    // -------------------------------------------------------------------------

    /** formateadores para los n�meros */
    public static final DecimalFormat formateadorSeparadorMiles = new DecimalFormat("###,###.00");

    // -------------------------------------------------------------------------
    // M�todos de clase
    // -------------------------------------------------------------------------

    /**
     * M�todo que formatea un n�mero
     * @param formato Formato con el cual se quiere formatear el n�mero
     * @param numero N�mero al que se le dar� formato
     * @return n�mero en el formato requerido
     */
    public static String formatearNumero(NumberFormat formato, Double numero)
    {
        if (formato == null)
            throw new IllegalArgumentException("El formato no puede ser nulo.\n");
        else if (numero == null)
            throw new IllegalArgumentException("El n�mero no puede ser nulo.\n");

        return formato.format(numero);
    } //formatearNumero
}
