
package com.bancodebogota.consultarmoras.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bancodebogota.consultarmoras.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarMorasResponse_QNAME = new QName("http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/", "consultarMorasResponse");
    private final static QName _Exception_QNAME = new QName("http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/", "Exception");
    private final static QName _ConsultarMoras_QNAME = new QName("http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/", "consultarMoras");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bancodebogota.consultarmoras.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ConsultarMorasResponse }
     * 
     */
    public ConsultarMorasResponse createConsultarMorasResponse() {
        return new ConsultarMorasResponse();
    }

    /**
     * Create an instance of {@link ConsultarMoras }
     * 
     */
    public ConsultarMoras createConsultarMoras() {
        return new ConsultarMoras();
    }

    /**
     * Create an instance of {@link RespuestaConsultaMoras }
     * 
     */
    public RespuestaConsultaMoras createRespuestaConsultaMoras() {
        return new RespuestaConsultaMoras();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarMorasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/", name = "consultarMorasResponse")
    public JAXBElement<ConsultarMorasResponse> createConsultarMorasResponse(ConsultarMorasResponse value) {
        return new JAXBElement<ConsultarMorasResponse>(_ConsultarMorasResponse_QNAME, ConsultarMorasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarMoras }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://modelopersistencia.sesion.consultarmoras.bancodebogota.com/", name = "consultarMoras")
    public JAXBElement<ConsultarMoras> createConsultarMoras(ConsultarMoras value) {
        return new JAXBElement<ConsultarMoras>(_ConsultarMoras_QNAME, ConsultarMoras.class, null, value);
    }

}
