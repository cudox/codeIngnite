package com.bancodebogota.bandejaaudi.entidades;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries( { @NamedQuery(name = "AppSolicitudUsuario.findAll", query="select o from AppSolicitudUsuario o") })
@Table(name = "APP_SOLICITUD_USUARIO")
@Cacheable(value = false)
public class AppSolicitudUsuario implements Serializable
{
    @SuppressWarnings("compatibility:886976315907041092")
    private static final long serialVersionUID = -8115367940623846734L;

    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Column(length = 20)
    private String area;
    @Column(length = 50)
    private String dominio;
    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaasignacion;
    @Id
    @Column(nullable = false, length = 20)
    private String id;
    @Column(nullable = false, unique = true, length = 50)
    private String usuario;
    private Boolean visible;
    @Column(name = "VISIBLE_BANDEJA", nullable = false, length = 20)
    private Boolean visibleBandeja;
    @Column(name = "MAF_TAREA_ID", nullable = false, length = 20)
    private String idTarea;
    private Boolean bolsa;
    @ManyToOne
    @JoinColumn(name = "PADRE_ID")
    private AppSolicitudUsuario appSolicitudUsuario;
    @OneToMany(mappedBy = "appSolicitudUsuario", cascade = CascadeType.ALL)
    private List<AppSolicitudUsuario> appSolicitudUsuarioList;
    @ManyToOne
    @JoinColumn(name = "SOLICITUD_ID")
    private AppSolicitud appSolicitud;
    @ManyToOne
    @JoinColumn(name = "ESTADO_FLUJO_ID")
    private AppEstadoFlujo appEstadoFlujo;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AppSolicitudUsuario()
    {
        reservarMemoria();
    }

    /**
     * Reserva memoria para las listas de la clase
     */
    private void reservarMemoria()
    {
        appSolicitudUsuarioList = new ArrayList<AppSolicitudUsuario>();
    } //reservarMemoria

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getDominio()
    {
        return dominio;
    }

    public void setDominio(String dominio)
    {
        this.dominio = dominio;
    }

    public Date getFechaasignacion()
    {
        return fechaasignacion;
    }

    public void setFechaasignacion(Date fechaasignacion)
    {
        this.fechaasignacion = fechaasignacion;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public Boolean getVisible()
    {
        return visible;
    }

    public void setVisible(Boolean visible)
    {
        this.visible = visible;
    }

    public Boolean getVisibleBandeja()
    {
        return visibleBandeja;
    }

    public void setVisibleBandeja(Boolean visibleBandeja)
    {
        this.visibleBandeja = visibleBandeja;
    }

    public String getIdTarea()
    {
        return idTarea;
    }

    public void setIdTarea(String idTarea)
    {
        this.idTarea = idTarea;
    }

    public AppSolicitud getAppSolicitud()
    {
        return appSolicitud;
    }

    public void setAppSolicitud(AppSolicitud solicitud)
    {
        this.appSolicitud = solicitud;
    }

    public void setBolsa(Boolean bolsa)
    {
        this.bolsa = bolsa;
    }

    public Boolean getBolsa()
    {
        return bolsa;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea()
    {
        return area;
    }
    public AppEstadoFlujo getAppEstadoFlujo() {
        return appEstadoFlujo;
    }

    public void setAppEstadoFlujo(AppEstadoFlujo appEstadoFlujo) {
        this.appEstadoFlujo = appEstadoFlujo;
    }

    public AppSolicitudUsuario getAppSolicitudUsuario()
    {
        return appSolicitudUsuario;
    }

    public void setAppSolicitudUsuario(AppSolicitudUsuario appSolicitudUsuario)
    {
        this.appSolicitudUsuario = appSolicitudUsuario;
    }

    public List<AppSolicitudUsuario> getAppSolicitudUsuarioList()
    {
        return appSolicitudUsuarioList;
    }

    public void setAppSolicitudUsuarioList(List<AppSolicitudUsuario> appSolicitudUsuarioList)
    {
        this.appSolicitudUsuarioList = appSolicitudUsuarioList;
    }

    public AppSolicitudUsuario addAppSolicitudUsuario(AppSolicitudUsuario appSolicitudUsuario)
    {
        getAppSolicitudUsuarioList().add(appSolicitudUsuario);
        appSolicitudUsuario.setAppSolicitudUsuario(this);
        return appSolicitudUsuario;
    }

    public AppSolicitudUsuario removeAppSolicitudUsuario(AppSolicitudUsuario appSolicitudUsuario)
    {
        getAppSolicitudUsuarioList().remove(appSolicitudUsuario);
        appSolicitudUsuario.setAppSolicitudUsuario(null);
        return appSolicitudUsuario;
    }
}
