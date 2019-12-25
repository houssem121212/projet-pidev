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

import service.authuser;




/**
 *
 * @author bhk
 */
public class AffichageArticle1 extends Form {

    Label titre;
      
      
   
   
  
       EncodedImage imc;
    Image img;
    ImageViewer imv;
    public AffichageArticle1() {
       
                    Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                      
                Label titreE = new Label("Titre: " + AffichageArticle.TITRE);
                 String url="http://localhost/tech-event/public/uploads/"+AffichageArticle.TITREimage;
                 try {
                   imc = EncodedImage.create("/load.png");
               } catch (Exception ex) {
                 
               }
            System.out.println(AffichageArticle.TITREimage);
      img=URLImage.createToStorage(imc,""+AffichageArticle.TITREimage, url, URLImage.RESIZE_SCALE);
            int displayHeight = Display.getInstance().getDisplayHeight();
       ScaleImageLabel scaleImageLabel = new ScaleImageLabel(img);
       Image scImage = img.scaled(-1, displayHeight / 10);
        imv= new ImageViewer(scImage);
         
        
                            Label titreContenue = new Label("Titre: " + AffichageArticle.TITREcontenue);
        System.out.println(AffichageArticle.TITREcontenue);
                                    Label titreDate = new Label("Titre: " + AffichageArticle.TITREDATE);

         
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




                                    
          
    C1.add(titreE);
    C1.add(imv);
    C1.add(titreContenue);
    C1.add(titreDate);
    add(C1);
   // C1.add(imv);
          

//    C1.add(animateurE);
//    C1.add(lieuE);
//    C1.add(lienE);
//    C1.add(datedebE);
//   C1.add(datefinE);
//    C1.add(nbpE);
//    C1.add(fraisE);
//C1.add(descriptionE);
//    C1.add(afficheE);

   
   
     
     
   
    
   

  
   
                            
                            
                            
                   
    } }


