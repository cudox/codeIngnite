package com.bancodebogota.bandejaaudi.entidades;


import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries( { @NamedQuery(name = "AudiProgramaAudi.findAll", query = "select o from AudiProgramaAudi o") })
@Table(name = "AUDI_PROGRAMA_AUDI")
@Cacheable(false)
public class AudiProgramaAudi implements Serializable
{
    @SuppressWarnings("compatibility:7445776144996404598")
    private static final long serialVersionUID = -8467030922306871653L;

    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Column(nullable = false, length = 1000)
    private String conclusiones;
    @Column(name = "FECHA_ACTUALIZACION")@Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "FECHA_CREACION", nullable = false)@Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Id
    @Column(nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDI_PROGRAMA_AUDI")
    @SequenceGenerator(name = "AUDI_PROGRAMA_AUDI", sequenceName = "AUDI_PROGRAMA_AUDI_SEQ", allocationSize = 1)
    private String id;
    @Column(name = "PT_PROGRAMA", nullable = false, length = 100)
    private String ptPrograma;
    @Column(name = "OBSERVACION_DEVOLUCION", length = 1000)
    private String observacionDevolucion;
    @Column(name = "OBSERVACION_ANALISTA", length = 1000)
    private String observacionAnalista;
    @Column(name = "USUARIO_ACTUALIZACION", length = 20)
    private String usuarioActualizacion;
    @Column(name = "USUARIO_CREACION", nullable = false, length = 20)
    private String usuarioCreacion;
    @OneToMany(mappedBy = "audiProgramaAudi", fetch = FetchType.EAGER)
    private List<AudiProcedimientoAnual> audiProcedimientoAnualList;
    @OneToOne
    @JoinColumn(name = "OBJETO_AUDITABLE_ID")
    private AudiObjetoauditableanual audiObjetoauditableanual;

    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    public AudiProgramaAudi()
    {
        reservarMemoria();
    }

    /**
     * Costructor a partir de parametros dados
     * @param conclusiones
     * @param audiObjetoauditableanual
     * @param ptPrograma
     * @param usuario
     */
    public AudiProgramaAudi(String conclusiones, AudiObjetoauditableanual audiObjetoauditableanual, String ptPrograma, String usuario)
    {
        if (esVacio(conclusiones))
            throw new IllegalArgumentException("La conclusión del programa no puede ser nula ni vacía.\n");
        else if (esVacio(ptPrograma))
            throw new IllegalArgumentException("El código del papel de trabajo no puede ser nulo ni vacío.\n");
        else if (esVacio(usuario))
            throw new IllegalArgumentException("El usuario creación no puede ser nulo ni vacío.\n");
        else if (audiObjetoauditableanual == null)
            throw new IllegalArgumentException("El objeto auditable anual no puede ser nulo.\n");

        this.conclusiones = conclusiones.trim();
        this.fechaCreacion = new Date();
        this.ptPrograma = ptPrograma.trim();
        this.usuarioCreacion = usuario.toUpperCase().trim();
        this.audiObjetoauditableanual = audiObjetoauditableanual;
    }

    private void reservarMemoria()
    {
        audiProcedimientoAnualList = new ArrayList<AudiProcedimientoAnual>();
    }

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getConclusiones()
    {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones)
    {
        this.conclusiones = conclusiones;
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


    public String getPtPrograma()
    {
        return ptPrograma;
    }

    public void setPtPrograma(String ptPrograma)
    {
        this.ptPrograma = ptPrograma;
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
        audiProcedimientoAnual.setAudiProgramaAudi(this);
        return audiProcedimientoAnual;
    }

    public AudiProcedimientoAnual removeAudiProcedimientoAnual(AudiProcedimientoAnual audiProcedimientoAnual)
    {
        getAudiProcedimientoAnualList().remove(audiProcedimientoAnual);
        audiProcedimientoAnual.setAudiProgramaAudi(null);
        return audiProcedimientoAnual;
    }

    public AudiObjetoauditableanual getAudiObjetoauditableanual()
    {
        return audiObjetoauditableanual;
    }

    public void setAudiObjetoauditableanual(AudiObjetoauditableanual audiObjetoauditableanual)
    {
        this.audiObjetoauditableanual = audiObjetoauditableanual;
    }

    public void setObservacionDevolucion(String observacionDevolucion)
    {
        this.observacionDevolucion = observacionDevolucion;
    }

    public String getObservacionDevolucion()
    {
        return observacionDevolucion;
    }

    public void setObservacionAnalista(String observacionAnalista)
    {
        this.observacionAnalista = observacionAnalista;
    }

    public String getObservacionAnalista()
    {
        return observacionAnalista;
    }
}
