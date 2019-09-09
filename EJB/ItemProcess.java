/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.EJB;

import DataSystem.entity.ItemDesc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * 
 */
@Stateless
public class ItemProcess implements ItemProcessLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    EntityManager em;
    EntityManagerFactory factory;
    EntityTransaction tx;
    public ItemProcess()
    {
        /*
        constructor创建工厂对象，并且对镀锡管理器，tx等进行赋值
        自动调用
        */
        factory=Persistence.createEntityManagerFactory("DataSystemPU");
        em=factory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }
    public String ProcessArray(String[] str,int length)
    {
        String cache = "";
        for(int i=0;i<length;i++)
        {
            cache+=str[i];
            cache+="|";
        }
        return "cache";
    }
    /* Override */
    @Override
    public ItemDesc createItem(String ItemId,String Desc,String[] Group,String ItemName,String Leader,String Teacher)
    {
        ItemDesc itemdesc=new ItemDesc();
        itemdesc.setItemId(ItemId);
        itemdesc.setDesc(Desc);
        itemdesc.setGroup(ProcessArray(Group,Group.length));
        itemdesc.setItemName(ItemName);
        itemdesc.setLeader(Leader);
        itemdesc.setTeacher(Teacher);
        em.persist(itemdesc);
          tx.commit();
         em.clear();
         factory.close();
         return itemdesc;
    }
    
    @Override
    public void removeItem(String itemId)
    {
        ItemDesc itemdesc = this.findItem(itemId);
        if(null!=itemdesc)
        {
            em.remove(itemdesc);
        }
    }
    
    @Override
    public ItemDesc findItem(String itemId)
    {
        /* 通过主键查找 */
        return em.find(ItemDesc.class,itemId);
    }
    
    
  
}
