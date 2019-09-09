/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.web;

import javax.faces.bean.ManagedBean;
import DataSystem.EJB.ItemProcess;
/**
 *
 * @author Gravity
 */
@ManagedBean
public class AddItem {
    private String ItemId;
    private String Desc;
    private String[] Group;
    private String ItemName;
    private String Leader;
    private String Teacher;
    /* ctor */
    public AddItem()
    {
        Group=new String[5];
    }

    public String add()
    {
        ItemProcess itemProcess = new ItemProcess();
        itemProcess.createItem(ItemId, Desc, Group, ItemName, Leader, Teacher);
        return "ItemShow.xhtml";
    }
    
    /* getter and setter*/
    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String[] getGroup() {
        return Group;
    }

    public void setGroup(String[] Group) {
        this.Group = Group;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getLeader() {
        return Leader;
    }

    public void setLeader(String Leader) {
        this.Leader = Leader;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
    }

}
