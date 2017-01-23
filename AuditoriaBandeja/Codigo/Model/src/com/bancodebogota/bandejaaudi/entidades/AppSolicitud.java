package com.bancodebogota.bandejaaudi.entidades;


import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries( { @NamedQuery(name = "AppSolicitud.findAll", query = "select o from AppSolicitud o") })
@Table(name = "APP_SOLICITUD")
@Cacheable(false)
public class AppSolicitud implements Serializable
{
    @SuppressWarnings("compatibility:9161566393515126556")
    private static final long serialVersionUID = 8436673396494517346L;

    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Column(name = "APLI_FORMA_RADICACION_ID", length = 20)
    private String apliFormaRadicacionId;
    private BigDecimal cantidadduplicado;
    @Column(length = 10)
    private String codigo;
    @Column(name = "CODIGO_AREA_RADICACION", length = 20)
    private String codigoAreaRadicacion;
    @Column(length = 20)
    private String consecutivocliente;
    @Column(nullable = false)
    private BigDecimal duplicado;
    @Temporal(TemporalType.DATE)
    private Date fechacarta;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechamarcacion;
    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fecharadicacion;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaultimoacceso;
    @Column(nullable = false, length = 20)
    private String funcionarioradicador;
    @Id
    @Column(nullable = false, length = 20)
    @GeneratedValue(generator = "APP_SOLICITUD")
    private String id;
    @Column(length = 10)
    private String llavetercero;
    @Column(name = "MAF_TAREA_ORIGEN_ID", length = 20)
    private String mafTareaOrigenId;
    @Column(nullable = false)
    private String marcacion;
    @Column(length = 500)
    private String observaciones;
    private BigDecimal originalrecibido;
    @Column(name = "PPE_OFICINA_CODIGO", length = 4)
    private String ppeOficinaCodigo;
    private String prioritaria;
    @Column(nullable = false)
    private BigDecimal regresarpadre;
    @Column(nullable = false)
    private BigDecimal reproceso;
    @ManyToOne
    @JoinColumn(name = "APLICACION_ID")
    private AppAplicacion appAplicacion;
    @ManyToOne
    @JoinColumn(name = "PADRE_ID")
    private AppSolicitud appSolicitud;
    @OneToMany(mappedBy = "appSolicitud")
    private List<AppSolicitud> appSolicitudList;
    @OneToMany(mappedBy = "appSolicitud")
    private List<AppSolicitudUsuario> appSolicitudUsuarioList;
    @OneToOne(mappedBy = "appSolicitud")
    private AudiSolicitud audiSolicitud;
    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AppSolicitud()
    {
        reservarMemoria();
    } //AppSolicitud

    /**
     * Reserva memoria para las listas de la clase
     */
    private void reservarMemoria()
    {
        appSolicitudList = new ArrayList<AppSolicitud>();
        appSolicitudUsuarioList = new ArrayList<AppSolicitudUsuario>();
    } //reservarMemoria

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getApliFormaRadicacionId()
    {
        return apliFormaRadicacionId;
    }

    public void setApliFormaRadicacionId(String apliFormaRadicacionId)
    {
        this.apliFormaRadicacionId = apliFormaRadicacionId;
    }

    public BigDecimal getCantidadduplicado()
    {
        return cantidadduplicado;
    }

    public void setCantidadduplicado(BigDecimal cantidadduplicado)
    {
        this.cantidadduplicado = cantidadduplicado;
    }


    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getCodigoAreaRadicacion()
    {
        return codigoAreaRadicacion;
    }

    public void setCodigoAreaRadicacion(String codigoAreaRadicacion)
    {
        this.codigoAreaRadicacion = codigoAreaRadicacion;
    }

    public String getConsecutivocliente()
    {
        return consecutivocliente;
    }

    public void setConsecutivocliente(String consecutivocliente)
    {
        this.consecutivocliente = consecutivocliente;
    }

    public BigDecimal getDuplicado()
    {
        return duplicado;
    }

    public void setDuplicado(BigDecimal duplicado)
    {
        this.duplicado = duplicado;
    }

    public Date getFechacarta()
    {
        return fechacarta;
    }

    public void setFechacarta(Date fechacarta)
    {
        this.fechacarta = fechacarta;
    }

    public Date getFechamarcacion()
    {
        return fechamarcacion;
    }

    public void setFechamarcacion(Date fechamarcacion)
    {
        this.fechamarcacion = fechamarcacion;
    }

    public Date getFecharadicacion()
    {
        return fecharadicacion;
    }

    public void setFecharadicacion(Date fecharadicacion)
    {
        this.fecharadicacion = fecharadicacion;
    }

    public Date getFechaultimoacceso()
    {
        return fechaultimoacceso;
    }

    public void setFechaultimoacceso(Date fechaultimoacceso)
    {
        this.fechaultimoacceso = fechaultimoacceso;
    }

    public String getFuncionarioradicador()
    {
        return funcionarioradicador;
    }

    public void setFuncionarioradicador(String funcionarioradicador)
    {
        this.funcionarioradicador = funcionarioradicador;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getLlavetercero()
    {
        return llavetercero;
    }

    public void setLlavetercero(String llavetercero)
    {
        this.llavetercero = llavetercero;
    }

    public String getMafTareaOrigenId()
    {
        return mafTareaOrigenId;
    }

    public void setMafTareaOrigenId(String mafTareaOrigenId)
    {
        this.mafTareaOrigenId = mafTareaOrigenId;
    }

    public String getMarcacion()
    {
        return marcacion;
    }

    public void setMarcacion(String marcacion)
    {
        this.marcacion = marcacion;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public BigDecimal getOriginalrecibido()
    {
        return originalrecibido;
    }

    public void setOriginalrecibido(BigDecimal originalrecibido)
    {
        this.originalrecibido = originalrecibido;
    }


    public String getPpeOficinaCodigo()
    {
        return ppeOficinaCodigo;
    }

    public void setPpeOficinaCodigo(String ppeOficinaCodigo)
    {
        this.ppeOficinaCodigo = ppeOficinaCodigo;
    }

    public String getPrioritaria()
    {
        return prioritaria;
    }

    public void setPrioritaria(String prioritaria)
    {
        this.prioritaria = prioritaria;
    }

    public BigDecimal getRegresarpadre()
    {
        return regresarpadre;
    }

    public void setRegresarpadre(BigDecimal regresarpadre)
    {
        this.regresarpadre = regresarpadre;
    }

    public BigDecimal getReproceso()
    {
        return reproceso;
    }

    public void setReproceso(BigDecimal reproceso)
    {
        this.reproceso = reproceso;
    }

    public AppAplicacion getAppAplicacion()
    {
        return appAplicacion;
    }

    public void setAppAplicacion(AppAplicacion appAplicacion)
    {
        this.appAplicacion = appAplicacion;
    }

    public AppSolicitud getAppSolicitud()
    {
        return appSolicitud;
    }

    public void setAppSolicitud(AppSolicitud appSolicitud)
    {
        this.appSolicitud = appSolicitud;
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
        appSolicitud.setAppSolicitud(this);
        return appSolicitud;
    }

    public AppSolicitud removeAppSolicitud(AppSolicitud appSolicitud)
    {
        getAppSolicitudList().remove(appSolicitud);
        appSolicitud.setAppSolicitud(null);
        return appSolicitud;
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
        appSolicitudUsuario.setAppSolicitud(this);
        return appSolicitudUsuario;
    }

    public AppSolicitudUsuario removeAppSolicitudUsuario(AppSolicitudUsuario appSolicitudUsuario)
    {
        getAppSolicitudUsuarioList().remove(appSolicitudUsuario);
        appSolicitudUsuario.setAppSolicitud(null);
        return appSolicitudUsuario;
    }

    public void setAudiSolicitud(AudiSolicitud audiSolicitud)
    {
        this.audiSolicitud = audiSolicitud;
    }

    public AudiSolicitud getAudiSolicitud()
    {
        return audiSolicitud;
    }
}
