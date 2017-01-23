package com.bancodebogota.bandejaaudi.entidades;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "PpeAppParametros.findAll", query="select o from PpeAppParametros o") })
@Table(name = "PPE_APP_PARAMETROS")
@IdClass(PpeAppParametros.PpeAppParametrosPK.class)
@Cacheable(value = false)
public class PpeAppParametros implements Serializable
{
    @SuppressWarnings("compatibility:2784556730614583384")
    private static final long serialVersionUID = 6321281131610237595L;

    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Id
    @Column(nullable = false, length = 50)
    private String aplicacion;
    @Column(length = 200)
    private String descripcion;
    @Id
    @Column(nullable = false, length = 50)
    private String nombreparametro;
    @Column(nullable = false, length = 200)
    private String valor;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public PpeAppParametros()
    {
    }

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getAplicacion()
    {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion)
    {
        this.aplicacion = aplicacion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getNombreparametro()
    {
        return nombreparametro;
    }

    public void setNombreparametro(String nombreparametro)
    {
        this.nombreparametro = nombreparametro;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

    //--------------------------------------------------------------------------
    // Clases utilitarias mapeadas para la clase
    //--------------------------------------------------------------------------

    protected static class PpeAppParametrosPK implements Serializable
    {

        @SuppressWarnings("compatibility:7824378380258821279")
        private static final long serialVersionUID = 8075954769131710041L;

        //--------------------------------------------------------------------------
        // Atributos de clase mapeados
        //--------------------------------------------------------------------------

        private String aplicacion;
        private String nombreparametro;

        //--------------------------------------------------------------------------
        // Constructores de clase
        //--------------------------------------------------------------------------

        /**
         * Constructor por defecto
         */
        public PpeAppParametrosPK()
        {
        }

        //--------------------------------------------------------------------------
        // Métodos sobreescritos
        //--------------------------------------------------------------------------

        @Override
        public boolean equals(Object other)
        {
            if (other instanceof PpeAppParametrosPK)
            {
                final PpeAppParametrosPK otherPpeAppParametrosPK = (PpeAppParametrosPK) other;
                final boolean areEqual = (otherPpeAppParametrosPK.aplicacion.equals(aplicacion) && otherPpeAppParametrosPK.nombreparametro.equals(nombreparametro));
                return areEqual;
            }
            return false;
        }

        @Override
        public int hashCode()
        {
            return super.hashCode();
        }

        //--------------------------------------------------------------------------
        // Métodos autogenerados en el mapeo
        //--------------------------------------------------------------------------

        String getAplicacion()
        {
            return aplicacion;
        }

        void setAplicacion(String aplicacion)
        {
            this.aplicacion = aplicacion;
        }

        String getNombreparametro()
        {
            return nombreparametro;
        }

        void setNombreparametro(String nombreparametro)
        {
            this.nombreparametro = nombreparametro;
        }
    }
}
