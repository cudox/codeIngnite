package com.bancodebogota.bandejaaudi.dtos.servicio.respuesta;


import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;

import java.io.Serializable;


public class Respuesta implements Serializable
{
    @SuppressWarnings("compatibility:6050072425679097800")
    private static final long serialVersionUID = -1710011674268978479L;

    //--------------------------------------------------------------------------
    // Atributos de clase
    //--------------------------------------------------------------------------

    private String codigo;
    private String descripcion;
    private boolean esExitosa;

    //--------------------------------------------------------------------------
    // Constructores
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public Respuesta()
    {
    }

    /**
     * Constructor de clase a partir de todos sus atributos
     * @param codigo Código de la respuesta
     * @param descripcion Descripción de la respuesta
     * @param esExitosa Determina si la respuesta es exitosa o no
     */
    public Respuesta(String codigo, String descripcion, boolean esExitosa)
    {
        if (esVacio(codigo))
            throw new IllegalArgumentException("El código de la respuesta no puede ser nula ni vacía.\n");
        else if (esVacio(descripcion))
            throw new IllegalArgumentException("La descripción de la respuesta no puede ser nula ni vacía.\n");

        this.codigo = codigo.trim();
        this.descripcion = descripcion.trim();
        this.esExitosa = esExitosa;
    } //Respuesta

    //--------------------------------------------------------------------------
    // Getters y Setters
    //--------------------------------------------------------------------------

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setEsExitosa(boolean esExitosa)
    {
        this.esExitosa = esExitosa;
    }

    public boolean getEsExitosa()
    {
        return esExitosa;
    }
}
