package com.bancodebogota.bandejaaudi.entidades;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.PrivateOwned;


@Entity
@NamedQueries( { @NamedQuery(name = "AudiObjetoauditableanual.findAll", query = "select o from AudiObjetoauditableanual o") })
@Table(name = "AUDI_OBJETOAUDITABLEANUAL")
@Cacheable(false)
public class AudiObjetoauditableanual implements Serializable
{
    @SuppressWarnings("compatibility:6465790272255755785")
    private static final long serialVersionUID = 7909171026075453811L;

    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------
    @Column(nullable = false, unique = true, length = 20)
    private String codigoobjetoauditable;
    @Column(nullable = false, length = 200)
    private String nombreobjetoauditable;
    @Column(nullable = false)
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaactulizacion;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinal;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinalreprogramada;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicial;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicialreprogramada;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechprogramanioanterior;
    @Column(length = 20)
    private String frecuenciaanioanterior;
    @Id
    @Column(nullable = false, length = 20)
    private String id;
    @Column(length = 20)
    private String usuarioactulizacion;
    @Column(nullable = false, length = 20)
    private String usuariocreacion;
    @OneToMany(mappedBy = "audiObjetoauditableanual", fetch = FetchType.EAGER)
    private List<AudiControlSoxObjeto> audiControlSoxObjetoList;    
    @OneToMany(mappedBy = "audiObjetoauditableanual", fetch = FetchType.EAGER)
    private List<AudiHistoricoEstado> audiHistoricoEstadoList;
    @PrivateOwned
    @OneToMany(mappedBy = "audiObjetoauditableanual")
    private List<AudiAnalista> audiAnalistaList;
    @OneToOne(mappedBy = "audiObjetoauditableanual", fetch = FetchType.EAGER)
    private AudiProgramaAudi audiProgramaAudi;
    @OneToOne(mappedBy = "audiObjetoauditableanual")
    private AudiSolicitud audiSolicitud;


    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AudiObjetoauditableanual()
    {
        reservarMemoria();
    } //AudiObjetoauditableanual

    /**
     * Reserva memoria para las listas de la clase
     */
    private void reservarMemoria()
    {
        audiAnalistaList = new ArrayList<AudiAnalista>();
        audiControlSoxObjetoList = new ArrayList<AudiControlSoxObjeto>();
        audiHistoricoEstadoList = new ArrayList<AudiHistoricoEstado>();
    } //reservarMemoria

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public void setCodigoobjetoauditable(String codigoobjetoauditable) {
        this.codigoobjetoauditable = codigoobjetoauditable;
    }

    public String getCodigoobjetoauditable() {
        return codigoobjetoauditable;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setNombreobjetoauditable(String nombreobjetoauditable) {
        this.nombreobjetoauditable = nombreobjetoauditable;
    }

    public String getNombreobjetoauditable() {
        return nombreobjetoauditable;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public Date getFechaactulizacion()
    {
        return fechaactulizacion;
    }

    public void setFechaactulizacion(Date fechaactulizacion)
    {
        this.fechaactulizacion = fechaactulizacion;
    }

    public Date getFechacreacion()
    {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion)
    {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechafinal()
    {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal)
    {
        this.fechafinal = fechafinal;
    }

    public Date getFechafinalreprogramada()
    {
        return fechafinalreprogramada;
    }

    public void setFechafinalreprogramada(Date fechafinalreprogramada)
    {
        this.fechafinalreprogramada = fechafinalreprogramada;
    }

    public Date getFechainicial()
    {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial)
    {
        this.fechainicial = fechainicial;
    }

    public Date getFechainicialreprogramada()
    {
        return fechainicialreprogramada;
    }

    public void setFechainicialreprogramada(Date fechainicialreprogramada)
    {
        this.fechainicialreprogramada = fechainicialreprogramada;
    }

    public Date getFechprogramanioanterior()
    {
        return fechprogramanioanterior;
    }

    public void setFechprogramanioanterior(Date fechprogramanioanterior)
    {
        this.fechprogramanioanterior = fechprogramanioanterior;
    }

    public String getFrecuenciaanioanterior()
    {
        return frecuenciaanioanterior;
    }

    public void setFrecuenciaanioanterior(String frecuenciaanioanterior)
    {
        this.frecuenciaanioanterior = frecuenciaanioanterior;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUsuarioactulizacion()
    {
        return usuarioactulizacion;
    }

    public void setUsuarioactulizacion(String usuarioactulizacion)
    {
        this.usuarioactulizacion = usuarioactulizacion;
    }

    public String getUsuariocreacion()
    {
        return usuariocreacion;
    }

    public void setUsuariocreacion(String usuariocreacion)
    {
        this.usuariocreacion = usuariocreacion;
    }

    public List<AudiAnalista> getAudiAnalistaList()
    {
        return audiAnalistaList;
    }

    public void setAudiAnalistaList(List<AudiAnalista> audiAnalistaList)
    {
        this.audiAnalistaList = audiAnalistaList;
    }

    public AudiAnalista addAudiAnalista(AudiAnalista audiAnalista)
    {
        getAudiAnalistaList().add(audiAnalista);
        audiAnalista.setAudiObjetoauditableanual(this);
        return audiAnalista;
    }

    public AudiAnalista removeAudiAnalista(AudiAnalista audiAnalista)
    {
        getAudiAnalistaList().remove(audiAnalista);
        audiAnalista.setAudiObjetoauditableanual(null);
        return audiAnalista;
    }

    public void setAudiHistoricoEstadoList(List<AudiHistoricoEstado> audiHistoricoEstadoList)
    {
        this.audiHistoricoEstadoList = audiHistoricoEstadoList;
    }

    public List<AudiHistoricoEstado> getAudiHistoricoEstadoList()
    {
        Collections.sort(audiHistoricoEstadoList);
        return audiHistoricoEstadoList;
    }
    
    public AudiHistoricoEstado addAudiHistoricoEstado(AudiHistoricoEstado audiHistoricoEstado)
    {
        getAudiHistoricoEstadoList().add(audiHistoricoEstado);
        audiHistoricoEstado.setAudiObjetoauditableanual(this);
        return audiHistoricoEstado;
    }

    public AudiHistoricoEstado removeAudiHistoricoEstado(AudiHistoricoEstado audiHistoricoEstado)
    {
        getAudiHistoricoEstadoList().remove(audiHistoricoEstado);
        audiHistoricoEstado.setAudiObjetoauditableanual(null);
        return audiHistoricoEstado;
    }
    
    public void setAudiProgramaAudi(AudiProgramaAudi audiProgramaAudi)
    {
        this.audiProgramaAudi = audiProgramaAudi;
    }

    public AudiProgramaAudi getAudiProgramaAudi()
    {
        return audiProgramaAudi;
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
        audiControlSoxObjeto.setAudiObjetoauditableanual(this);
        return audiControlSoxObjeto;
    }

    public AudiControlSoxObjeto removeAudiControlSoxObjeto(AudiControlSoxObjeto audiControlSoxObjeto)
    {
        getAudiControlSoxObjetoList().remove(audiControlSoxObjeto);
        audiControlSoxObjeto.setAudiObjetoauditableanual(null);
        return audiControlSoxObjeto;
    }

    //--------------------------------------------------------------------------
    // Métodos implementados
    //--------------------------------------------------------------------------

    /**
     * Obtiene el último estado asociado al obejto auditable anual
     * @return último estado asociado a la solicitud, de lo contrario null
     */
    public AudiEstado obtenerUltimoEstadoDelHistorico()
    {
        List<AudiHistoricoEstado> historicoEstadoOrdenadoAscendentemente = getAudiHistoricoEstadoList();
        int numeroEstadosHistoricos = historicoEstadoOrdenadoAscendentemente.size();
        return numeroEstadosHistoricos == 0 ? null : historicoEstadoOrdenadoAscendentemente.get(numeroEstadosHistoricos - 1).getAudiEstado();
    } //obtenerUltimoEstadoDelHistorico

    public void setAudiSolicitud(AudiSolicitud audiSolicitud)
    {
        this.audiSolicitud = audiSolicitud;
    }

    public AudiSolicitud getAudiSolicitud()
    {
        return audiSolicitud;
    }
}
