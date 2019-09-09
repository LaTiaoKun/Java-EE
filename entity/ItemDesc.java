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
import javax.persistence.Table;

/**
 *
 * @author Gravity
 */
@Entity
@Table(name="Item")
public class ItemDesc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ItemId;
    @Column(name="ItemName")
    private String ItemName;
    @Column(name="Group")
    private String group;
    @Column(name="Teacher")
    private String teacher;
    @Column(name="Leader")
    private String Leader;
    @Column(name="Describe")
    private String Desc;

    public ItemDesc()
    {
       
    }
    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getLeader() {
        return Leader;
    }

    public void setLeader(String Leader) {
        this.Leader = Leader;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ItemId != null ? ItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemDesc)) {
            return false;
        }
        ItemDesc other = (ItemDesc) object;
        if ((this.ItemId == null && other.ItemId != null) || (this.ItemId!= null && !this.ItemId.equals(other.ItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataSystem.entity.ItemDesc[ id=" + ItemId + " ]";
    }
    
}
