/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.EJB;
import DataSystem.entity.register;
import javax.ejb.Stateless;
import DataSystem.Tool.Permission;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/**
 *
 * @author Gravity
 */
@Stateless
public class InfoProcess implements InfoProcessLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    EntityManager em;
    EntityManagerFactory factory;
    EntityTransaction tx;
   
    public InfoProcess()
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
    
    @Override
    public register createUser(String id,String userName,String passWord,String permission)
    {
        /*
        用来实例化register
        */
        register info = new register();
        info.setId(id);
        info.setPassWord(passWord);
        info.setPermission(permission);
        info.setUserName(userName);
        info.setIsLog(false);
        em.persist(info);
         tx.commit();
         em.clear();
         factory.close();
        return info;
    }
    
    
    public void removeUser(String id)
    {
      register user = findUser(id);
      if(user!=null)
      {
          em.remove(user);
      }
    }
    
   
     public register findUser(String id)
    {
      return em.find(register.class,id);
    }
     
}
