/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import Entity.Article;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;


import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

import com.codename1.ui.Button;
import com.codename1.ui.Container;

import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;

import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

import service.ServiceArticle;

import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import static com.codename1.uikit.cleanmodern.SignInForm.res;
import service.authuser;




/**
 *
 * @author aymen
 */
public class AffichageArticle extends Form {


  
       EncodedImage imc;
    Image img;
    ImageViewer imv;
    public static String TITRE;
    public static String TITREimage;
    public static String TITREcontenue;
    public static String TITREDATE;
    public AffichageArticle() {
       

           Picker p = new Picker();
           ServiceArticle serviceArticle = new ServiceArticle();
                   for (Article ev : serviceArticle.getList2()) {
                    Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                       Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                          Container C4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label titreE = new Label("Titre: " + ev.getNom_Article());
                 String url="http://localhost/tech-event/public/uploads/"+ev.getImage_Article();
               try {
                   imc = EncodedImage.create("/load.png");
               } catch (Exception ex) {
                 
               }
            
        img=URLImage.createToStorage(imc,""+ev.getImage_Article(), url, URLImage.RESIZE_SCALE);
             int displayHeight = Display.getInstance().getDisplayHeight();
        ScaleImageLabel scaleImageLabel = new ScaleImageLabel(img);
        Image scImage = img.scaled(-1, displayHeight / 10);
         imv= new ImageViewer(scImage);
         
            
         
         
//                Label animateurE = new Label("Animateur: " + ev.getAnimateurEvent());
//                Label lieuE = new Label("Lieu: " + ev.getLieuEvent());
//                Label lienE = new Label("Lien: " + ev.getLienEvent());
//                Label datedebE = new Label("Date debut: " + ev.getDateEvent());
//                Label datefinE = new Label("Date fin: " + ev.getDatefinEvent());
//                
//                Label nbpE = new Label("nbplace: " + ev.getNbplaceEvent());
//                Label fraisE = new Label("frais: " + ev.getFraisEvent());
//
//                
//                Label descriptionE = new Label("Description: " + ev.getDescriptionEvent()); 
//
//            
//                Label afficheE = new Label("Affiche: " + ev.getAfficheEvent());
//             
      
                            Button btnn = new Button("Supprimer "); 
                            Button btnm = new Button("Modifier "); 
                            Button btna = new Button("vue ");
                            
                            
//                            
//                            btnm.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent o) {
//
//                      ServiceArticle ser = new ServiceArticle();
////                      Reservation reser = new Reservation(LEFT, emplacement, emplacement, emplacement, DATED_EVENT, DATEF_EVENT, emplacement, CENTER)
//                      Article reser = new Article(ev.getId_Article(),  ev.getNom_Article(), ev.getTitre_Event(), ev.getContenu_Article(), ev.getImage_Article(),ev.getId_User(),ev.getDate_Article());
//                ser.modifierArticle(ser);
//                }
//            });
//                            
                            
                            btnn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent o) {


                    Dialog d = new Dialog();
                     if(authuser.user.getId()==ev.getId_User()){
                    if (Dialog.show("Confirmation", "delete this Article?", "Ok", "Annuler")) {
                        ConnectionRequest req = new ConnectionRequest();

                        req.setUrl("http://localhost/tech-event/web/app_dev.php/tech/supprimerArticle/"
                        + ev.getId_Article()
                        );
                        NetworkManager.getInstance().addToQueue(req);
                        
                        Dialog.show("Suppression", "Article " 
                                + ev.getNom_Article() + " a été supprimé avec succès!", "OK", null);
                        
                    
       AffichageArticle a =new AffichageArticle();
       a.show();
         } }
        else {
                          Dialog.show( 
                                "", ev.getNom_Article() + " c'est pas ton article!", "OK", null);
                         
                         }
                  
               }
           });
                                               btnn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent o) {


                    Dialog d = new Dialog();
                     if(authuser.user.getId()==ev.getId_User()){
                    if (Dialog.show("Confirmation", "delete this Article?", "Ok", "Annuler")) {
                        ConnectionRequest req = new ConnectionRequest();

                        req.setUrl("http://localhost/tech-event/web/app_dev.php/tech/supprimerArticle/"
                        + ev.getId_Article()
                        );
                        NetworkManager.getInstance().addToQueue(req);
                        
                        Dialog.show("Suppression", "Article " 
                                + ev.getNom_Article() + " a été supprimé avec succès!", "OK", null);
                        
                    
       AffichageArticle a =new AffichageArticle();
       a.show();
         } }
        else {
                          Dialog.show( 
                                "", ev.getNom_Article() + " c'est pas ton article!", "OK", null);
                         
                         }
                  
               }
           });

          
                                               
                                             
                                               
              btna.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent o) {


TITRE = ev.getNom_Article();
TITREimage = ev.getImage_Article();
TITREcontenue = ev.getContenu_Article();
TITREDATE =ev.getDate_Article();
AffichageArticle1 ar =new AffichageArticle1();

       ar.show();
            
               }
           });

                                               
                    btnm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent o) {

modifArticle ar =new modifArticle(ev, res);

       ar.show();

   
            
               }
           });
                               
                                               
                  
              
              
                
     
     
                            
                            
    C1.add(titreE);
    C4.add(imv);
//    C1.add(animateurE);
//    C1.add(lieuE);
//    C1.add(lienE);
//    C1.add(datedebE);
//   C1.add(datefinE);
//    C1.add(nbpE);
//    C1.add(fraisE);
//C1.add(descriptionE);
//    C1.add(afficheE);

    C2.add(btnn);
     C2.add(btnm);
     C2.add(btna);
     C3.add(C1);
     C4.add(C2);
     C3.add(C4);
   
     
     
   
    
   
 add(C3);
  
         
    
    
                            
                            
                            
                   
                   }

}}
