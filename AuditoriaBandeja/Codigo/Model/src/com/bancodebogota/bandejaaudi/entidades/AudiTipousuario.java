package com.bancodebogota.bandejaaudi.entidades;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries( { @NamedQuery(name = "AudiTipousuario.findAll", query = "select o from AudiTipousuario o") })
@Table(name = "AUDI_TIPOUSUARIO")
@Cacheable (false)
public class AudiTipousuario implements Serializable
{
    @SuppressWarnings("compatibility:6466706641738696369")
    private static final long serialVersionUID = -1512882412364210215L;
    
    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------
    
    @Column(nullable = false, unique = true, length = 20)
    private String codigo;
    @Column(length = 500)
    private String descripcion;
    @Column(nullable = false)
    private String estado;
    @Temporal (TemporalType.TIMESTAMP)
    private Date fechaactualizacion;
    @Column(nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Id
    @Column(nullable = false, length = 20)
    private String id;
    @Column(nullable = false, length = 50)
    private String nombre;
    private BigDecimal ordenpresentacion;
    @Column(length = 20)
    private String usuarioactualizacion;
    @Column(nullable = false, length = 20)
    private String usuariocreacion;
    @OneToMany(mappedBy = "audiTipousuario")
    private List<AudiUsuario> audiUsuarioList;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AudiTipousuario()
    {
        reservarMemoria();
    } //AudiTipousuario

    /**
     * Reserva memoria para las listas de la clase
     */
    private void reservarMemoria()
    {
        audiUsuarioList = new ArrayList<AudiUsuario>();
    } //reservarMemoria

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public Date getFechaactualizacion()
    {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion)
    {
        this.fechaactualizacion = fechaactualizacion;
    }

    public Date getFechacreacion()
    {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion)
    {
        this.fechacreacion = fechacreacion;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public BigDecimal getOrdenpresentacion()
    {
        return ordenpresentacion;
    }

    public void setOrdenpresentacion(BigDecimal ordenpresentacion)
    {
        this.ordenpresentacion = ordenpresentacion;
    }

    public String getUsuarioactualizacion()
    {
        return usuarioactualizacion;
    }

    public void setUsuarioactualizacion(String usuarioactualizacion)
    {
        this.usuarioactualizacion = usuarioactualizacion;
    }

    public String getUsuariocreacion()
    {
        return usuariocreacion;
    }

    public void setUsuariocreacion(String usuariocreacion)
    {
        this.usuariocreacion = usuariocreacion;
    }

    public List<AudiUsuario> getAudiUsuarioList()
    {
        return audiUsuarioList;
    }

    public void setAudiUsuarioList(List<AudiUsuario> audiUsuarioList)
    {
        this.audiUsuarioList = audiUsuarioList;
    }

    public AudiUsuario addAudiUsuario(AudiUsuario audiUsuario)
    {
        getAudiUsuarioList().add(audiUsuario);
        audiUsuario.setAudiTipousuario(this);
        return audiUsuario;
    }

    public AudiUsuario removeAudiUsuario(AudiUsuario audiUsuario)
    {
        getAudiUsuarioList().remove(audiUsuario);
        audiUsuario.setAudiTipousuario(null);
        return audiUsuario;
    }
}
