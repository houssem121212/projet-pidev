/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Article;
import Entity.reclamationmembre;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class ServiceReclamation {
    
     public void ajoutreclamation(reclamationmembre ar) {
        ConnectionRequest con = new ConnectionRequest();
 SimpleDateFormat tempss = new SimpleDateFormat("yyyy-MM-dd");
               // String datedeb = tempss.format(ev.getDATED_EVENT());
             
        String Url = "http://localhost/tech-event/web/app_dev.php/tech/AddRecMobile"
                + "?TitreRecMembre=" + ar.getTitreRecMembre()+ 
                "&ContenuRecMembre=" + ar.getContenuRecMembre()+ 
                "&NameCat=" + ar.getNameCat()
                +"&id="+authuser.user.getId()
                ;
        
        System.out.println("L'URL est : : :" + Url);
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
  
    }


//////valider (modifier etat)
     
public void validerRecla(int id,Resources res) {
             ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/tech-event/web/app_dev.php/tech/UpdateRecMemMobil/"+ id
                ;
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             Dialog.show("Succés", "reclamation validée", "ok", null);
System.err.println("valider");
             
       
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        }                             

//////valider (modifier etat)
     
public void RenvoyerRecla(int id,Resources res) {
             ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/tech-event/web/app_dev.php/tech/RenvoyerRecMemMobile/"+ id
                ;
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             Dialog.show("Succés", "reclamation renvoyer", "ok", null);
            System.err.println("renvoy");
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        }                             



         

///Affichage des reclamation membre
     
     public ArrayList<reclamationmembre> parseListTaskJson(String json) {
         System.out.println("json"+json);
        ArrayList<reclamationmembre> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> reclamationmembre = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) reclamationmembre.get("root");

            for (Map<String, Object> obj : list) {
                
                reclamationmembre rec = new reclamationmembre();

                float id = Float.parseFloat(obj.get("idrecmembre").toString());
     
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
           // String datedeb = formater.format(ar.getDate_Article());           
        
                
                rec.setIdRecMembre((int) id);
                rec.setTitreRecMembre(obj.get("titrerecmembre").toString());
                rec.setContenuRecMembre(obj.get("contenurecmembre").toString());
                rec.setNameCat(obj.get("namecat").toString());
                
                System.out.println(rec);
                
                listTasks.add(rec);

            }

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }


     ArrayList<reclamationmembre> listTasks = new ArrayList<>();
    
     public ArrayList<reclamationmembre> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/tech-event/web/app_dev.php/tech/AllRecMemMobil/"+authuser.u1);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceReclamation ser = new ServiceReclamation();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        
            NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
     ArrayList<reclamationmembre> listTask = new ArrayList<>();
      public ArrayList<reclamationmembre> getList3(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/tech-event/web/app_dev.php/tech/archiveAdminMobile/"+authuser.u1);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceReclamation ser = new ServiceReclamation();
                listTask = ser.parseListTaskJson(new String(con.getResponseData()));
                System.err.println("aaaa");
                System.err.println(listTask);
                System.err.println("aaaa");
            }
        });
        
            NetworkManager.getInstance().addToQueueAndWait(con);
            
        return listTask;
    }
     
     
     
     
     
     
     
     
     

}