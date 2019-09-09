/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.web;
import DataSystem.Tool.Permission;
import DataSystem.entity.register;
import DataSystem.Tool.ServletContextServlet;
import DataSystem.EJB.InfoProcess;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gravity
 */
@ManagedBean
public class LogIn {
    
    private String id=" ";
    private String password=" ";
    private String ipAddress;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public LogIn()
    {
        /* ctor with non param */
    }
    
    public LogIn(String id,String password)
    {
        /*  ctor with param */
        this.id=id;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String log()
    {
        /* 用来处理登录功能 返回welcome界面/失败界面的信息 */
        InfoProcess info = new InfoProcess();
        register user = info.findUser(this.id); //通过 InfoProcess类查找用户信息
        if(user.getPassWord().equals(this.password)&&!this.password.equals(" ")&&!this.id.equals(" "))
        {
            //TODO 
           user.setIsLog(true);
            this.setIpAddress(this.getIpAdd());
           Permission per=new Permission(user.getId(),user.getPermission(),true,user.getPassWord(),this.getIpAddress());
          ServletContextServlet sc = new ServletContextServlet();
          sc.setServlet(this.getIpAddress(), per); //存入Servlet
          ShowInfo showInfo= new ShowInfo();
          
          showInfo.setUserName(info.findUser(id).getUserName());
          showInfo.setId(id);
       
            return "welcome.xhtml";
        }
        else
        {
            user.setIsLog(false);
             return "LogError.xhtml";
        }
       
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
