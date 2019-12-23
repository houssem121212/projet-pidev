/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import java.util.List;
import com.codename1.uikit.cleanmodern.SignInForm;
import com.codename1.uikit.cleanmodern.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.NewsfeedForm;
//import com.codename1.uikit.cleanmodern.NewsfeedForm;
import com.codename1.uikit.cleanmodern.SignUpForm;
//import service.MD5;

/**
 *
 * @author Asus
 */
public class authuser {

    public static User user = new User();
   // public static User onlineId = new User();
    
    int temp;
    
    public void login(Resources res) {
        // TextField userlogin = (TextField) SignInForm.builder.findByName("Username", SignInForm.ctn);
        //TextField passlogin = (TextField) SignInForm.builder.findByName("Password", SignInForm.ctn);
        String userlog = SignInForm.username.getText();
        String passlog = SignInForm.password.getText();

        ConnectionRequest connectionRequest;
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void readResponse(InputStream input) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(input, "UTF-8");
                    Map<String, Object> data = json.parseJSON(reader);
                    if (data.isEmpty()) {
                        Dialog.show("error", "Email not found ! please retry ", "Cancel", "ok");
                    } else {
                        user.setId((int) Float.parseFloat(data.get("id").toString()));
                        user.setEmail(((String) data.get("email")));
                        user.setNom(((String) data.get("username")));
                        user.setPassword(((String) data.get("password")));
                        user.setPrenom(((String) data.get("prenom")));
                        user.setNumTel(((String) data.get("numTel")));
                        user.setNom(((String) data.get("username")));
                        user.setClasse(((String) data.get("classe")));
                        
                        System.err.println(user.getNom());
                        /*Map<String, Object> data2 = (Map<String, Object>) (data.get("datenaissence"));
                        temp = (int) Float.parseFloat(data2.get("timestamp").toString());
                        Date myDate = new Date(temp * 1000L);
                        //user.setDateNaissence(myDate);*/
                        List<String> content = new ArrayList<>();
//                        content.addAll((Collection<? extends String>) (data.get("role")));
//                        user.setRole(content.get(1));
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }

            @Override
            protected void postResponse() {
                System.out.println(user);
                if (passlog.equals("")) {
                    Dialog.show("error", "Please put your password ! ", "cancel", "ok");
                    return;
                } 
                if (!(user.getPassword().equals((passlog)))) {
                    System.out.println(user.getPassword());
                    System.out.println(passlog);
                    Dialog.show("error", "Wrong password please retry! ", "cancel", "ok");
                    return;
                }
                 
                    if (user.getRole() == "1") {
 new NewsfeedForm(res).show();
                        
                    
                    }else{
                        Dialog.show("error", "Votre Espace n'est pas encore pret ", "cancel", "ok");
                        return;
                    }
                    
                
            }
        };
        System.out.println(userlog);
//        connectionRequest.setUrl("http://localhost:8081/apijsonpi/web/app_dev.php/api/finduser/" + userlog);
        connectionRequest.setUrl("http://localhost/tech-event/web/app_dev.php/tech/finduser/" + userlog);
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

    public void RegisterUser(Resources res) {
        String rol = "ROLE_CLIENT";
        String userlog = SignUpForm.username.getText();
        String pass = SignUpForm.password.getText();
        String email = SignUpForm.email.getText();
        String conpass = SignUpForm.confirmPassword.getText();
        String numtel = SignUpForm.numtel.getText();
        String adresse = SignUpForm.adresee.getText();
        String role = "";
        /*affichage données test
        System.out.println(userlog);
        System.out.println(pass);
        System.out.println(conpass);
        System.out.println(numtel);
        System.out.println(adresse);
        System.out.println(role);
        System.out.println(email);
        System.out.println(role);
        System.out.println(role);*/
      
        
        
        
        
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        if (!pass.equals(conpass)) {
            Dialog.show("error", "please confirm your password ", "cancel", "ok");
            return;
        }
       
        
        
       if (userlog.equals(".")|| userlog.equals("&")|| userlog.equals("é")|| userlog.equals("'")   ) {
            Dialog.show("Champs Incorrecte", "Corriger le Nom svp  ", "Ok", null);
       return;
       }
       
          if(userlog.length()==0||pass.length()==0||email.length()==0||conpass.length()==0
                        ||numtel.length()==0||adresse.length()==0){
                     Dialog.show("Champs Incorrecte", "Tous les champs sont obligatoires", "Ok", null);
                     return;
          }
        
        
        
        
        else {
            user.setNom(userlog);
            user.setPassword(pass);
            user.setEmail(email);
            user.setNumTel(email);
            user.setClasse(adresse);
            user.setRole(rol);
        }
        ConnectionRequest connectionRequest;
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void readResponse(InputStream input) throws IOException {
                System.out.println(input);

            }

            @Override
            protected void postResponse() {
                if (user.getRole().equals("1")) {
//                        new NewsfeedForm(res).show();
                    Message m = new Message("Bienvenue dans Souk EL Madina Application Mr " +user.getNom() + "  votre mot de pass est :" + user.getPassword() );
                        m.getAttachments().put("test", "votre compte à été créer avec succeé/plain");
                        //m.getAttachments().put(imageAttachmentUri, "image/png");
                        Display.getInstance().sendMessage(new String[]{user.getEmail()}, "Bienvenue ", m);
                    System.out.println("corect");
                }else{
                    Dialog.show("error", "Votre Espace n'est pas encore pret ", "cancel", "ok");
                }
            }
        };
//        connectionRequest.setUrl("http://localhost:8081/apijsonpi/web/app_dev.php/api/newuser?username=" + userlog + "&email=" + email + "&password=" + MD5.hash(pass) + "&role=" + rol + "&numtel=" + numtel + "&adresse=" + adresse);
        connectionRequest.setUrl("http://localhost/tech-event/web/app_dev.php/tech/newuser?username=" + userlog + "&email=" + email + "&password=" + pass + "&role=" + rol + "&numtel=" + numtel + "&classe=" + adresse);
        NetworkManager.getInstance().addToQueue(connectionRequest);

    }
    
     
}
