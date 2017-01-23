package com.bancodebogota.bandejaaudi.dtos.servicio.respuesta;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


public class RespuestaBandeja extends Respuesta implements Serializable
{
    @SuppressWarnings("compatibility:7264450763608803378")
    private static final long serialVersionUID = 308036203058616737L;

    //--------------------------------------------------------------------------
    // Atributos de clase
    //--------------------------------------------------------------------------

    private List<RegistroBandeja> registros;
    private List<ColumnaBandeja> etiquetas;

    //--------------------------------------------------------------------------
    // Constructores
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public RespuestaBandeja()
    {
        super();
        reservarMemoria();
    } //RespuestaBandeja

    /**
     * Constructor de clase a partir de todos los atributos de la superclase y de todos sus atributos
     * @param codigo Código de la respuesta
     * @param descripcion Descripción de la respuesta
     * @param esExitosa Determina si la respuesta es exitosa o no
     * @param etiquetas Lista con las colomnas (etiquetas)  de la bandeja
     * @param registros Lista con los registros a mostrar en la bandeja
     */
    public RespuestaBandeja(String codigo, String descripcion, boolean esExitosa, List<ColumnaBandeja> etiquetas, List<RegistroBandeja> registros)
    {
        super(codigo, descripcion, esExitosa);
        if (etiquetas == null)
            throw new IllegalArgumentException("La lista de etiquetas no puede ser nula.\n");
        else if (registros == null)
            throw new IllegalArgumentException("La lista de registros no puede ser nula.\n");

        reservarMemoria();
        for (ColumnaBandeja columnaBandeja : etiquetas)
        {
            if (columnaBandeja != null)
                this.etiquetas.add(columnaBandeja);
        }

        for (RegistroBandeja registroBandeja : registros)
        {
            if (registroBandeja != null)
                this.registros.add(registroBandeja);
        }
    } //RespuestaBandeja

    /**
     * Reserva memoria para las listas de la clase
     */
    private void reservarMemoria()
    {
        registros = new ArrayList<RegistroBandeja>();
        etiquetas = new ArrayList<ColumnaBandeja>();
    } //reservarmemoria

    //--------------------------------------------------------------------------
    // Getters y Setters
    //--------------------------------------------------------------------------

    public void setRegistros(List<RegistroBandeja> registros)
    {
        this.registros = registros;
    }

    public List<RegistroBandeja> getRegistros()
    {
        return registros;
    }

    public void setEtiquetas(List<ColumnaBandeja> etiquetas)
    {
        this.etiquetas = etiquetas;
    }

    public List<ColumnaBandeja> getEtiquetas()
    {
        return etiquetas;
    }
}
