package com.cudox.utilitarios;

public class Utilitarios {
    // -------------------------------------------------------------------------
    // M�todos de clase
    // -------------------------------------------------------------------------

    /**
     * Determina si una cadena es nula o vac�a
     * @param cadena Cadena a examinar
     * @return boolean true si la cadena es nula o vac�a, false de lo contrario
     */
    public static boolean esVacio(String cadena)
    {
        return cadena == null || cadena.trim().isEmpty() || cadena.equals("null");
    }//esVacio

    /**
     * M�todo que formatea un texto a numero
     * @param numeroAConvertir N�mero al que se le dar� formato
     * @return n�mero decimal de accion Double
     */
    public static int formatearStringANumero(String numeroAConvertir) throws Exception
    {
        if (esVacio(numeroAConvertir))
            throw new Exception("El n�mero a formatear no puede ser nulo ni vac�o.\n");

        return Integer.valueOf(numeroAConvertir);

    } //formatearNumeroADouble
}
