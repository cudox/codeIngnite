package com.bancodebogota.bandejaaudi.entidades;


import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedQueries( { @NamedQuery(name = "AudiSolicitud.findAll", query="select o from AudiSolicitud o") })
@Table(name = "AUDI_SOLICITUD")
@Cacheable(false)
public class AudiSolicitud implements Serializable {
    
    @SuppressWarnings("compatibility:-4772719016103966886")
    private static final long serialVersionUID = -4904904171319035980L;
    
    //--------------------------------------------------------------------------
    // Atributos de clase mapeados
    //--------------------------------------------------------------------------

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    private String id;
    @OneToOne
    @JoinColumn(name = "APP_SOLICITUD_ID")
    private AppSolicitud appSolicitud;
    @OneToOne
    @JoinColumn(name = "OBJETOAUDITABLEANUAL_ID")
    private AudiObjetoauditableanual audiObjetoauditableanual;
    
    
    //--------------------------------------------------------------------------
    // Constructores de clase
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public AudiSolicitud() {
    }
            
    //--------------------------------------------------------------------------
    // Métodos autogenerados en el mapeo
    //--------------------------------------------------------------------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAppSolicitud(AppSolicitud appSolicitud)
    {
        this.appSolicitud = appSolicitud;
    }

    public AppSolicitud getAppSolicitud()
    {
        return appSolicitud;
    }

    public void setAudiObjetoauditableanual(AudiObjetoauditableanual audiObjetoauditableanual)
    {
        this.audiObjetoauditableanual = audiObjetoauditableanual;
    }

    public AudiObjetoauditableanual getAudiObjetoauditableanual()
    {
        return audiObjetoauditableanual;
    }
}
