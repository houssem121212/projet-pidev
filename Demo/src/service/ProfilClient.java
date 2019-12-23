/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.uikit.cleanmodern.NewsfeedForm;
import com.codename1.uikit.cleanmodern.ProfileForm;
import com.codename1.uikit.cleanmodern.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import static service.authuser.user;

/**
 *
 * @author Asus
 */
public class ProfilClient {
    int temp;
    public void Modifier(){
        
        String userlog = ProfileForm.username.getText();
        String pass = ProfileForm.password.getText();
        String nom = ProfileForm.nom.getText();
        String prenom = ProfileForm.prenom.getText();
        String mail = ProfileForm.email.getText();
        
        System.out.println(userlog);
        System.out.println(pass);
        System.out.println(nom);
        System.out.println(prenom);
        System.out.println(mail);
        ConnectionRequest connectionRequest;
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void readResponse(InputStream input) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(input, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    
                    
                    
                     if(userlog.length()==0||pass.length()==0||mail.length()==0||nom.length()==0
                        ||prenom.length()==0){
                     Dialog.show("Champs Incorrecte", "Tous les champs sont obligatoires", "Ok", null);
                     return;
          }
                    
                    
                    
                    
                    
                    
                                          
                        
                        user.setId((int) Float.parseFloat(data.get("id").toString()));
                        user.setEmail(((String) data.get("email")));
                        user.setNom(((String) data.get("nom")));
                        
                        user.setPassword(((String) data.get("password")));
                        user.setPrenom(((String) data.get("prenom")));
                        user.setNumTel(((String) data.get("numTel")));
                        user.setRole (((String)data.get("1")));
                     
                        
                      //   Map<String, Object> data2 = (Map<String, Object>) (data.get("datenaissence"));                       
                        //List<String> content = new ArrayList<>();
                     //   content.addAll((Collection<? extends String>) (data.get("1")));
                       
                    
                } catch (IOException err) {
                    Log.e(err);                       
                }
            }
            @Override
            protected void postResponse() {
                Dialog.show("Succés", "Vos données ont éte modifier avec succés ", "cancel", "ok");
            }
        };
        //System.out.println(userlog);
//        if(authuser.user.getPassword()!=pass){
//            pass=authuser.user.getPassword();
//        }
        connectionRequest.setUrl("http://localhost/madame/web/app_dev.php/pi_mobile/edituser/"+authuser.user.getId()+"?username="+userlog+"&email="+mail+"&password="+pass+"&nom="+nom+"&prenom="+prenom);
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
}
