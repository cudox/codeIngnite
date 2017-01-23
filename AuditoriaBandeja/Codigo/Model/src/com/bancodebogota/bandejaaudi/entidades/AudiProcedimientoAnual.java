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
@NamedQueries( { @NamedQuery(name = "AudiProcedimientoAnual.findAll", query = "select o from AudiProcedimientoAnual o") })
@Table(name = "AUDI_PROCEDIMIENTO_ANUAL")@Cacheable(false)
public class AudiProcedimientoAnual implements Serializable
{
    @SuppressWarnings("compatibility:8490154193936335149")
    private static final long serialVersionUID = 1268675588566381048L;

    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Column(name = "FECHA_ACTUALIZACION")@Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "FECHA_CREACION", nullable = false)@Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Id
    @Column(nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDI_PROCEDIMIENTO_ANUAL")
    @SequenceGenerator(name = "AUDI_PROCEDIMIENTO_ANUAL", sequenceName = "AUDI_PROCEDIMIENTO_ANUAL_SEQ", allocationSize = 1)
    private String id;
    @Column(nullable = false, length = 1000)
    private String nombre;
    @Column(name = "PAPEL_TRABAJO", length = 20)
    private String papelTrabajo;
    @Column(name = "CODIGO_TIPO_PT", length = 50)
    private String codigoTipoPt;
    @Column(name = "NOMBRE_TIPO_PT", length = 100)
    private String nombreTipoPt;
    @Column(name = "PERMITE_ELIMINAR", nullable = false)
    private Boolean permiteEliminar;
    @Column(name = "SOLICITUD_ID", length = 20)
    private String solicitudId;
    @Column(nullable = false)
    private int consecutivo;
    @Column(name ="ESTADO", nullable = false)
    private Boolean estado;    
    @Column(name ="REABRIR")
    private Boolean reabrir;
    @Column(name = "CODIGO_ANALISTA", length = 20)
    private String codigoAnalista;
    @Column(name = "USUARIO_ACTUALIZACION", length = 20)
    private String usuarioActualizacion;
    @Column(name = "USUARIO_CREACION", nullable = false, length = 20)
    private String usuarioCreacion;
    @ManyToOne
    @JoinColumn(name = "PROGRAMA_AUDI_ID")
    private AudiProgramaAudi audiProgramaAudi;
    @ManyToOne
    @JoinColumn(name = "ESTADO_ID")
    private AudiEstado audiEstado;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AudiProcedimientoAnual()
    {
    }

    /**
     * Constructor a partir de parametros dados
     * @param audiEstado
     * @param nombre
     * @param audiProgramaAudi
     * @param permiteEliminar
     * @param usuarioCreacion
     * @param estado
     */
    public AudiProcedimientoAnual(AudiEstado audiEstado, String nombre, AudiProgramaAudi audiProgramaAudi, boolean permiteEliminar, String usuarioCreacion, boolean estado) {
        if (esVacio(usuarioCreacion))
            throw new IllegalArgumentException("El usuario de creación no puede ser nulo ni vacío.\n");
        else if (esVacio(nombre))
            throw new IllegalArgumentException("El nombre del procedimiento no puede ser nulo o vacío.\n");
        else if (audiProgramaAudi == null)
            throw new IllegalArgumentException("El programa de auditoría no puede ser nulo.\n");
        else if (audiEstado == null)
            throw new IllegalArgumentException("El estado del automata de pruebas de auditorías no puede ser nulo.\n");
            
        this.fechaCreacion = new Date();
        this.nombre = nombre.trim();
        this.permiteEliminar = permiteEliminar;
        this.usuarioCreacion = usuarioCreacion.trim().toUpperCase();
        this.estado = estado;
        audiProgramaAudi.addAudiProcedimientoAnual(this);
        audiEstado.addAudiProcedimientoAnual(this);
    }

    /**
     * Constructor a partir de parametros dados completos
     * @param audiEstado
     * @param nombre
     * @param papelTrabajo
     * @param codigoTipoPt
     * @param nombreTipoPt
     * @param audiProgramaAudi
     * @param permiteEliminar
     * @param usuarioCreacion
     * @param estado
     */
    public AudiProcedimientoAnual(AudiEstado audiEstado, String nombre, String papelTrabajo, String codigoTipoPt, String nombreTipoPt, String codigoAnalista, AudiProgramaAudi audiProgramaAudi, boolean permiteEliminar, String usuarioCreacion, boolean estado) {
        if (esVacio(usuarioCreacion))
            throw new IllegalArgumentException("El usuario de creación no puede ser nulo ni vacío.\n");
        else if (esVacio(nombre))
            throw new IllegalArgumentException("El nombre del procedimiento no puede ser nulo o vacío.\n");
        else if (esVacio(papelTrabajo))
            throw new IllegalArgumentException("El código del papel de trabajo no puede ser nulo o vacío.\n");
        else if (esVacio(codigoTipoPt))
            throw new IllegalArgumentException("El código del tipo de papel de trabajo no puede ser nulo o vacío.\n");
        else if (esVacio(nombreTipoPt))
            throw new IllegalArgumentException("El nombre del tipo de papel de trabajo no puede ser nulo o vacío.\n");
        else if (esVacio(codigoAnalista))
            throw new IllegalArgumentException("El código del analista no puede ser nulo o vacío.\n");
        else if (audiProgramaAudi == null)
            throw new IllegalArgumentException("El programa de auditoría no puede ser nulo.\n");
        else if (audiEstado == null)
            throw new IllegalArgumentException("El estado del automata de pruebas de auditorías no puede ser nulo.\n");
            
        this.fechaCreacion = new Date();
        this.nombre = nombre.trim();
        this.papelTrabajo = papelTrabajo.trim();
        this.codigoTipoPt = codigoTipoPt.trim();
        this.nombreTipoPt = nombreTipoPt.trim();
        this.codigoAnalista = codigoAnalista.toUpperCase().trim();
        this.permiteEliminar = permiteEliminar;
        this.usuarioCreacion = usuarioCreacion.trim().toUpperCase();
        this.estado = estado;
        audiProgramaAudi.addAudiProcedimientoAnual(this);
        audiEstado.addAudiProcedimientoAnual(this);
    }

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getCodigoTipoPt()
    {
        return codigoTipoPt;
    }

    public void setCodigoTipoPt(String codigoTipoPt)
    {
        this.codigoTipoPt = codigoTipoPt;
    }


    public Date getFechaActualizacion()
    {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion)
    {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacion()
    {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
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

    public String getNombreTipoPt()
    {
        return nombreTipoPt;
    }

    public void setNombreTipoPt(String nombreTipoPt)
    {
        this.nombreTipoPt = nombreTipoPt;
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

    public AudiProgramaAudi getAudiProgramaAudi()
    {
        return audiProgramaAudi;
    }

    public void setAudiProgramaAudi(AudiProgramaAudi audiProgramaAudi)
    {
        this.audiProgramaAudi = audiProgramaAudi;
    }

    public AudiEstado getAudiEstado()
    {
        return audiEstado;
    }

    public void setAudiEstado(AudiEstado audiEstado)
    {
        this.audiEstado = audiEstado;
    }

    public void setPermiteEliminar(Boolean permiteEliminar)
    {
        this.permiteEliminar = permiteEliminar;
    }

    public Boolean getPermiteEliminar()
    {
        return permiteEliminar;
    }

    public void setReabrir(Boolean reabrir)
    {
        this.reabrir = reabrir;
    }

    public Boolean getReabrir()
    {
        return reabrir;
    }

    public void setSolicitudId(String solicitudId)
    {
        this.solicitudId = solicitudId;
    }

    public String getSolicitudId()
    {
        return solicitudId;
    }

    public void setEstado(Boolean estado)
    {
        this.estado = estado;
    }

    public Boolean getEstado()
    {
        return estado;
    }

    public void setPapelTrabajo(String papelTrabajo)
    {
        this.papelTrabajo = papelTrabajo;
    }

    public String getPapelTrabajo()
    {
        return papelTrabajo;
    }

    public void setCodigoAnalista(String codigoAnalista)
    {
        this.codigoAnalista = codigoAnalista;
    }

    public String getCodigoAnalista()
    {
        return codigoAnalista;
    }

    public void setConsecutivo(int consecutivo)
    {
        this.consecutivo = consecutivo;
    }

    public int getConsecutivo()
    {
        return consecutivo;
    }
}
