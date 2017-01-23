package com.cudox.controlador;

import java.util.Arrays;

import net.sf.json.JSONArray;

import static com.cudox.utilitarios.Utilitarios.esVacio;
import static com.cudox.utilitarios.Utilitarios.formatearStringANumero;

import net.sf.json.JSONObject;

public class ControladorModelo {

    //--------------------------------------------------------------------------
    // Solitario
    //--------------------------------------------------------------------------

    private static ControladorModelo controladorModelo;

    private static String numero[]={"","un","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez",
                    "once","doce","trece","catorce","quince","dieciseis","diecisiete","dieciocho",
                    "diecinueve","veinte","veintiuno","veintidos","veintitres","veinticuatro","veinticinco","veintiseis",
                    "veintisiete","veintiocho","veintinueve"};
    /**
     * Devuelve una instancia única de la clase que implementa el controlador del modelo
     * @return instancia única del controlador del modelo
     * @throws IllegalStateException Si no es posible obtener el controlador del modelo
     */
    public static synchronized ControladorModelo getInstance()
    {
        if (controladorModelo == null)
            controladorModelo = new ControladorModelo();

        return controladorModelo;
    } //getInstance

    /**
     * Constructor por defecto
     * @throws IllegalStateException Si existe algún error instanciado el controlador o hay algún error en la consulta de la lista
     */
    private ControladorModelo() {
        super();
    }//ControladorModelo
    
    public String calcular(String num, String cant, JSONArray valores) throws Exception {
        if(esVacio(num))
            throw new IllegalArgumentException("El numero de elementos N no puede ser nulo ni vacío.\n");
        if(esVacio(cant))
            throw new IllegalArgumentException("El numero de elementos K no puede ser nulo ni vacío.\n");
        if(valores == null)
            throw new IllegalArgumentException("Los valores a evaluar no pueden ser nulos ni vacíos.\n");
        
        int n = formatearStringANumero(num);
        int k = formatearStringANumero(cant);
        
        int[] lista = new int[n];
        
        for(Object valor : valores){
            JSONObject listaValor = (JSONObject) valor;
            lista[formatearStringANumero(listaValor.getString("index"))-1] = formatearStringANumero(listaValor.getString("valor"));
        }
        Arrays.sort(lista);
        int min = lista[k-1] - lista[0];
        for(int i=0;i < n-k-1;i++){
            if(lista[k+i]-lista[i+1]<min){
                  min  = lista[k+i] - lista[i+1];
            }
        }
        return "Valor de Resultado es: " + min;
    }//calcular
    
    public String horaAPalabras(String horas, String minutos) throws Exception {
        if(esVacio(horas))
            throw new IllegalArgumentException("La hora no puede ser nula ni vacía.\n");
        if(esVacio(minutos))
            throw new IllegalArgumentException("Los minutos no pueden ser nulos ni vacíos.\n");

        int h = formatearStringANumero(horas);
        int m = formatearStringANumero(minutos);
        
        StringBuilder horaEnLetras = new StringBuilder();
        if(m == 0)
                horaEnLetras.append(numero[h]+" en punto");
        else if(m == 15)
            horaEnLetras.append(numero[h]+" y cuarto");
        else if(m==30)
            horaEnLetras.append(numero[h]+" y media");
        else if(m==45)
            horaEnLetras.append("Un cuarto para las " + numero[h + 1]);
        else if(m<30)
            horaEnLetras.append(numero[m] + " minutos despues de las " + numero[h]);
        else
            horaEnLetras.append(numero[60- m] + " minutos para las " + numero[h + 1]);

        return horaEnLetras.toString();
    }//horaAPalabras
}