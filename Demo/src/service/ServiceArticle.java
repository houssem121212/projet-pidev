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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.AffichageArticle;
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
               // "&Date_Article=" + ar.getDate_Article()+
         
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
         System.out.println("json"+json);
        ArrayList<Article> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> Articles = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) Articles.get("root");

            for (Map<String, Object> obj : list) {
                
                Article ar = new Article();

                float id = Float.parseFloat(obj.get("idArticle").toString());
     
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
           // String datedeb = formater.format(ar.getDate_Article());           
        
                
            ar.setId_Article((int) id);
                ar.setNom_Article(obj.get("nomArticle").toString());
               
                ar.setDate_Article(obj.get("dateArticle").toString());
                ar.setContenu_Article(obj.get("contenuArticle").toString());
                
                
                float nbp = Float.parseFloat(obj.get("nbrevue").toString());
                  ar.setNbrevue((int) nbp);
                
               
                float us = Float.parseFloat(obj.get("idUser").toString());
                  ar.setId_User((int) us);
                
                ar.setTitre_Event(obj.get("titreEvent").toString());
                ar.setImage_Article(obj.get("imageArticle").toString());
                
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
        con.setUrl("http://localhost/tech-event/web/app_dev.php/tech/allArticle");  
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
     
     
             public void modifierArticle(Article ta,Resources res) {
             ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/tech-event/web/app_dev.php/tech/updateArticle/"+ ta.getId_Article()+"?titre=" + ta.getNom_Article() 
                + "&contenuArticle=" + ta.getContenu_Article()
                + "&imageArticle=" + ta.getImage_Article()
               // + "&description=" + ta.getDescription() 
                + "&titreEvent="+  ta.getTitre_Event();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             Dialog.show("Succés", "Event modifié", "ok", null);

             AffichageArticle a =new AffichageArticle();
       a.show();
          
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        }                               
         
     
//      public ArrayList<Article> parseListTask1Json(String json) {
//         System.out.println("json"+json);
//        ArrayList<Article> listTasks1 = new ArrayList<>();
//
//        try {
//            JSONParser j = new JSONParser();
//            
//            Map<String, Object> Articles = j.parseJSON(new CharArrayReader(json.toCharArray()));
//                       
//            
//            List<Map<String, Object>> list = (List<Map<String, Object>>) Articles.get("root");
//
//            for (Map<String, Object> obj : list) {
//                
//                Article ar = new Article();
//
//                float id = Float.parseFloat(obj.get("idArticle").toString());
//     
//                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//           // String datedeb = formater.format(ar.getDate_Article());           
//        
//                
//            ar.setId_Article((int) id);
//                ar.setNom_Article(obj.get("nomArticle").toString());
//               
//                ar.setDate_Article(obj.get("dateArticle").toString());
//                ar.setContenu_Article(obj.get("contenuArticle").toString());
//                
//                
//                float nbp = Float.parseFloat(obj.get("nbrevue").toString());
//                  ar.setNbrevue((int) nbp);
//                
//               
//                float us = Float.parseFloat(obj.get("idUser").toString());
//                  ar.setId_User((int) us);
//                
//                ar.setTitre_Event(obj.get("titreEvent").toString());
//                ar.setImage_Article(obj.get("imageArticle").toString());
//                
//                System.out.println(ar);
//                
//                listTasks1.add(ar);
//
//            }
//
//        } catch (IOException ex) {
//        }
//        
//        System.out.println(listTasks1);
//        return listTasks1;
//
//    }
//     ArrayList<Article> listTasks1 = new ArrayList<>();
//     public ArrayList<Article> getList3(){       
//        ConnectionRequest con = new ConnectionRequest();
//      
//        con.setUrl("http://localhost/tech-event/web/app_dev.php/tech/oneArticle/" +ar.getId_Article());  
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                ServiceArticle ser = new ServiceArticle();
//                listTasks1 = ser.parseListTaskJson(new String(con.getResponseData()));
//            }
//        });
//        
//            NetworkManager.getInstance().addToQueueAndWait(con);
//        return listTasks1;
//    }

             
             
             ///////////////////////////
        
        public ArrayList<Article> Chercher(String d) {
        ArrayList<Article> listArt = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/tech-event/web/app_dev.php/tech/chercherArt/" + d);
        con.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                    Article ar = new Article();
                   
            float id = Float.parseFloat(obj.get("idArticle").toString());
     
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
           // String datedeb = formater.format(ar.getDate_Article());           
        
                
            ar.setId_Article((int) id);
                ar.setNom_Article(obj.get("nomArticle").toString());
               
                ar.setDate_Article(obj.get("dateArticle").toString());
                ar.setContenu_Article(obj.get("contenuArticle").toString());
                
                
                float nbp = Float.parseFloat(obj.get("nbrevue").toString());
                  ar.setNbrevue((int) nbp);
                
               
                float us = Float.parseFloat(obj.get("idUser").toString());
                  ar.setId_User((int) us);
                
                ar.setTitre_Event(obj.get("titreEvent").toString());
                ar.setImage_Article(obj.get("imageArticle").toString());
                
            
             
                    listArt.add(ar);
                }
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listArt;
    }
             
}

