package com.bancodebogota.bandejaaudi.dtos.servicio.respuesta;

import java.io.Serializable;

public class ColumnaBandeja implements Serializable
{
    @SuppressWarnings("compatibility:-4558859373244398342")
    private static final long serialVersionUID = 5930023618333528140L;

    //--------------------------------------------------------------------------
    // Atributos de clase
    //--------------------------------------------------------------------------

    private String mDataProp;
    private String sTitle;
    private String sClass;

    //--------------------------------------------------------------------------
    // Constructores
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public ColumnaBandeja()
    {
    }

    /**
     * Constructor a partir de todos sus atributos
     * @param mDataProp Dato de la columa como tal
     * @param sTitle Título de la columna
     * @param sClass Clase que se le aplicará a la columna
     */
    public ColumnaBandeja(String mDataProp, String sTitle, String sClass)
    {
        this.mDataProp = mDataProp;
        this.sTitle = sTitle;
        this.sClass = sClass;
    } //ColumnaBandeja

    //--------------------------------------------------------------------------
    // Getters y Setters
    //--------------------------------------------------------------------------

    public void setmDataProp(String mDataProp)
    {
        this.mDataProp = mDataProp;
    }

    public String getmDataProp()
    {
        return mDataProp;
    }

    public void setsTitle(String sTitle)
    {
        this.sTitle = sTitle;
    }

    public String getsTitle()
    {
        return sTitle;
    }

    public void setsClass(String sClass)
    {
        this.sClass = sClass;
    }

    public String getsClass()
    {
        return sClass;
    }
}
