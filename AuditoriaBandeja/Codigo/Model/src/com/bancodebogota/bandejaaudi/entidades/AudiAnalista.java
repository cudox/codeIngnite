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
@NamedQueries( { @NamedQuery(name = "AudiAnalista.findAll", query = "select o from AudiAnalista o") })
@Table(name = "AUDI_ANALISTA")
@Cacheable (false)
public class AudiAnalista implements Serializable
{
    @SuppressWarnings("compatibility:9008202349026350079")
    private static final long serialVersionUID = 4285842578167321840L;
    
    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------
    
    @Column(nullable = false, unique = true, length = 20)
    private String codigoanalista;
    @Column(nullable = false)
    private String estado;
    @Temporal (TemporalType.TIMESTAMP)
    private Date fechaactualizacion;
    @Column(nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Id
    @Column(nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDI_ANALISTA")
    @SequenceGenerator(name = "AUDI_ANALISTA", sequenceName = "AUDI_ANALISTA_SEQ", allocationSize = 1)
    private String id;
    @Column(nullable = false, length = 50)
    private String nombreanalista;
    @Column(length = 20)
    private String usuarioactualizacion;
    @Column(nullable = false, length = 20)
    private String usuariocreacion;
    @Column(nullable = false, length = 20)
    private String codigotipoauditoria;
    @ManyToOne
    @JoinColumn(name = "OBJETOAUDITABLEANUAL_ID")
    private AudiObjetoauditableanual audiObjetoauditableanual;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AudiAnalista()
    {
    }
    
    /**
     * Constructor a partir de los los parámetros enviados
     * @param codigoAnalista
     * @param nombreAnalista
     * @param estado
     * @param usuarioCreacion
     * @param objetoAuditableAnual
     * @param codigoAuditoria
     */
    public AudiAnalista(String codigoAnalista, String nombreAnalista, String estado, String usuarioCreacion, AudiObjetoauditableanual objetoAuditableAnual, String codigoAuditoria)
    {
        if (esVacio(codigoAnalista))
            throw new IllegalArgumentException("El codigoAnalista no puede ser nulo ni vacío.\n");
        else if (esVacio(nombreAnalista))
            throw new IllegalArgumentException("El nombreAnalista no puede ser nulo ni vacío.\n");
        else if (esVacio(estado))
            throw new IllegalArgumentException("El estado no puede ser nulo ni vacío.\n");
        else if (esVacio(usuarioCreacion))
            throw new IllegalArgumentException("El usuario creación no puede ser nulo ni vacío.\n");
        else if (objetoAuditableAnual == null)
            throw new IllegalArgumentException("El objeto Auditable Anual no puede ser nulo ni vacío.\n");
        else if (esVacio(codigoAuditoria))
            throw new IllegalArgumentException("El código Auditoria no puede ser nulo ni vacío.\n");
        
        usuariocreacion = usuarioCreacion.trim().toUpperCase();
        fechacreacion = new Date();
        
        codigoanalista = codigoAnalista.trim();
        nombreanalista = nombreAnalista.trim();
        codigotipoauditoria = codigoAuditoria.trim(); 
        this.estado = estado.trim();
        objetoAuditableAnual.addAudiAnalista(this);
    }//AudiAnalista

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------
    
    public String getCodigoanalista()
    {
        return codigoanalista;
    }

    public void setCodigoanalista(String codigoanalista)
    {
        this.codigoanalista = codigoanalista;
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

    public String getNombreanalista()
    {
        return nombreanalista;
    }

    public void setNombreanalista(String nombreanalista)
    {
        this.nombreanalista = nombreanalista;
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

    public AudiObjetoauditableanual getAudiObjetoauditableanual()
    {
        return audiObjetoauditableanual;
    }

    public void setAudiObjetoauditableanual(AudiObjetoauditableanual audiObjetoauditableanual3)
    {
        this.audiObjetoauditableanual = audiObjetoauditableanual3;
    }

    public void setCodigotipoauditoria(String codigotipoauditoria)
    {
        this.codigotipoauditoria = codigotipoauditoria;
    }

    public String getCodigotipoauditoria()
    {
        return codigotipoauditoria;
    }
}
