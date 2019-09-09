/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Gravity
 */
@Entity
@Table(name="REGISTER")
public class register implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    
    @Column(name="userName")
    private String userName;
    
    @Column(name="passWord")
    private String passWord;
    
    @Column(name="permission")
    private String permission;
    
    @Column(name="isLog")
    private boolean isLog;
    
    public register()
    {
    
    }
    public register(String id,String userName,String passWord,String permission)
    {
        this.id=id;
        this.userName=userName;
        this.passWord=passWord;
        this.permission=permission;
        isLog=false;
    }

    public boolean isIsLog() {
        return isLog;
    }

    public void setIsLog(boolean isLog) {
        this.isLog = isLog;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof register)) {
            return false;
        }
        register other = (register) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataSystem.entity.register[ id=" + id + " ]";
    }
    
}
