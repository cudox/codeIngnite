package com.bancodebogota.bandejaaudi.utilitarios;


import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.LOCALE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


public class UtilitariosTexto {
  
    // -------------------------------------------------------------------------
    // Constantes de clase
    // -------------------------------------------------------------------------

    public static final String CARACTERES_RESERVADOS = "\"\\";
    public static final String LETRAS_ESPECIALES = "áàäéèëíìïóòöúùñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
    public static final String CARACTERES_ESPECIALES = " °|¬!#$%&/()=?'¿¡*+~¨´[{^]}`,;.:-_+@<>";
    public static final String TODOS_LOS_CARACTERES_ESPECIALES = CARACTERES_RESERVADOS + LETRAS_ESPECIALES + CARACTERES_ESPECIALES;
    
    /** caracteres que son válidos en un dominio dns */
    private static final String CARACTERES_ESPECIALES_DOMINIO = ".-_";

    /** formateadores para los números */
    public static final DecimalFormat formateadorSeparadorMiles = new DecimalFormat("###,###.00"); //TODO cuando se cree un utilitarios de Numeros se debe pasar a ese

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
     * Verifica si un caracter es un dígito
     * @param caracter Caracter a verificar
     * @return true si el caracter es un dígito, false de lo contrario
     */
    public static boolean esDigito(char caracter)
    {
        return Character.isDigit(caracter);
    }//esDigito
    
    /**
     * Verifica si un caracter es una letra (sin contemplar las LETRAS_ESPECIALES)
     * @param caracter Caracter a verificar
     * @return true si el caracter es una letra (sin contemplar las LETRAS_ESPECIALES), false de lo contrario
     */
    public static boolean esLetra(char caracter)
    {
        return (caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z');
    }//esLetra
    
    /**
     * Verifica si un caracter es una letra (sin contemplar las LETRAS_ESPECIALES) o un dígito
     * @param caracter Caracter a verificar
     * @return true si el caracter es una letra (sin contemplar las LETRAS_ESPECIALES) o un dígito, false de lo contrario
     */
    public static boolean esLetraODigito(char caracter)
    {
        return esLetra(caracter) || esDigito(caracter);
    }//esLetraODigito
    
    /**
     * Verifica si un caracter es una letra en cualquier idioma
     * @param caracter Caracter a verificar
     * @return true si el caracter es una letra en cualquier idioma
     */
    public static boolean esLetraCualquierIdioma(char caracter)
    {
        return Character.isLetter(caracter);
    }//esLetraCualquierIdioma
    
    /**
     * Verifica si un caracter es una letra en cualquier idioma o un dígito
     * @param caracter Caracter a verificar
     * @return true si el caracter es una letra en cualquier idioma o un dígito, false de lo contrario
     */
    public static boolean esLetraCualquierIdiomaODigito(char caracter)
    {
        return esLetraCualquierIdioma(caracter) || esDigito(caracter);
    }//esLetraODigito
    
    /**
     * Verifica si un caracter está en la lista de posibles caractres especiales
     * @param posiblesCaracteresEspeciales Cadena con los posibles caracteres especiales
     * @param caracter Caracter a verificar
     * @return true si el caracter es un caracter especial, false de lo contrario
     */
    public static boolean esCaracterEspecial(String posiblesCaracteresEspeciales, char caracter)
    {
        return posiblesCaracteresEspeciales.lastIndexOf(caracter) == -1 ? false : true;
    }//esLetraODigito
    
    
    /**
     * Verifica si una cadena está conformada de sólo dígitos
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene dígitos, false de lo contrario
     */
    public static boolean esSoloDigitos(String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esDigito(caracter);
        }
        
        return respuesta; 
    }//esSoloDigitos

    /**
     * Verifica si una cadena está conformada de sólo letras (sin contemplar las LETRAS_ESPECIALES)
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene letras (sin contemplar las LETRAS_ESPECIALES), false de lo contrario
     */
    public static boolean esSoloLetras(String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esLetra(caracter);
        }
        
        return respuesta; 
    }//esSoloLetras
    
    /**
     * Verifica si una cadena está conformada de sólo letras en cualquier idioma
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene letras en cualquier idioma, false de lo contrario
     */
    public static boolean esSoloLetrasCulaquierIdioma(String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esLetraCualquierIdioma(caracter);
        }
        
        return respuesta; 
    }//esSoloLetrasCulaquierIdioma

    /**
     * Verifica si una cadena está conformada de sólo letras (sin contemplar las LETRAS_ESPECIALES) o dígitos
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene letras (sin contemplar las LETRAS_ESPECIALES) o dígitos, false de lo contrario
     */
    public static boolean esSoloLetrasODigitos(String cadena) 
    {        
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esLetra(caracter) || esDigito(caracter);
        }
        
        return respuesta; 
    }//esSoloLetrasODigitos

    /**
     * Verifica si una cadena está conformada de sólo letras en cualquier idioma o dígitos
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene letras en cualquier idioma o dígitos, false de lo contrario
     */
    public static boolean esSoloLetrasCulaquierIdiomaODigitos(String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esLetraCualquierIdioma(caracter) || esDigito(caracter);
        }
        
        return respuesta; 
    }//esSoloLetrasCulaquierIdiomaODigitos
    
    /**
     * Verifica si una cadena está conformada de sólo letras (sin contemplar las LETRAS_ESPECIALES) o dígitos y caracteres especiales
     * @param posiblesCaracteresEspeciales Cadena con los posibles caracteres especiales (Si es nulo se evaluan TODOS_LOS_CARACTERES_ESPECIALES)
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene letras o dígitos y caracteres especiales, false de lo contrario
     */
    public static boolean esSoloLetrasODigitosYCaracteresEspeciales(String posiblesCaracteresEspeciales, String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        posiblesCaracteresEspeciales = posiblesCaracteresEspeciales == null ? TODOS_LOS_CARACTERES_ESPECIALES : posiblesCaracteresEspeciales;
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esLetra(caracter) || esDigito(caracter) || esCaracterEspecial(posiblesCaracteresEspeciales, caracter);
        }
        
        return respuesta; 
    }//esSoloLetrasODigitosYCaracteresEspeciales

    /**
     * Verifica si una cadena está conformada de sólo dígitos o caracteres especiales
     * @param posiblesCaracteresEspeciales Cadena con los posibles caracteres especiales (Si es nulo se evaluan TODOS_LOS_CARACTERES_ESPECIALES)
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene dígitos o caracteres especiales, false de lo contrario
     */
    public static boolean esSoloDigitosYCaracteresEspeciales(String posiblesCaracteresEspeciales, String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        posiblesCaracteresEspeciales = posiblesCaracteresEspeciales == null ? TODOS_LOS_CARACTERES_ESPECIALES : posiblesCaracteresEspeciales;
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esDigito(caracter);
            if (!respuesta)
                respuesta = esCaracterEspecial(posiblesCaracteresEspeciales, caracter);
        }
        
        return respuesta; 
    }//esSoloDigitosYCaracteresEspeciales

    /**
     * Verifica si una cadena está conformada de sólo letras (sin contemplar las LETRAS_ESPECIALES) o caracteres especiales
     * @param posiblesCaracteresEspeciales Cadena con los posibles caracteres especiales (Si es nulo se evaluan TODOS_LOS_CARACTERES_ESPECIALES)
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene letras (sin contemplar las LETRAS_ESPECIALES) o caracteres especiales, false de lo contrario
     */
    public static boolean esSoloLetrasYCaracteresEspeciales(String posiblesCaracteresEspeciales, String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        posiblesCaracteresEspeciales = posiblesCaracteresEspeciales == null ? TODOS_LOS_CARACTERES_ESPECIALES : posiblesCaracteresEspeciales;
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esLetra(caracter);
            if (!respuesta)
                respuesta = esCaracterEspecial(posiblesCaracteresEspeciales, caracter);
        }
        
        return respuesta; 
    }//esSoloLetrasYCaracteresEspeciales

    /**
     * Verifica si una cadena está conformada de sólo letras en cualquier idioma o caracteres especiales
     * @param posiblesCaracteresEspeciales Cadena con los posibles caracteres especiales (Si es nulo se evaluan TODOS_LOS_CARACTERES_ESPECIALES)
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene letras en cualquier idioma o caracteres especiales, false de lo contrario
     */
    public static boolean esSoloLetrasCualquierIdiomaYCaracteresEspeciales(String posiblesCaracteresEspeciales, String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        posiblesCaracteresEspeciales = posiblesCaracteresEspeciales == null ? TODOS_LOS_CARACTERES_ESPECIALES : posiblesCaracteresEspeciales;
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esLetraCualquierIdioma(caracter);
            if (!respuesta)
                respuesta = esCaracterEspecial(posiblesCaracteresEspeciales, caracter);
        }
        
        return respuesta; 
    }//esSoloLetrasCualquierIdiomaYCaracteresEspeciales

    /**
     * Verifica si una cadena está conformada de sólo letras en cualquier idioma, dígitos o caracteres especiales
     * @param posiblesCaracteresEspeciales Cadena con los posibles caracteres especiales (Si es nulo se evaluan TODOS_LOS_CARACTERES_ESPECIALES)
     * @param cadena Cadena a verificar
     * @return true si la cadena sólo contiene letras en cualquier idioma, dígitos o caracteres especiales, false de lo contrario
     */
    public static boolean esSoloLetrasCualquierIdiomaODigitosYCaracteresEspeciales(String posiblesCaracteresEspeciales, String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        posiblesCaracteresEspeciales = posiblesCaracteresEspeciales == null ? TODOS_LOS_CARACTERES_ESPECIALES : posiblesCaracteresEspeciales;
        boolean respuesta = true;
        char caracter;
        for (int i = 0; respuesta && i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            respuesta = esLetraCualquierIdiomaODigito(caracter);
            if (!respuesta)
                respuesta = esCaracterEspecial(posiblesCaracteresEspeciales, caracter);
        }
        
        return respuesta; 
    }//esSoloLetrasCualquierIdiomaODigitosYCaracteresEspeciales

    /**
     * Verifica si una cadena de caracteres es un correo electrónico
     * @param cadena String que se verificar para saber si es un correo electrónico
     * @return true si tiene el formato correcto de un correo electronico(usuario@dominio), false de lo contrario
     */
    public static boolean esEmail(String cadena)
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        boolean respuesta = !esVacio(cadena);
        if (respuesta)
        {
            String partes[] = cadena.split("@");
            respuesta = (partes.length == 2 && esNombreUsuarioEmail(partes[0]) && esDominio(partes[1]));
        }
        
        return respuesta;
    }//esEmail
    
    /**
     * Verifica si una cadena de caracteres es un tamano_disponible_clave de usuario de email válido
     * @param cadena String que se verificará para saber si es un tamano_disponible_clave de email
     * @return true si tiene el formato correcto de un tamano_disponible_clave de usuario de email, false de lo contrario
     */
    public static boolean esNombreUsuarioEmail(String cadena)
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        boolean respuesta = !esVacio(cadena) && !(CARACTERES_ESPECIALES_DOMINIO.indexOf(cadena.charAt(0)) >= 0) &&
                      !(CARACTERES_ESPECIALES_DOMINIO.indexOf(cadena.charAt(cadena.length()-1)) >= 0 );
        if (respuesta)
        {
            char caracter;
            for (int i = 0; respuesta && i < cadena.length(); i++)
            {
              caracter = cadena.charAt(i);
              respuesta = esLetraODigito(caracter) || CARACTERES_ESPECIALES_DOMINIO.indexOf(caracter) >= 0;
            }
        }
        
        return respuesta;
    }//esNombreUsuarioEmail

    /**
     * Verifica si una cadena de caracteres es un dominio dns válido
     * @param cadena String que se verificará para saber si es un dominio dns
     * @return true si tiene el formato correcto de un dominio dns, false de lo contrario
     */
    public static boolean esDominio(String cadena)
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        boolean respuesta = !esVacio(cadena) && !(CARACTERES_ESPECIALES_DOMINIO.indexOf(cadena.charAt(0)) >= 0) &&
                              !(CARACTERES_ESPECIALES_DOMINIO.indexOf(cadena.charAt(cadena.length()-1)) >= 0) && 
                              (cadena.indexOf(".")  >= 0) && !(cadena.indexOf("..") >= 0);
        if (respuesta)
        {
            char caracter;
            for (int i = 0; respuesta && i < cadena.length(); i++)
            {
                caracter = cadena.charAt(i);
                respuesta = esLetraODigito(caracter) || CARACTERES_ESPECIALES_DOMINIO.indexOf(caracter) >= 0;
            }
        }
        
        return respuesta;
    }//esDominio

    /**
     * Verifica si una cadena tiene la estructura dada por la expresión regular
     * @param cadena Cadena a verificar
     * @param patron Expresión regular con la que se verificara
     * @return true si la cadena conforma a la expresión, false de lo contrario
     */
    public static boolean esPatron(String patron, String cadena)
    {
        if (esVacio(patron))
            throw new IllegalArgumentException("El patrón no puede ser nulo ni vacío.\n");
        else if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        return  Pattern.matches(patron, cadena);
    }//esPatron
    
    /**
     * Obtiene una cadena concatenada consigo misma un numero determinado de veces
     * @param cadena Cadena a repetir
     * @param veces Número de veces que se repite
     * @return Resultado de la concatenación
     */
    public static String repetir(String cadena, int veces)
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        else if (veces < 0)
            throw new IllegalArgumentException("El número de veces no puede ser negativo.\n");
  
        StringBuilder respuesta = new StringBuilder(cadena.length() * veces);
        for (int i = 0; i < veces; i++)
            respuesta.append(cadena);
  
        return respuesta.toString();
    }//repetir
    
    /**
     * Método que convierte la fecha según un formato solicitado
     * @param formateador Formateador con el cual se quiere formatear la fecha
     * @param fecha Fecha a la que se le dará formato
     * @return fecha en el formato requerido
     */
    public static String convertirFechaACadena(DateFormat formateador, Date fecha)
    {
        if (formateador == null)
            throw new IllegalArgumentException("El formato no puede ser nulo.\n");
        else if (fecha == null)
            throw new IllegalArgumentException("La fecha no puede ser nula.\n");
        
        return formateador.format(fecha);
    }//convertirFechaACadena

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
    }//formatearNumero

    /**
     * Elimina los ceros iniciales de una cadena que representa un número
     * @param cadena Cadena inicial a modificar
     * @return la cadena de caracteres sin los ceros iniciales
     */
    public static String quitarCerosIniciales(String cadena)
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        StringBuilder resultado = new StringBuilder();
        boolean quitando = true;
        char caracter;
        for(int i = 0; i < cadena.length() ; i++)
        {
            caracter = cadena.charAt(i);
            if(quitando && caracter != '0')
            {
                resultado.append(caracter);
                quitando = false;
            }
            else
                resultado.append(caracter);
        }
        
        return resultado.toString();
    }//quitarCerosIniciales

    /**
     * Remplaza todas las ocurrencias de una cadena por otra en una cadena
     * @param inicial StringBuilder base donde se debe realizar el remplazo
     * @param aReemplazar Cadena a remplazar
     * @param reemplazo Cadena por el cual se debe reemplazar
     * @return La cadena con su reemplazos
     */
    public static String reemplazar(String inicial, String aReemplazar, String reemplazo)
    {
        if (inicial == null)
            throw new IllegalArgumentException("La cadena inicial no puede ser nula.\n");
        else if (aReemplazar == null)
            throw new IllegalArgumentException("La cadena a reemplazar no puede ser nula.\n");
        else if (reemplazo == null)
            throw new IllegalArgumentException("La cadena reemplazo no puede ser nula.\n");
        
        StringBuilder cadenaConReemplazos = new StringBuilder(inicial);
        for (int i = cadenaConReemplazos.indexOf(aReemplazar); i >= 0; i = cadenaConReemplazos.indexOf(aReemplazar))
            cadenaConReemplazos.replace(i, i + aReemplazar.length(), reemplazo);
        
        return cadenaConReemplazos.toString();
    }// replace

    /**
     * Empaqueta una lista de valores en una cadena de caracteres
     * @param valores Lista de objetos a empaquetar
     * @param separador Cadena por la cual se separarán los valores de la lista
     * @return String La cadena con los valores empaquetados separados por el separador
     */
    public static String empaquetarLista(List<Object> valores, String separador)
    {
        if (valores == null)
            throw new IllegalArgumentException("La lista de valores no puede ser nula.\n");
        else if (separador == null)
            throw new IllegalArgumentException("La cadena separarador no puede ser nula.\n");
      
        StringBuilder paquete = new StringBuilder((valores.size()*2*separador.length())-separador.length());
        boolean separar = false;
        for (Object objeto: valores)
        {
            if (separar)
                paquete.append(separador);
            else
            {
                paquete.append(objeto.toString());
                separar = true;
            }
        }

        return paquete.toString();
    }//empaquetarLista
    
    /**
     * Obtiene la fecha presentada en formato de según el estilo
     * Dateformat.SHORT  e.g. 2010-06-23
     * Dateformat.MEDIUM e.g. Jun 23, 2010
     * Dateformat.LONG   e.g. Junio 23, 2010
     * Dateformat.FULL   e.g. Miércoles, Junio 23, 2010 AD or 3:30:42pm PST
     * @param fecha Fecha a convertir
     * @param estilo Estilo de formato
     * @return String Cadena que representa la fecha en el locale del sistema
     */
    public static String darFormatoFecha(Date fecha, int estilo)
    {
        if (fecha == null)
            throw new IllegalArgumentException("La fecha no puede ser nula.\n");
        
        return DateFormat.getDateInstance(estilo, LOCALE).format(fecha);
    }//darFormatoFecha

    /**
     * Obtiene la el número presentado en formato de cadena
     * @param numero Número a convertir
     * @param fraccion Número de cifras decimales
     * @return String Cadena que representa el número en el locale del sistema
     */
    public static String darFormatoNumero(double numero, int fraccion)
    {
        NumberFormat numFormatter = NumberFormat.getInstance(LOCALE);
        numFormatter.setMaximumFractionDigits( fraccion);
        return numFormatter.format(numero);
    }//darFormatoNumero
    
    /**
     * Capitaliza una cadena (convierte la primera letra en mayúscula)
     * @param cadena La cadena a capitalizar
     * @return la cadena capitalizada
     */
    public static String capitalizar(String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        return cambiarPrimerCaracterSegunCaso(cadena, true);
    }//capitalizar

     /**
      * Descapitaliza una cadena (convierte la primera letra en minúscula)
      * @param cadena La cadena a descapitalizar
      * @return la cadena descapitalizada
      */
    public static String descapitalizar(String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        return cambiarPrimerCaracterSegunCaso(cadena, false);
    }//descapitalizar

    /**
     * Capitaliza palabras separadas por espacios en blanco
     * @param cadena Cadena a capitalizar
     * @return cadena capitalizada
     */
    public static String capitalizarPalabras(String cadena) 
    {  
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        StringBuilder textoCapitalizado = new StringBuilder();
        String[] partesTexto = cadena.toLowerCase().split(" ");
        for (String parteTexto : partesTexto)
          textoCapitalizado.append(capitalizar(parteTexto)).append(" ");
        
        return textoCapitalizado.toString().trim();
    }//capitalizarPalabras
    
    /**
     * Descapitaliza palabras separadas por espacios en blanco
     * @param cadena Cadena a capitalizar
     * @return cadena capitalizada
     */
    public static String descapitalizarPalabras(String cadena) 
    {  
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        StringBuilder textoDescapitalizado = new StringBuilder();
        String[] partesTexto = cadena.toLowerCase().split(" ");
        for (String parteTexto : partesTexto)
          textoDescapitalizado.append(descapitalizar(parteTexto)).append(" ");
        
        return textoDescapitalizado.toString().trim();
    }//descapitalizarPalabras

    /**
     * Cambia la primera letra a mayúscula o minúscula según el caso
     * @param cadena Cadena a ser modificada
     * @param mayuscula Determina si se cambia a mayúscula o no 
     * @return la cadena modificada
     */
    private static String cambiarPrimerCaracterSegunCaso(String cadena, boolean mayuscula) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        StringBuffer respuesta = new StringBuffer(cadena.length());
        if (mayuscula)
          respuesta.append(Character.toUpperCase(cadena.charAt(0)));
        else
          respuesta.append(Character.toLowerCase(cadena.charAt(0)));
        
        respuesta.append(cadena.substring(1));
        return respuesta.toString();
    }//cambiarPrimerCaracterSegunCaso  

    /**
     * Determina si la longitud de una cadena de caracteres esta entre un intervalo (incluyendo los límites)
     * @param minimoCaracteres Longitud mínima permitida
     * @param maximoCaracteres Longitud máxima permitida
     * @param cadena Cadena de caracteres a evaluar
     * @return true si esta dentro del intervalo establecido (incluyendo los límites), en caso contrario false
     */
    public static boolean longitudValida(int minimoCaracteres, int maximoCaracteres, String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        int longitud = cadena.trim().length();
        return minimoCaracteres <= longitud && longitud <= maximoCaracteres;
    }//isLength
    
    /**
     * Trunca una cadena a determinada longitud máxima
     * @param cadena Cadena que se desea truncar
     * @param maximoCaracteres Máximo de caracteres a mostrar
     * @return la cadena truncada a cierta cantidad de caracteres
     */
    public static String truncarCadena(String cadena, int maximoCaracteres)
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        return cadena.length() > maximoCaracteres ? cadena.substring(0, maximoCaracteres) : cadena;
    }//truncarCadena
    
    /**
     * Cuenta el número de caracteres que tiene una cadena
     * @param cadena Cadena de caracteres a evaluar
     * @param caracter Caracter a contar en la cadena
     * @return número caracteres encontrados en la cadena
     */
    public static int contarCaracteres(String cadena, char caracter)
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        int repeticiones = 0;
        for (char caracterActual : cadena.toCharArray())
        {
            if (caracterActual == caracter)
              repeticiones++;
        }
        
        return repeticiones;
    }//contarCaracteres 
 
    /**
     * Determina si dos cadenas son iguales o no
     * @param cadena1 Cadena a comparar (puede ser null)
     * @param cadena2 Cadena a comparar (puede ser null)
     * @return true si las cadenas sin iguales, false de contrario
     */
    public static boolean sonCadenasIguales(String cadena1, String cadena2) 
    {
        if (cadena1 == null)
            throw new IllegalArgumentException("La cadena1 no puede ser nula.\n");
        else if (cadena2 == null)
            throw new IllegalArgumentException("La cadena2 no puede ser nula.\n");
        
        if (cadena1 == null || cadena2 == null) 
        {
            if (cadena1 == null && cadena2 == null)
                return true;
            else
                return false;
        }
        
        return cadena1.equals(cadena2);
    }//sonCadenasIguales
    
    /**
     * Elimina acentos de vocales, eñes y cedillas(Ç)
     * @param cadena Cadena a eliminar los acentos
     * @return la cadena sin acentos de vocales, eñes ni cedillas(Ç)
     */
    public static String eliminarAcentos(String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        return Pattern.compile("\\P{ASCII}+").matcher(Normalizer.normalize(cadena, Normalizer.Form.NFD)).replaceAll("");
    }//eliminarAcentos
    
    /**
     * Elimina los caracteres especiales 
     * @param cadena Cadena a eliminar los caracteres especiales
     * @return la cadena sin caracteres especiales
     */
    public static String eliminarCaracteresEspeciales(String cadena) 
    {
        if (cadena == null)
            throw new IllegalArgumentException("La cadena no puede ser nula.\n");
        
        StringBuilder cadenaSinCaracteresEspeciales = new StringBuilder();
        for (char c: cadena.toCharArray()) 
        {
            if (esLetraCualquierIdiomaODigito(c))
                cadenaSinCaracteresEspeciales.append(c);
        }
        
        return cadenaSinCaracteresEspeciales.toString();
    }//eliminarCaracteresEspeciales
    
    /**
     * Obtiene el StackTrace de una excepción
     * @param excepcion Excepción a extraer su traza
     * @return traza de la excepción completa
     */
    public static String obtenerExcepcionConStackTrace(Exception excepcion)
    {
        if (excepcion == null)
            throw new IllegalArgumentException("La excepción no puede ser nula.\n"); 
            
        StringBuilder mensajeExcepcion = new StringBuilder();
        mensajeExcepcion.append(excepcion.getMessage()+"\n");
        StringWriter stringWraiter = new StringWriter();
        excepcion.printStackTrace(new PrintWriter(stringWraiter));
        mensajeExcepcion.append(stringWraiter.toString());
        return mensajeExcepcion.toString();
    }//obtenerExcepcionConStackTrace
    
    /**
     * Convierte un InputStream a String
     * @param inputStream InputStream a convertir
     * @param codificacion Codificaión del inputStream
     * @return InputStream convertido, de lo contrario null
     * @throws IOException Si existe algún error leyendo una línea del BufferedReader usado para convertir el InputStreamReader
     */
    public static String convertirInputStream(InputStream inputStream, String codificacion) throws IOException
    {
        if (inputStream == null)
            throw new IllegalArgumentException("El inputStream no puede ser nulo.\n"); 
        else if (esVacio(codificacion))
            throw new IllegalArgumentException("La codificación no puede ser nula ni vacía.\n"); 
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, codificacion));
        StringBuilder respuesta = new StringBuilder();
        StringBuilder linea = new StringBuilder(bufferedReader.readLine());
        while (!esVacio(linea.toString()))
        {
            respuesta.append(linea);
            linea.setLength(0);
            linea.append(bufferedReader.readLine());
        }
 
        bufferedReader.close();
        return esVacio(respuesta.toString()) ? null : respuesta.toString();
    } //convertirInputStream
    
}