/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Article;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class ServiceArticle {
 
    
    public void ajoutArticle(Article ar) {
        ConnectionRequest con = new ConnectionRequest();
 SimpleDateFormat tempss = new SimpleDateFormat("yyyy-MM-dd");
               // String datedeb = tempss.format(ev.getDATED_EVENT());
             
        String Url = "http://localhost/tech-event/web/app_dev.php/tech/tasks/newM"
                +"?Nom_Article=" + ar.getNom_Article()
             
                + "&Contenu_Article=" + ar.getContenu_Article()+ 
                "&Image_Article=" + ar.getImage_Article()+ 
                "&Date_Article=" + ar.getDate_Article()+
         
               "&Id_User=" + ar.getId_User()+
               
                "&Titre_Event=" + ar.getTitre_Event()+
                
                "&nbrevue=" + ar.getNbrevue()
                 ;
        
        System.out.println("L'URL est : : :" + Url);
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
     
    
     
     
     
     
     public ArrayList<Article> parseListTaskJson(String json) {

        ArrayList<Article> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> Articles = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) Articles.get("root");

            for (Map<String, Object> obj : list) {
                
                Article ar = new Article();

                float id = Float.parseFloat(obj.get("id").toString());
     
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
           // String datedeb = formater.format(ar.getDate_Article());           
        
                
            ar.setId_User((int) id);
                ar.setNom_Article(obj.get("Nom_Article").toString());
               
                ar.setDate_Article(obj.get("Date_Article").toString());
                ar.setContenu_Article(obj.get("Contenu_Article").toString());
                
                
                float nbp = Float.parseFloat(obj.get("Nbrevue").toString());
                  ar.setNbrevue((int) nbp);
                
               
                
                ar.setTitre_Event(obj.get("Titre_Event").toString());
                ar.setImage_Article(obj.get("Image_Article").toString());
                
                System.out.println(ar);
                
                listTasks.add(ar);

            }

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }
     
     ArrayList<Article> listTasks = new ArrayList<>();
     public ArrayList<Article> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/tech-event/web/app_dev.php/tech/tasks/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceArticle ser = new ServiceArticle();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        
            NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
}



