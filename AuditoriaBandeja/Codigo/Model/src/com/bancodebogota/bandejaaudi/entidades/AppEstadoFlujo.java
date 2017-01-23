package com.bancodebogota.bandejaaudi.entidades;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "AppEstadoFlujo.findAll", query = "select o from AppEstadoFlujo o") })
@Table(name = "APP_ESTADO_FLUJO")
@Cacheable(false)
public class AppEstadoFlujo implements Serializable {
    
    @SuppressWarnings("compatibility:2030439212213388220")
    private static final long serialVersionUID = -1403403335300251454L;

    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Column(nullable = false)
    private String activo;
    @Column(nullable = false)
    private BigDecimal cierre;
    @Column(nullable = false, length = 50)
    private String codigo;
    @Column(length = 100)
    private String descripcion;
    private Timestamp fechaactualizacion;
    private Timestamp fechacreacion;
    @Id
    @Column(nullable = false, length = 20)
    private String id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(length = 50)
    private String usuarioactualizacion;
    @Column(nullable = false, length = 50)
    private String usuariocreacion;
    @ManyToOne
    @JoinColumn(name = "PADRE_ID")
    private AppEstadoFlujo appEstadoFlujo;
    @OneToMany(mappedBy = "appEstadoFlujo")
    private List<AppEstadoFlujo> appEstadoFlujoList;

    public AppEstadoFlujo() {
    }

    public AppEstadoFlujo(String activo, BigDecimal cierre, String codigo, String descripcion,
                          Timestamp fechaactualizacion, Timestamp fechacreacion, String id, String nombre,
                          AppEstadoFlujo appEstadoFlujo, String usuarioactualizacion, String usuariocreacion) {
        this.activo = activo;
        this.cierre = cierre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaactualizacion = fechaactualizacion;
        this.fechacreacion = fechacreacion;
        this.id = id;
        this.nombre = nombre;
        this.appEstadoFlujo = appEstadoFlujo;
        this.usuarioactualizacion = usuarioactualizacion;
        this.usuariocreacion = usuariocreacion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public BigDecimal getCierre() {
        return cierre;
    }

    public void setCierre(BigDecimal cierre) {
        this.cierre = cierre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Timestamp fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getUsuarioactualizacion() {
        return usuarioactualizacion;
    }

    public void setUsuarioactualizacion(String usuarioactualizacion) {
        this.usuarioactualizacion = usuarioactualizacion;
    }

    public String getUsuariocreacion() {
        return usuariocreacion;
    }

    public void setUsuariocreacion(String usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
    }

    public AppEstadoFlujo getAppEstadoFlujo() {
        return appEstadoFlujo;
    }

    public void setAppEstadoFlujo(AppEstadoFlujo appEstadoFlujo) {
        this.appEstadoFlujo = appEstadoFlujo;
    }

    public List<AppEstadoFlujo> getAppEstadoFlujoList() {
        return appEstadoFlujoList;
    }

    public void setAppEstadoFlujoList(List<AppEstadoFlujo> appEstadoFlujoList) {
        this.appEstadoFlujoList = appEstadoFlujoList;
    }

    public AppEstadoFlujo addAppEstadoFlujo(AppEstadoFlujo appEstadoFlujo) {
        getAppEstadoFlujoList().add(appEstadoFlujo);
        appEstadoFlujo.setAppEstadoFlujo(this);
        return appEstadoFlujo;
    }

    public AppEstadoFlujo removeAppEstadoFlujo(AppEstadoFlujo appEstadoFlujo) {
        getAppEstadoFlujoList().remove(appEstadoFlujo);
        appEstadoFlujo.setAppEstadoFlujo(null);
        return appEstadoFlujo;
    }
}
