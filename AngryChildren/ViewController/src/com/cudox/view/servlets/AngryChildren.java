package com.cudox.view.servlets;

import com.cudox.controlador.ControladorModelo;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

import net.sf.json.JSONObject;

public class AngryChildren extends HttpServlet {
    
    @SuppressWarnings("compatibility:-7709370179802726620")
    private static final long serialVersionUID = -7285358389473975620L;
    
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    /**
     * Inicializa el servlet
     * @param config Configuración del servlet
     * @throws ServletException Si ocurre algún error durante la inicialización
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }//init

    /**
     * Procesa una petición HTTP por el método GET
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/angryChildren.jsp").forward(request, response);
    }//doGet

    /**
     * Procesa una petición HTTP por el método POST
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder respuesta = new StringBuilder("");
        try{
            Enumeration paramaterNames = request.getParameterNames();
            JSONObject json = null; 
            if(paramaterNames.hasMoreElements() ) {
                json = JSONObject.fromObject(paramaterNames.nextElement());
            }
            if(json != null){
                int accion = json.getInt("accion");
                switch(accion){
                    case 0:
                        respuesta.append(ControladorModelo.getInstance().calcular(json.getString("num"), json.getString("k"), json.getJSONArray("lista")));
                    break;
                    case 1:
                        respuesta.append(ControladorModelo.getInstance().horaAPalabras(json.getString("hora"), json.getString("minutos")));
                    break;
                    default:
                        respuesta.append("Error: la acción no esta permitida");
                    break;
                }
            }
        }
        catch(Exception e){
            respuesta.append("Error:" + e.getMessage());
        }
        catch(Error err){
            respuesta.append("Error: " + err.getMessage());
        }
        finally{
            response.setContentType("application/text; charset=windows-1252");
            response.getWriter().print(respuesta.toString());
            response.getWriter().close();            
        }
    }//doPost
}
