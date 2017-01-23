package com.bancodebogota.bandejaaudi.entidades;


import com.bancodebogota.bandejaaudi.entidades.AudiEstado;
import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;

import com.bancodebogota.bandejaaudi.entidades.AudiObjetoauditableanual;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.persistence.criteria.Fetch;


@Entity
@NamedQueries( { @NamedQuery(name = "AudiHistoricoEstado.findAll", query = "select o from AudiHistoricoEstado o") })
@Table(name = "AUDI_HISTORICO_ESTADO")
@Cacheable(false)
public class AudiHistoricoEstado implements Serializable, Comparable
{
    @SuppressWarnings("compatibility:872048658387030430")
    private static final long serialVersionUID = 2765176509012792871L;
    
    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ACTUALIZACION")
    private Date fechaActualizacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;
    @Id
    @Column(nullable = false, length = 20)
    private String id;
    @Column(name = "USUARIO_ACTUALIZACION", length = 20)
    private String usuarioActualizacion;
    @Column(name = "USUARIO_CREACION", nullable = false, length = 20)
    private String usuarioCreacion;
    @ManyToOne
    @JoinColumn(name = "OBJETO_AUDITABLE_ID")
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
    public AudiHistoricoEstado()
    {
    }

    /**
     * Constructor a partir de los parámetros enviados
     * @param objetoAuditableAnual
     * @param audiEstado
     * @param usuarioCreacion
     */
    public AudiHistoricoEstado(AudiObjetoauditableanual objetoAuditableAnual, AudiEstado audiEstado, String usuarioCreacion)
    {
        if (objetoAuditableAnual == null)
            throw new IllegalArgumentException("El objetoAuditableAnual no puede ser nulo ni vacío.\n");
        else if (audiEstado == null)
            throw new IllegalArgumentException("El estado no puede ser nulo ni vacío.\n");
        else if (esVacio(usuarioCreacion))
            throw new IllegalArgumentException("El usuario creación no puede ser nulo ni vacío.\n");

        this.usuarioCreacion = usuarioCreacion.trim().toUpperCase();
        fechaCreacion = new Date();
        
        objetoAuditableAnual.addAudiHistoricoEstado(this);
        audiEstado.addAudiHistoricoEstado(this);
    }//AudiCampoObjetoanual

    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

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

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion)
    {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public String getUsuarioActualizacion()
    {
        return usuarioActualizacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion)
    {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioCreacion()
    {
        return usuarioCreacion;
    }

    public void setAudiObjetoauditableanual(AudiObjetoauditableanual audiObjetoauditableanual)
    {
        this.audiObjetoauditableanual = audiObjetoauditableanual;
    }

    public AudiObjetoauditableanual getAudiObjetoauditableanual()
    {
        return audiObjetoauditableanual;
    }

    /**
     * @param audiEstado
     */
    public void setAudiEstado(AudiEstado audiEstado)
    {
        this.audiEstado = audiEstado;
    }

    public AudiEstado getAudiEstado()
    {
        return audiEstado;
    }
    
    //--------------------------------------------------------------------------
    // Métodos sobreescritos
    //--------------------------------------------------------------------------

    @Override
    public int compareTo(Object objetoAComparar)
    {
        if (objetoAComparar == null)
            throw new IllegalArgumentException("El objeto a comparar no puede ser nulo.\n");
        
        AudiHistoricoEstado historicoEstadoAComparar = (AudiHistoricoEstado) objetoAComparar;
        return fechaCreacion.compareTo(historicoEstadoAComparar.getFechaCreacion());
    } //compareTo
}