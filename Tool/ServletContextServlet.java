/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.Tool;

import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Gravity
 */
public class ServletContextServlet extends HttpServlet{
     ServletContext sc;
    public ServletContextServlet()
    {
     
       FacesContext context = FacesContext.getCurrentInstance();
       ExternalContext ec = context.getExternalContext();
       sc = (ServletContext)ec.getContext();
       
    }
    
    public void setServlet(String str,Object obj)
    {
        sc.setAttribute(str, obj);
    }
    
    public Object getServlet(String str)
    {
        return sc.getAttribute(str);
    }
    
    
}
