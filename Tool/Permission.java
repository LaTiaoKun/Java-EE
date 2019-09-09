/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.Tool;

/**
 *
 * @author Gravity
 */

public class Permission {
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
    public Permission(String id,String userName,boolean isPermit,String status,String IpAddress)
    {
        this.id=id;
        this.status=status;
        this.userName=userName;
        this.isPermit=isPermit;
        this.IpAddress=IpAddress;
    }
}
