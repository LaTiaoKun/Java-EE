/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.web;
import DataSystem.EJB.InfoProcess;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Gravity
 */

@ManagedBean(name="information")
public class SignIn {
    private String id;
    private String userName;
    private String passWord;
    private String permission;
    public SignIn()
    {

    }
    
    public String sign()
    {
        InfoProcess info = new InfoProcess();
        info.createUser(id, userName, passWord, permission);
        return "/Welcome/logIn.xhtml";
    }

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

  
}
