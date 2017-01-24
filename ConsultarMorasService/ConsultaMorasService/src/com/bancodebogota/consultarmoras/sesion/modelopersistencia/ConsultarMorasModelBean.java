package com.bancodebogota.consultarmoras.sesion.modelopersistencia;


import com.bancodebogota.consultarmoras.dto.RespuestaConsultaMoras;
import static com.bancodebogota.consultarmoras.utilitarios.ConstantesModelo.LLAMADO_PROCEDIMIENTO;
import static com.bancodebogota.consultarmoras.utilitarios.ConstantesModelo.RUTA_MODELO_PROCEDIMIENTO;
import com.bancodebogota.consultarmoras.utilitarios.Log;
import static com.bancodebogota.consultarmoras.utilitarios.UtilitariosTexto.clobToString;
import static com.bancodebogota.consultarmoras.utilitarios.UtilitariosTexto.esVacio;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import weblogic.jdbc.wrapper.Clob;


@Stateless(name = "ConsultarMorasModel", mappedName = "ConsultarMorasModel")
@TransactionManagement(TransactionManagementType.BEAN)
@WebService(wsdlLocation = "/META-INF/ConsultarMorasModelBeanService.wsdl")
public class ConsultarMorasModelBean
{
    @Resource
    SessionContext sessionContext;

    public ConsultarMorasModelBean()
    {
    }

    @WebMethod
    public RespuestaConsultaMoras consultarMoras(String tipoDocumento, String numeroDocumento) throws Exception
    {
        StringBuilder validacion = new StringBuilder();
        if(esVacio(tipoDocumento))
            validacion.append("El tipo de documento no puede ser nulo o vacío.\n");
        if(esVacio(numeroDocumento))
            validacion.append("El número de documento no puede ser nulo ni vacío.\n");

        RespuestaConsultaMoras respuestaConsultaMoras;
        if(esVacio(validacion.toString()))
        {
            Connection connection = null;
            try
            {
                final Context context = new InitialContext();
                DataSource datasource = (DataSource)context.lookup(RUTA_MODELO_PROCEDIMIENTO);
                connection = datasource.getConnection();
                CallableStatement statement = connection.prepareCall(LLAMADO_PROCEDIMIENTO);
                
                statement.setString(1, tipoDocumento);
                statement.setInt(2, Integer.valueOf(numeroDocumento));
                statement.registerOutParameter(3, OracleTypes.INTEGER);
                statement.registerOutParameter(4, OracleTypes.VARCHAR);
                statement.registerOutParameter(5, OracleTypes.CLOB);
                
                statement.execute();

                respuestaConsultaMoras = new RespuestaConsultaMoras(statement.getInt(3), statement.getString(4), clobToString((Clob) statement.getClob(5)));
            }
            catch(Exception e)
            {
                Log.getInstance().severe("Error en el execute del procedimiento.\n", e);
                respuestaConsultaMoras = new RespuestaConsultaMoras(1, "Consulta no exitosa",e.getCause().toString());
            }
            finally
            {
                if(connection != null)
                    connection.close();
            }
        }
        else
        {
            Log.getInstance().severe("Error en los datos de entrada.\n" + validacion.toString());
            respuestaConsultaMoras = new RespuestaConsultaMoras(1, "Consulta no exitosa", validacion.toString());           
        }
        return respuestaConsultaMoras;
    }
}
