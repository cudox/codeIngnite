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
@NamedQueries( { @NamedQuery(name = "AppAplicacion.findAll", query = "select o from AppAplicacion o") })
@Table(name = "APP_APLICACION")
@Cacheable(false)
public class AppAplicacion implements Serializable
{
    @SuppressWarnings("compatibility:-1213566071325345642")
    private static final long serialVersionUID = -1527091866624951003L;

    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Column(nullable = false)
    private String activo;
    @Column(length = 30)
    private String basededatos;
    @Column(nullable = false, unique = true, length = 5)
    private String codigo;
    private BigDecimal consecutivo;
    @Column(length = 4000)
    private String descripcion;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaactualizacion;
    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Id
    @Column(nullable = false, length = 20)
    private String id;
    @Column(length = 20)
    private String instancia;
    @Column(name = "LENGUAJE_ID", length = 20)
    private String lenguajeId;
    @Column(name = "MAF_AREA_ID", length = 20)
    private String mafAreaId;
    @Column(nullable = false, length = 30)
    private String nombre;
    @Column(name = "PORTAL_CORE_OPCION_ID", length = 20)
    private String portalCoreOpcionId;
    @Column(name = "REPORTA_MDC")
    private String reportaMdc;
    @Column(length = 50)
    private String respfuncional;
    @Column(length = 50)
    private String resptecnico;
    @Column(length = 20)
    private String servidor;
    @Column(name = "TERCERO_ID", length = 20)
    private String terceroId;
    private String tipoaplicacion;
    @Column(length = 4000)
    private String url;
    @Column(length = 4000)
    private String urlservicio;
    @Column(length = 50)
    private String usuarioactualizacion;
    @Column(nullable = false, length = 50)
    private String usuariocreacion;
    @OneToMany(mappedBy = "appAplicacion")
    private List<AppSolicitud> appSolicitudList;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AppAplicacion()
    {
        reservarMemoria();
    } //AppAplicacion

    /**
     * Reserva memoria para las listas de la clase
     */
    private void reservarMemoria()
    {
        appSolicitudList = new ArrayList<AppSolicitud>();
    } //reservarMemoria

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getActivo()
    {
        return activo;
    }

    public void setActivo(String activo)
    {
        this.activo = activo;
    }

    public String getBasededatos()
    {
        return basededatos;
    }

    public void setBasededatos(String basededatos)
    {
        this.basededatos = basededatos;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public BigDecimal getConsecutivo()
    {
        return consecutivo;
    }

    public void setConsecutivo(BigDecimal consecutivo)
    {
        this.consecutivo = consecutivo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
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

    public String getInstancia()
    {
        return instancia;
    }

    public void setInstancia(String instancia)
    {
        this.instancia = instancia;
    }

    public String getLenguajeId()
    {
        return lenguajeId;
    }

    public void setLenguajeId(String lenguajeId)
    {
        this.lenguajeId = lenguajeId;
    }

    public String getMafAreaId()
    {
        return mafAreaId;
    }

    public void setMafAreaId(String mafAreaId)
    {
        this.mafAreaId = mafAreaId;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getPortalCoreOpcionId()
    {
        return portalCoreOpcionId;
    }

    public void setPortalCoreOpcionId(String portalCoreOpcionId)
    {
        this.portalCoreOpcionId = portalCoreOpcionId;
    }

    public String getReportaMdc()
    {
        return reportaMdc;
    }

    public void setReportaMdc(String reportaMdc)
    {
        this.reportaMdc = reportaMdc;
    }

    public String getRespfuncional()
    {
        return respfuncional;
    }

    public void setRespfuncional(String respfuncional)
    {
        this.respfuncional = respfuncional;
    }

    public String getResptecnico()
    {
        return resptecnico;
    }

    public void setResptecnico(String resptecnico)
    {
        this.resptecnico = resptecnico;
    }

    public String getServidor()
    {
        return servidor;
    }

    public void setServidor(String servidor)
    {
        this.servidor = servidor;
    }

    public String getTerceroId()
    {
        return terceroId;
    }

    public void setTerceroId(String terceroId)
    {
        this.terceroId = terceroId;
    }

    public String getTipoaplicacion()
    {
        return tipoaplicacion;
    }

    public void setTipoaplicacion(String tipoaplicacion)
    {
        this.tipoaplicacion = tipoaplicacion;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrlservicio()
    {
        return urlservicio;
    }

    public void setUrlservicio(String urlservicio)
    {
        this.urlservicio = urlservicio;
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

    public List<AppSolicitud> getAppSolicitudList()
    {
        return appSolicitudList;
    }

    public void setAppSolicitudList(List<AppSolicitud> appSolicitudList)
    {
        this.appSolicitudList = appSolicitudList;
    }

    public AppSolicitud addAppSolicitud(AppSolicitud appSolicitud)
    {
        getAppSolicitudList().add(appSolicitud);
        appSolicitud.setAppAplicacion(this);
        return appSolicitud;
    }

    public AppSolicitud removeAppSolicitud(AppSolicitud appSolicitud)
    {
        getAppSolicitudList().remove(appSolicitud);
        appSolicitud.setAppAplicacion(null);
        return appSolicitud;
    }
}
