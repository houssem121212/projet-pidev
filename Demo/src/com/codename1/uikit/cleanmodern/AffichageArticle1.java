/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import Entity.Evennement;
import Entity.event;
import service.ServiceEvents;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.io.IOException;





/**
 *
 * @author bhk
 */
public class Affichage extends Form {

    Label titre;
        Label animateur;
        Label lieu;
        Label lien;
        Label datedeb;
        Label datefin;
        Label nbp;
        Label frais;
        Label description;
       Label affiche;
  
       EncodedImage imc;
    Image img;
    ImageViewer imv;
    public Affichage() {
       

           Picker p = new Picker();
           ServiceEvents serviceTask = new ServiceEvents();
                   for (Evennement ev : serviceTask.getList2()) {
                    Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                Label titreE = new Label("Titre: " + ev.getTitre_Event());
                 String url="http://localhost/tech-event/public/uploads/"+ev.getImage_Event();
               try {
                   imc = EncodedImage.create("/load.png");
               } catch (Exception ex) {
                 
               }
            
        img=URLImage.createToStorage(imc,""+ev.getImage_Event(), url, URLImage.RESIZE_SCALE);
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
                            Button btnn = new Button("Supprimer reclamation"); 
                            
//                            btnn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent o) {
//
//                    Dialog d = new Dialog();
//
//                    if (Dialog.show("Confirmation", "delete this reclamation??", "Ok", "Annuler")) {
//                        ConnectionRequest req = new ConnectionRequest();
//
//                        req.setUrl("http://localhost/project2/web/app_dev.php/supp/"
//                        + ev.getId()
//                        );
//                        NetworkManager.getInstance().addToQueue(req);
//                        Dialog.show("Suppression", "Evenement " 
//                                + ev.getTitreEvent() + " a été supprimé avec succès!", "OK", null);
//
//                    }
//                }
//            });
                           
    C1.add(titreE);
    C1.add(imv);
//    C1.add(animateurE);
//    C1.add(lieuE);
//    C1.add(lienE);
//    C1.add(datedebE);
//   C1.add(datefinE);
//    C1.add(nbpE);
//    C1.add(fraisE);
//C1.add(descriptionE);
//    C1.add(afficheE);
    C1.add(btnn);
    add(C1);
         
   
    
                            
                            
                            
                   
                   }

}}
