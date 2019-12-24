/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import Entity.Evennement;
import Entity.event;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class ServiceEvents {
 
    
    public void ajoutEvent(Evennement ev) {
        ConnectionRequest con = new ConnectionRequest();
 SimpleDateFormat tempss = new SimpleDateFormat("yyyy-MM-dd");
                String datedeb = tempss.format(ev.getDATED_EVENT());
                String datefin = tempss.format(ev.getDATEF_EVENT());
        String Url = "http://localhost/tech-event/web/app_dev.php/tech/tasks/new"
                +"?Titre_Event=" + ev.getTitre_Event()
             
                + "&EMPLACEMENT=" + ev.getEMPLACEMENT()+ 
                "&categorie_Event=" + ev.getCategorie_Event()+ 
                "&DATED_EVENT=" + datedeb+
                "&DATEF_EVENT=" +datefin+
                
               "&nbr_place_E=" + ev.getNbr_place_E()+
               
                "&Descr_Event=" + ev.getDescr_Event()+
                
                "&Image_Event=" + ev.getImage_Event()
                 ;
        
        System.out.println("L'URL est : : :" + Url);
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
     
    
     
     
     
     
     public ArrayList<Evennement> getlistE(String json) {

         
         System.err.println(json);
         
         
        ArrayList<Evennement> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");

            for (Map<String, Object> obj : list) {
                
                Evennement ev = new Evennement();

                float id = Float.parseFloat(obj.get("idEvent").toString());
     
//                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//            String datedeb = formater.format(ev.getDATED_EVENT());           
//            String datefin = formater.format(ev.getDATEF_EVENT());        
//                
            ev.setId_User((int) id);
                ev.setTitre_Event(obj.get("titreEvent").toString());
               
                ev.setEMPLACEMENT(obj.get("emplacement").toString());
                ev.setCategorie_Event(obj.get("categorieEvent").toString());
                
                
//                ev.setDATED_EVENT((Date) obj.get(datedeb));
//                ev.setDATEF_EVENT((Date) obj.get(datefin));
                
                float nbp = Float.parseFloat(obj.get("nbrPlaceE").toString());
                
                
                ev.setNbr_place_E((int) nbp);
                
               
                
                ev.setDescr_Event(obj.get("descrEvent").toString());
                ev.setImage_Event(obj.get("imageEvent").toString());
                
                System.out.println(ev);
                
                listTasks.add(ev);

            }

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }
     
     ArrayList<Evennement> listTasks = new ArrayList<>();
     public ArrayList<Evennement> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/tech-event/web/app_dev.php/tech/tasks/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvents ser = new ServiceEvents();
                listTasks = ser.getlistE(new String(con.getResponseData()));
            }
        });
        
            NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
}



