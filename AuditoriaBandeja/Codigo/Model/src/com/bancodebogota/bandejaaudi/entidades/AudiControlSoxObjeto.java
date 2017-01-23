package com.bancodebogota.bandejaaudi.entidades;


import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries( { @NamedQuery(name = "AudiControlSoxObjeto.findAll", query = "select o from AudiControlSoxObjeto o") })
@Table(name = "AUDI_CONTROL_SOX_OBJETO")
@Cacheable (false)
public class AudiControlSoxObjeto implements Serializable
{
    @SuppressWarnings("compatibility:-6879782226594485407")
    private static final long serialVersionUID = 3988346786002872839L;
    
    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Id
    @Column(nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDI_CONTROL_SOX_OBJETO")
    @SequenceGenerator(name = "AUDI_CONTROL_SOX_OBJETO", sequenceName = "AUDI_CONTROL_SOX_OBJETO_SEQ", allocationSize = 1)
    private String id;
    @Column(name="CONTROL_SOX_CODIGO", nullable = false)
    private String controlSoxCodigo;
    @Column(name = "SOLICITUD_ID", length = 20)
    private String solicitudId;
    @Column(name ="ESTADO", nullable = false)
    private Boolean estado;    
    @Column(name ="REABRIR")
    private Boolean reabrir;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;
    @Column(name = "USUARIO_CREACION", nullable = false, length = 20)
    private String usuarioCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ACTUALIZACION")
    private Date fechaActualizacion;
    @Column(name = "USUARIO_ACTUALIZACION", length = 20)
    private String usuarioActualizacion;
    @ManyToOne @JoinColumn(name = "ANALISTA_ID")
    private AudiAnalista audiAnalista;
    @ManyToOne @JoinColumn(name = "OBJETO_AUDITABLE_ID")
    private AudiObjetoauditableanual audiObjetoauditableanual;
    @ManyToOne
    @JoinColumn(name = "ESTADO_ID")
    private AudiEstado audiEstado;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AudiControlSoxObjeto()
    {
    } //AudiControlSoxObjeto

    /**
     * Constructor a partir de parametros dados
     * @param usuarioCreacion
     * @param controlSoxCodigo
     * @param audiAnalista
     * @param audiObjetoauditableanual
     * @param estado
     */
    public AudiControlSoxObjeto(String usuarioCreacion, String controlSoxCodigo, AudiAnalista audiAnalista, AudiObjetoauditableanual audiObjetoauditableanual, AudiEstado audiEstado, boolean estado)
    {
        if (esVacio(usuarioCreacion))
            throw new IllegalArgumentException("El usuario de creación no puede ser nulo ni vacío.\n");
        else if (esVacio(controlSoxCodigo))
            throw new IllegalArgumentException("El control sox no puede ser nulo o vacío.\n");
        else if (audiAnalista == null)
            throw new IllegalArgumentException("El analista no puede ser nulo.\n");
        else if (audiObjetoauditableanual == null)
            throw new IllegalArgumentException("El objeto auditable no puede ser nulo.\n");
        
        this.fechaCreacion = new Date();
        this.usuarioCreacion = usuarioCreacion.toUpperCase().trim();
        this.estado = estado;
        audiObjetoauditableanual.addAudiControlSoxObjeto(this);
        audiEstado.addAudiControlSoxObjeto(this);
    } //AudiControlSoxObjeto

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCreacion()
    {
        return fechaCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion)
    {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioCreacion()
    {
        return usuarioCreacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion)
    {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaActualizacion()
    {
        return fechaActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion)
    {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public String getUsuarioActualizacion()
    {
        return usuarioActualizacion;
    }

    public void setAudiAnalista(AudiAnalista audiAnalista)
    {
        this.audiAnalista = audiAnalista;
    }

    public AudiAnalista getAudiAnalista()
    {
        return audiAnalista;
    }

    public void setAudiObjetoauditableanual(AudiObjetoauditableanual audiObjetoauditableanual)
    {
        this.audiObjetoauditableanual = audiObjetoauditableanual;
    }

    public AudiObjetoauditableanual getAudiObjetoauditableanual()
    {
        return audiObjetoauditableanual;
    }

    public void setControlSoxCodigo(String controlSoxCodigo)
    {
        this.controlSoxCodigo = controlSoxCodigo;
    }

    public String getControlSoxCodigo()
    {
        return controlSoxCodigo;
    }

    public void setReabrir(Boolean reabrir)
    {
        this.reabrir = reabrir;
    }

    public Boolean getReabrir()
    {
        return reabrir;
    }

    public void setEstado(Boolean estado)
    {
        this.estado = estado;
    }

    public Boolean getEstado()
    {
        return estado;
    }

    public void setAudiEstado(AudiEstado audiEstado)
    {
        this.audiEstado = audiEstado;
    }

    public AudiEstado getAudiEstado()
    {
        return audiEstado;
    }

    public void setSolicitudId(String solicitudId)
    {
        this.solicitudId = solicitudId;
    }

    public String getSolicitudId()
    {
        return solicitudId;
    }
}
