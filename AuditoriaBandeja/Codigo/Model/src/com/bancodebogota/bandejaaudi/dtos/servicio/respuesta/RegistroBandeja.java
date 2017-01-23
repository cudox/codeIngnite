package com.bancodebogota.bandejaaudi.dtos.servicio.respuesta;


import com.bancodebogota.bandejaaudi.entidades.AppSolicitudUsuario;
import com.bancodebogota.bandejaaudi.entidades.AudiControlSoxObjeto;
import com.bancodebogota.bandejaaudi.entidades.AudiProcedimientoAnual;
import static com.bancodebogota.bandejaaudi.utilitarios.ConstantesModelo.NOMBRE_RADICAR_SOLICITUD_CESANTIAS;
import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosFecha.formateadorDiaMesAnioHorasMinutosAmPm;
import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.convertirFechaACadena;
import static com.bancodebogota.bandejaaudi.utilitarios.UtilitariosTexto.esVacio;

import java.io.Serializable;

import java.util.List;


public class RegistroBandeja implements Serializable
{
    @SuppressWarnings("compatibility:-9217291000318876838")
    private static final long serialVersionUID = 4272657792238349357L;
    
    //--------------------------------------------------------------------------
    // Atributos de clase
    //--------------------------------------------------------------------------

    private String numeroSolicitud;
    private String codigoObjeto;
    private String nombreObjeto;
    private String fechaProgramadaInicio;
    private String fechaProgramadaFin;
    private String analista;
    private String estadoObjeto;
    private String nombreTarea;
    private String nombrePrueba;
    private String estado;
    private String url;
    private String bolsaId;

    //--------------------------------------------------------------------------
    // Constructores
    //--------------------------------------------------------------------------

    /**
     * Constructor por defecto
     */
    public RegistroBandeja()
    {
    }

    /**
     * Contructor de clase a partir de una solictud usuario
     * @param solicitudUsuario
     * @param url
     * @param bolsaId
     */
    public RegistroBandeja(String nombreTarea, AppSolicitudUsuario solicitudUsuario, String url, String bolsaId, String usuarioPrevio)
    {
        if (solicitudUsuario == null)
            throw new IllegalArgumentException("La solicitud usuario no puede ser nula.\n");
        else if (esVacio(url))
            throw new IllegalArgumentException("La url no puede ser nula ni vacía.\n");
        else if (esVacio(bolsaId))
            throw new IllegalArgumentException("La bolsa Id no puede ser nula ni vacía.\n");
        else if (esVacio(usuarioPrevio))
            throw new IllegalArgumentException("La bolsa Id no puede ser nula ni vacía.\n");
        
        //TODO quitar try catch Diego
        try
        {            
            numeroSolicitud = solicitudUsuario.getAppSolicitud().getCodigo();
            codigoObjeto = solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getCodigoobjetoauditable();
            nombreObjeto = solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getNombreobjetoauditable();
            fechaProgramadaInicio = convertirFechaACadena(formateadorDiaMesAnioHorasMinutosAmPm, solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getFechainicial());
            fechaProgramadaFin = convertirFechaACadena(formateadorDiaMesAnioHorasMinutosAmPm, solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getFechafinal());
            analista = usuarioPrevio;            
            estadoObjeto = solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().obtenerUltimoEstadoDelHistorico().getNombre();
            nombrePrueba = "";
            if(solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getAudiControlSoxObjetoList() != null && !solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getAudiControlSoxObjetoList().isEmpty())
            {
                for(AudiControlSoxObjeto audiControlSoxObjeto : solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getAudiControlSoxObjetoList())
                {
                    if(solicitudUsuario.getAppSolicitud().getId().equals(audiControlSoxObjeto.getSolicitudId()))
                        nombrePrueba = audiControlSoxObjeto.getControlSoxCodigo();
                }
            }
            if(esVacio(nombrePrueba))
            {
                if(solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getAudiProgramaAudi() != null)
                {
                    List<AudiProcedimientoAnual> audiProcedimientoAnualList = solicitudUsuario.getAppSolicitud().getAudiSolicitud().getAudiObjetoauditableanual().getAudiProgramaAudi().getAudiProcedimientoAnualList();
                    if (audiProcedimientoAnualList != null && !audiProcedimientoAnualList.isEmpty())
                    {
                        for(AudiProcedimientoAnual audiProcedimeintoAnual : audiProcedimientoAnualList)
                        {
                            if(solicitudUsuario.getAppSolicitud().getId().equals(audiProcedimeintoAnual.getSolicitudId()))
                                nombrePrueba = audiProcedimeintoAnual.getNombre();
                        }
                    }
                }
            }
            this.nombreTarea = nombreTarea;
            estado = solicitudUsuario.getAppEstadoFlujo().getCodigo() + " - " +solicitudUsuario.getAppEstadoFlujo().getNombre();
            this.url = url.trim();
            this.bolsaId = bolsaId.trim();
        }
        catch(Exception e)
        {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("numeroSolicitud: "+ numeroSolicitud);
            mensaje.append(", codigoObjeto: " + codigoObjeto);
            mensaje.append(", nombreObjeto: " + nombreObjeto);
            mensaje.append(", fechaProgramadaInicio: " + fechaProgramadaInicio);
            mensaje.append(", fechaProgramadaFin: " + fechaProgramadaFin);
            mensaje.append(", analista: " + analista);
            mensaje.append(", estadoObjeto: " + estadoObjeto);
            mensaje.append(", nombreTarea: " + nombreTarea);
            mensaje.append(", estado: " + estado);
            mensaje.append(", url: "+this.url);
            mensaje.append(", bolsaId: "+this.bolsaId);
            mensaje.append(", error -> "+e.getMessage());
            throw new IllegalStateException (mensaje.toString(), e);
        }
    } //RegistroBandeja
    
    /**
     * Contructor de clase a partir de la url de la tarea, especificamente para Radicar Nueva Solicitud
     * @param url
     */
    public RegistroBandeja(String url)
    {
        if (esVacio(url))
            throw new IllegalArgumentException("La url de la tarea no puede ser nul ni vacío.\n");
                  
        numeroSolicitud = "";
        codigoObjeto = "";
        nombreObjeto = "";
        fechaProgramadaInicio = "";
        fechaProgramadaFin = "";
        analista = "";
        estadoObjeto = "";
        this.nombreTarea = NOMBRE_RADICAR_SOLICITUD_CESANTIAS;
        estado = "";
        this.url = url.trim();
        this.bolsaId = "0";
       
    } //RegistroBandeja

    //--------------------------------------------------------------------------
    // Getters y Setters
    //--------------------------------------------------------------------------


    public void setNumeroSolicitud(String numeroSolicitud)
    {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getNumeroSolicitud()
    {
        return numeroSolicitud;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public void setBolsaId(String bolsaId)
    {
        this.bolsaId = bolsaId;
    }

    public String getBolsaId()
    {
        return bolsaId;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigoObjeto(String codigoObjeto)
    {
        this.codigoObjeto = codigoObjeto;
    }

    public String getCodigoObjeto()
    {
        return codigoObjeto;
    }

    public void setNombreObjeto(String nombreObjeto)
    {
        this.nombreObjeto = nombreObjeto;
    }

    public String getNombreObjeto()
    {
        return nombreObjeto;
    }

    public void setFechaProgramadaInicio(String fechaProgramadaInicio)
    {
        this.fechaProgramadaInicio = fechaProgramadaInicio;
    }

    public String getFechaProgramadaInicio()
    {
        return fechaProgramadaInicio;
    }

    public void setFechaProgramadaFin(String fechaProgramadaFin)
    {
        this.fechaProgramadaFin = fechaProgramadaFin;
    }

    public String getFechaProgramadaFin()
    {
        return fechaProgramadaFin;
    }

    public void setAnalista(String analista)
    {
        this.analista = analista;
    }

    public String getAnalista()
    {
        return analista;
    }

    public void setEstadoObjeto(String estadoObjeto)
    {
        this.estadoObjeto = estadoObjeto;
    }

    public String getEstadoObjeto()
    {
        return estadoObjeto;
    }

    public void setNombrePrueba(String nombreAuditoria)
    {
        this.nombrePrueba = nombreAuditoria;
    }

    public String getNombrePrueba()
    {
        return nombrePrueba;
    }
}
