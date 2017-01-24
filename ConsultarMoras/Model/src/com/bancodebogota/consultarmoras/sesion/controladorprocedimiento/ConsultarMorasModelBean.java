package com.bancodebogota.consultarmoras.sesion.controladorprocedimiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import weblogic.jdbc.wrapper.Clob;


@Stateless(name = "ConsultarMorasModel", mappedName = "ConsultarMorasModel")
@TransactionManagement(TransactionManagementType.BEAN)
public class ConsultarMorasModelBean implements ConsultarMorasModel, ConsultarMorasModelLocal
{
    @PersistenceContext(unitName = "Procedure")
    private EntityManager entityManager;
        
    @Resource
    SessionContext sessionContext;

    public ConsultarMorasModelBean()
    {
    }

    public HashMap<String, Object> consultarMoras(String tipoDocumento, String numeroDocumento) throws Exception
    {
        Map<String, Object> resultado = new HashMap<String, Object>();
        
        
        try
        {
            final Context context = new InitialContext();
            DataSource datasource = (DataSource)context.lookup("jdbc/MDT/MntoCarteraConsolidadaDS");
            Connection connection = datasource.getConnection();
            CallableStatement statement = connection.prepareCall("{call CARTERA.SERVICIOS.CONSULTAR_MORAS(?,?,?,?,?)}");
            
            statement.setString(1, tipoDocumento);
            statement.setInt(2, Integer.valueOf(numeroDocumento));
            statement.registerOutParameter(3, OracleTypes.INTEGER);
            statement.registerOutParameter(4, OracleTypes.VARCHAR);
            statement.registerOutParameter(5, OracleTypes.CLOB);
            
            statement.execute();            
            
            resultado.put("respuestaCod", statement.getInt(3));
            resultado.put("respuestaMsj", statement.getString(4));
            resultado.put("respuestaDat", clobToString((Clob) statement.getClob(5)));
        }
        catch(Exception e)
        {
            throw e;
        }
        return (HashMap<String, Object>) resultado;
    }
    
    private String clobToString(Clob clob) {
        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = clob.getCharacterStream();
            BufferedReader br = new BufferedReader(reader);

            String line;
            while(null != (line = br.readLine())) {
                sb.append(line);
            }
            br.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Error de SQLException: " + e.getStackTrace());
        } catch (IOException e) {
            throw new IllegalStateException("Error de IOException: " + e.getStackTrace());
        }
        return sb.toString();
    }
}
