/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.web;
import DataSystem.Tool.Permission;
import DataSystem.Tool.ServletContextServlet;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Gravity
 */
@ManagedBean
public class ShowInfo {
    private String id;
    private String userName;
    private boolean isPermit;
    private String status;
    private String IpAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isIsPermit() {
        return isPermit;
    }

    public void setIsPermit(boolean isPermit) {
        this.isPermit = isPermit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String IpAddress) {
        this.IpAddress = IpAddress;
    }

    public ServletContextServlet getScs() {
        return scs;
    }

    public void setScs(ServletContextServlet scs) {
        this.scs = scs;
    }
    ServletContextServlet scs;
    public ShowInfo()
    {
        scs=new ServletContextServlet();
        this.show();
    }
    
    public String show()
    {
        Permission per = (Permission)scs.getServlet(this.getIpAdd());
        this.id=per.getId();
        this.userName=per.getUserName();
        this.isPermit=true;
        this.status=per.getStatus();
        this.IpAddress=this.getIpAdd();
        return "UserInfo.xhtml";
    }
    
     /* 
    get ip 
    get current Ipaddress
    */
    public String getIpAdd()
    {
         String ip;
         try{
            FacesContext fc = FacesContext.getCurrentInstance();
               HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();    
               ip = request.getHeader("x-forwarded-for");       
               if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                   ip = request.getHeader("Proxy-Client-IP");       
               }       
               if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {           
                   ip = request.getHeader("WL-Proxy-Client-IP");       
               }       
               if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {           
                   ip = request.getRemoteAddr();     
                return ip;
               }   
            }catch (Exception e) {
                e.printStackTrace();        
            }    
         return " ";   

    }
}
