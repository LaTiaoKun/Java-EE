/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.EJB;

import javax.ejb.Local;
import DataSystem.Tool.Permission;
import DataSystem.entity.register;
/**
 *
 * 
 */
@Local
public interface InfoProcessLocal {
   // public Permission infoVerify(String id,String password);
      public register createUser(String id,String userName,String passWord,String permission);
      public void removeUser(String id);
      public register findUser(String id);
}
