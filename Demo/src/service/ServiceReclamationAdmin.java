/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.reclamationadmin;
import Entity.reclamationmembre;
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
 * @author ACER
 */
public class ServiceReclamationAdmin {
    
    
    public ArrayList<reclamationadmin> parseListTaskJson(String json) {
         System.out.println("json"+json);
        ArrayList<reclamationadmin> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> reclamationmembre = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) reclamationmembre.get("root");

            for (Map<String, Object> obj : list) {
                
                reclamationadmin rec = new reclamationadmin();

                float id = Float.parseFloat(obj.get("idrecmembre").toString());
     
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
           // String datedeb = formater.format(ar.getDate_Article());           
        
                
                rec.setIdRecMembre((int) id);
                rec.setTitreRecMembre(obj.get("titrerecmembre").toString());
                rec.setContenuRecAdmin(obj.get("contenurecadmin").toString());
                rec.setNameCat(obj.get("namecat").toString());
                rec.setReponseRecMembre(obj.get("reponserecmembre").toString());
                
                System.out.println(rec);
                
                listTasks.add(rec);

            }

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    ArrayList<reclamationadmin> listTasks = new ArrayList<>();

    
    
    
    public ArrayList<reclamationadmin> getList2(int id){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/tech-event/web/app_dev.php/tech/AllRecReponseMobile/"+id);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceReclamationAdmin ser = new ServiceReclamationAdmin();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        
            NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    
}
