/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Question;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceQuestion {

    public void ajoutQuestion(Question quest) {
     
            ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
            String Url ="http://localhost/tech-event/web/app_dev.php/ajoutQuestionMobile?titreQuestion=" + quest.getTitre_question() + "&descriptionQuestion=" + quest.getDescription_question()+"&id="+service.authuser.user.getId();// création de l'URL
            
            con.setUrl(Url);// Insertion de l'URL de notre demande de connexion     
            NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
            String data = new String(con.getResponseData());
            JSONParser j = new JSONParser();
            /*
        try {
            System.out.println(j.parseJSON(new CharArrayReader(data.toCharArray())));
        } catch (IOException ex) {
        
        }
            */
    }

   
     
      
    //C’est la méthode qui fait le parsing pour retourner une liste de Question
 
    public ArrayList<Question> parseListQuestionJson(String json) {

        ArrayList<Question>  listQuestions = new ArrayList<>();

   try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParsr permettant le parsing du résultat jsone

          Map<String, Object>  Questions = j.parseJSON(new CharArrayReader(json.toCharArray()));
           System.out.println(Questions);            
            
       List<Map<String, Object>> list = (List<Map<String, Object>>) Questions.get("listeQuestion");
       String username = (String)Questions.get("username");
       

       for (Map<String, Object> o : list){
           Question question = new Question();
           
           
           question.setId((int)((double)o.get("id")));
         question.setTitre_question((String)o.get("titreQuestion"));
           question.setDescription_question((String)o.get("descriptionQuestion"));         
           question.setDate_question((String)o.get("dateQuestion"));
           Map<String ,Object > user = (Map)o.get("user");
         question.setUsername_question((String) user.get("username"));
          question.setUser_id((int)((double)user.get("id")));//jbed id mte3 lmap user
           
           listQuestions.add(question);
       }
       
       
      } catch (IOException ex) {
       }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return listQuestions;

    }
    
    
    ArrayList<Question>  listQuestions = new ArrayList<>();
    
    
    //hedhy la methode callRequest eli fl tuto
   
    public ArrayList<Question> getListQuestion(){       
        ConnectionRequest con = new ConnectionRequest();//Appel au service web (demande de connexion).
   con.setUrl("http://localhost/tech-event/web/app_dev.php/listeQuestionMobile");        

        con.addResponseListener(new ActionListener<NetworkEvent>() {
           
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceQuestion ser = new ServiceQuestion();
             listQuestions = ser.parseListQuestionJson(new String(con.getResponseData()));//Récupération de la réponse du serveur
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return  listQuestions;
    }

}
