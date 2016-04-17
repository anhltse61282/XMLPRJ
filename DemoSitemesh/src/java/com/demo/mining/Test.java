/**
 *
 */
package com.demo.mining;

import com.assignment.dao.RelatedDAO;
import com.demo.api.DBAPI;
import com.demo.dto.OrderDBDTO;
import com.demo.dto.OrderDetailsDBDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author le van sang
 *
 * 09-10-2015Datamining
 */
public class Test {

    public static void main(String[] args) {
		// test tiaCk
        // ItemSet its1 = new ItemSet();
        // its1.add("I1");
        // its1.add("I2");
        // its1.add("I3");
        // ItemSet its2 = new ItemSet();
        // its2.add("I1");
        // its2.add("I2");
        // its2.add("I4");
        // ItemSet its3 = new ItemSet();
        // its3.add("I1");
        // its3.add("I3");
        // its3.add("I4");
        // ItemSet its4 = new ItemSet();
        // its4.add("I1");
        // its4.add("I3");
        // its4.add("I5");
        // ItemSet its7 = new ItemSet();
        // its7.add("I2");
        // its7.add("I3");
        // its7.add("I4");
        // ItemSet its6 = new ItemSet();
        // its6.add("I1");
        // its6.add("I2");
        // its6.add("I3");
        // its6.add("I4");
        // ItemSetCollection itC = new ItemSetCollection();
        // itC.add(its1);
        // itC.add(its2);
        // itC.add(its3);
        // itC.add(its4);
        // itC.add(its7);
        // System.out.println(new AssociationRule().tiaCk(its6, itC));

        // test new;
      
            
                DBAPI dbapi = new DBAPI();
                
                List<OrderDBDTO> orders = dbapi.getALL("TBL_Orders");
                List<OrderDetailsDBDTO> orderDetails = dbapi.getALL("TBL_OrderDetail");
                ItemSetCollection itemSetCollection = new ItemSetCollection();
                for (OrderDBDTO order : orders) {
                    ItemSet itemSet = new ItemSet();
                    for (OrderDetailsDBDTO orderDetail : orderDetails) {
                        if (order.getId().equals(orderDetail.getOrderID())) {
                            
                            itemSet.add(orderDetail.getProductID());
                        }
                    }
                    itemSetCollection.add(itemSet);
                }
                AssociationRule as = new AssociationRule();
                List<AssociationRule> list = new ArrayList<AssociationRule>();
                System.out.println(as.FindingLargeItemset(itemSetCollection, 0.1));
                list = as.assRule(itemSetCollection, as.FindingLargeItemset(itemSetCollection, 0.01), 50);
                for (AssociationRule assoc : list) {
                    String Xset = "";
                    String Yset = "";
                    RelatedDAO relatedDAO = new RelatedDAO();
                    List<String> param = new ArrayList<String>();
                    for (int i = 0; i < assoc.getX().size(); i++) {
                        Xset = Xset + " "+assoc.getX().get(i);
                    }
                     for (int i = 0; i < assoc.getY().size(); i++) {
                        Yset = Xset + " "+assoc.getY().get(i);
                    }
                    param.add(Xset.trim());
                    param.add(Yset.trim());
                    System.out.println(assoc.getX().get(0)+" "+assoc.getY().get(0));
                  
                        relatedDAO.insertDB(param);
                    
                    
                }
                System.out.println("run");
            
        
    }
}
