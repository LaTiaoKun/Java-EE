/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSystem.EJB;

import javax.ejb.Local;
import DataSystem.entity.ItemDesc;
/**
 *
 * @author
 */
@Local
public interface ItemProcessLocal {
    public ItemDesc createItem(String ItemId,String Desc,String[] Group,String ItemName,String Leader,String Teacher);
    public void removeItem(String itemId);
    public ItemDesc findItem(String itemId);
    
}
