
package Test;

import Entite.Evennement;
import Service.EvennementService;
import java.sql.SQLException;


public class Test {


    
    public static void main(String[] args) throws SQLException {
      
           
            EvennementService us = new EvennementService();
        //us.creerEvennement(new Evennement("test1","test1","test1","test1","test1"));
      Evennement u1 = new Evennement(2,"test10000","test1","test1","test1","test1");
       //us.creerEvennement(u1);
      //us.supprimerEvennement(u1);
       
   //    us.modifierEvennement(u1);
       boolean a = us.rechercherparNom("test1");
        System.out.println(a);
        System.out.println(us.readAll());
     //  us.creerProduit(u1);
       
       

    }
    
}
