package com.bancodebogota.bandejaaudi.entidades;


import java.io.Serializable;

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
@NamedQueries( { @NamedQuery(name = "AudiEstado.findAll", query = "select o from AudiEstado o") })
@Table(name = "AUDI_ESTADO")
@Cacheable(false)
public class AudiEstado implements Serializable
{
    @SuppressWarnings("compatibility:6412182395765873030")
    private static final long serialVersionUID = -6734391707353059571L;
    
    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------
    
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false, length = 1000)
    private String descripcion;
    @Column(name = "ES_INICIAL", nullable = false)
    private Boolean esInicial;
    @Column(nullable = false)
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ACTUALIZACION")
    private Date fechaActualizacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;
    @Id
    @Column(nullable = false, length = 20)    
    private String id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(name = "USUARIO_ACTUALIZACION", length = 20)
    private String usuarioActualizacion;
    @Column(name = "USUARIO_CREACION", nullable = false, length = 20)
    private String usuarioCreacion;
    @OneToMany(mappedBy = "audiEstado")
    private List<AudiHistoricoEstado> audiHistoricoEstadoList;
    @OneToMany(mappedBy = "audiEstado")
    private List<AudiProcedimientoAnual> audiProcedimientoAnualList;
    @OneToMany(mappedBy = "audiEstado")
    private List<AudiControlSoxObjeto> audiControlSoxObjetoList;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor Por defecto
     */
    public AudiEstado()
    {
        reservarMemoria();
    } //AudiEstado

    /**
     * Reserva memoria para las listas de la clase
     */
    private void reservarMemoria()
    {
        audiHistoricoEstadoList = new ArrayList<AudiHistoricoEstado>();
        audiProcedimientoAnualList = new ArrayList<AudiProcedimientoAnual>();
        audiControlSoxObjetoList = new ArrayList<AudiControlSoxObjeto>();
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

    public String getUsuarioActualizacion()
    {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion)
    {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public String getUsuarioCreacion()
    {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion)
    {
        this.usuarioCreacion = usuarioCreacion;
    }

    public List<AudiHistoricoEstado> getAudiHistoricoEstadoList()
    {
        return audiHistoricoEstadoList;
    }

    public void setAudiHistoricoEstadoList(List<AudiHistoricoEstado> audiHistoricoEstadoList)
    {
        this.audiHistoricoEstadoList = audiHistoricoEstadoList;
    }

    public AudiHistoricoEstado addAudiHistoricoEstado(AudiHistoricoEstado audiHistoricoEstado)
    {
        getAudiHistoricoEstadoList().add(audiHistoricoEstado);
        audiHistoricoEstado.setAudiEstado(this);
        return audiHistoricoEstado;
    }

    public AudiHistoricoEstado removeAudiHistoricoEstado(AudiHistoricoEstado audiHistoricoEstado)
    {
        getAudiHistoricoEstadoList().remove(audiHistoricoEstado);
        audiHistoricoEstado.setAudiEstado(null);
        return audiHistoricoEstado;
    }

    public void setEsInicial(Boolean esInicial)
    {
        this.esInicial = esInicial;
    }

    public Boolean getEsInicial()
    {
        return esInicial;
    }

    public void setFechaActualizacion(Date fechaActualizacion)
    {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaActualizacion()
    {
        return fechaActualizacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCreacion()
    {
        return fechaCreacion;
    }

    public List<AudiProcedimientoAnual> getAudiProcedimientoAnualList()
    {
        return audiProcedimientoAnualList;
    }

    public void setAudiProcedimientoAnualList(List<AudiProcedimientoAnual> audiProcedimientoAnualList)
    {
        this.audiProcedimientoAnualList = audiProcedimientoAnualList;
    }

    public AudiProcedimientoAnual addAudiProcedimientoAnual(AudiProcedimientoAnual audiProcedimientoAnual)
    {
        getAudiProcedimientoAnualList().add(audiProcedimientoAnual);
        audiProcedimientoAnual.setAudiEstado(this);
        return audiProcedimientoAnual;
    }

    public AudiProcedimientoAnual removeAudiProcedimientoAnual(AudiProcedimientoAnual audiProcedimientoAnual)
    {
        getAudiProcedimientoAnualList().remove(audiProcedimientoAnual);
        audiProcedimientoAnual.setAudiEstado(null);
        return audiProcedimientoAnual;
    }

    public void setAudiControlSoxObjetoList(List<AudiControlSoxObjeto> audiControlSoxObjetoList)
    {
        this.audiControlSoxObjetoList = audiControlSoxObjetoList;
    }

    public List<AudiControlSoxObjeto> getAudiControlSoxObjetoList()
    {
        return audiControlSoxObjetoList;
    }

    public AudiControlSoxObjeto addAudiControlSoxObjeto(AudiControlSoxObjeto audiControlSoxObjeto)
    {
        getAudiControlSoxObjetoList().add(audiControlSoxObjeto);
        audiControlSoxObjeto.setAudiEstado(this);
        return audiControlSoxObjeto;
    }

    public AudiControlSoxObjeto removeAudiControlSoxObjeto(AudiControlSoxObjeto audiControlSoxObjeto)
    {
        getAudiControlSoxObjetoList().remove(audiControlSoxObjeto);
        audiControlSoxObjeto.setAudiEstado(null);
        return audiControlSoxObjeto;
    }
}
