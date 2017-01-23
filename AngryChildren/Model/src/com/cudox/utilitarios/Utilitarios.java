package com.cudox.utilitarios;

public class Utilitarios {
    // -------------------------------------------------------------------------
    // Métodos de clase
    // -------------------------------------------------------------------------

    /**
     * Determina si una cadena es nula o vacía
     * @param cadena Cadena a examinar
     * @return boolean true si la cadena es nula o vacía, false de lo contrario
     */
    public static boolean esVacio(String cadena)
    {
        return cadena == null || cadena.trim().isEmpty() || cadena.equals("null");
    }//esVacio

    /**
     * Método que formatea un texto a numero
     * @param numeroAConvertir Número al que se le dará formato
     * @return número decimal de accion Double
     */
    public static int formatearStringANumero(String numeroAConvertir) throws Exception
    {
        if (esVacio(numeroAConvertir))
            throw new Exception("El número a formatear no puede ser nulo ni vacío.\n");

        return Integer.valueOf(numeroAConvertir);

    } //formatearNumeroADouble
}
