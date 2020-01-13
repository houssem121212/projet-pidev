/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Reponse;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.cleanmodern.varGlobales;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceReponse {
    
    
    
        public void ajoutReponse(Reponse rep) {
     
            ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
            String Url ="http://localhost/tech-event/web/app_dev.php/ajoutReponseMobile?descriptionReponse=" + rep.getDescriptionReponse()+ "&id=" + rep.getId_quest();// création de l'URL
          
            con.setUrl(Url);// Insertion de l'URL de notre demande de connexion     
            NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
            String data = new String(con.getResponseData());
            JSONParser j = new JSONParser();
        try {
            System.out.println(j.parseJSON(new CharArrayReader(data.toCharArray())));
        } catch (IOException ex) {
        
        }
    }
    
        
                public void updateReponse(Reponse rep) {
     
            ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
         // http://localhost:800/pepiniere123/web/app_dev.php/modifierreponseMobile/86/?descriptionReponse=wala%20wajaatouha&id=43
            con.setUrl("http://localhost/tech-event/web/app_dev.php/modifierreponseMobile/"+rep.getId_rep()+"/?descriptionReponse="+rep.getDescriptionReponse()+"&id="+rep.getId_quest());// Insertion de l'URL de notre demande de connexion     
            NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
            String data = new String(con.getResponseData());
            JSONParser j = new JSONParser();
        try {
            System.out.println(j.parseJSON(new CharArrayReader(data.toCharArray())));
        } catch (IOException ex) {
        
        }
    }
    
    
    
    
   
       public void deleteReponse(int id_rep) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
     String Url ="http://localhost/tech-event/web/app_dev.php/deletereponseMobile/" +id_rep+"/";

    
       con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
  
    
    
    
      public ArrayList<Reponse> parseDetailReponseJson(String json) {

        ArrayList<Reponse>  listReponses= new ArrayList<>();

   try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParsr permettant le parsing du résultat jsone

          Map<String, Object>  Reponses = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
       List<Map<String, Object>> list = (List<Map<String, Object>>) Reponses.get("reponse");
       String username = (String)Reponses.get("username");
       

       for (Map<String, Object> repObj : list){
           Reponse reponse = new Reponse();
           
           //ajouter l'objet reponse
           reponse.setId_rep((int)((double)repObj.get("id")));
           reponse.setDescriptionReponse((String)repObj.get("descriptionReponse"));
           reponse.setDateReponse((String)repObj.get("dateReponse"));
       //ajouter l'objet question
             Map<String ,Object > question = (Map)repObj.get("question");
               reponse.setId_quest((int)((double)question.get("id")));
                reponse.setTitreQuestion((String)question.get("titreQuestion"));
                reponse.setDescriptionQuestion((String)question.get("descriptionQuestion"));
                reponse.setDateQuestion((String)question.get("dateQuestion"));
             Map<String ,Object > user = (Map)question.get("user"); 
     reponse.setUsername((String) user.get("username"));
          

           
           listReponses.add(reponse);
       }
       
       
      } catch (IOException ex) {
       }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return listReponses;

    }
    
    
    
    
    

    
    
  ArrayList<Reponse>  listDetailReponses = new ArrayList<>();
    

    public ArrayList<Reponse> getDetailQuestion(){       
        ConnectionRequest con = new ConnectionRequest();//Appel au service web (demande de connexion).
   con.setUrl("http://localhost/tech-event/web/app_dev.php/affichereponseMobile/"+varGlobales.getId()+"/");        

        con.addResponseListener(new ActionListener<NetworkEvent>() {
           
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceReponse ser = new ServiceReponse();
 listDetailReponses = ser.parseDetailReponseJson(new String(con.getResponseData()));//Récupération de la réponse du serveur
                System.out.println("taw bch nchoufou liste reponse");
                    System.out.println(listDetailReponses);
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return  listDetailReponses;
    
    }
    
    
  
   

}
