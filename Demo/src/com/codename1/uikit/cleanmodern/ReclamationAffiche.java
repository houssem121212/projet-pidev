/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import Entity.Article;
import Entity.reclamationmembre;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
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
import com.codename1.ui.util.Resources;
import static com.codename1.uikit.cleanmodern.AffichageArticle.TITRE;
import static com.codename1.uikit.cleanmodern.AffichageArticle.TITREDATE;
import static com.codename1.uikit.cleanmodern.AffichageArticle.TITREcontenue;
import static com.codename1.uikit.cleanmodern.AffichageArticle.TITREimage;
import static com.codename1.uikit.cleanmodern.SignInForm.res;
import service.ServiceArticle;
import service.ServiceReclamation;
import service.authuser;

/**
 *
 * @author ACER
 */
public class ReclamationAffiche extends Form{
  EncodedImage imc;
    Image img;
    ImageViewer imv;
    public static String TITRE;
    public static String TITREimage;
    public static String TITREcontenue;
    public static String TITREDATE;
    ComboBox<String> cb1 = new ComboBox();
    
    
    
    public ReclamationAffiche(Resources theme){
    EncodedImage imc;
    Image img;
    ImageViewer imv;
   
setTitle("reclamation");
        ReclamationArchiv a = new ReclamationArchiv(res);
       getToolbar().addCommandToLeftBar("back", null, e -> new WalkthruForm(res).show());
       getToolbar().addCommandToRightBar("Reclamer", null, e -> new HomeReclamation(theme).show());
          
       
           ServiceReclamation se = new ServiceReclamation();
                   for (reclamationmembre ev : se.getList2()) {
                       
                    Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                       Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                          Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                          Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                
                          
                          Label titreE = new Label("Titre: " + ev.getTitreRecMembre());
                       SpanLabel contenu =  new SpanLabel("contenu: " + ev.getContenuRecMembre());
                Label nameCat = new Label("Categorie: " + ev.getContenuRecMembre());
              Button btnA = new Button("afficher "); 
                    
              
              btnA.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent o) {

ReclamationReponse ar =new ReclamationReponse(ev.getIdRecMembre(),res);

       ar.show();

   
            
               }
           });
         
     C1.add(titreE);
     C2.add(contenu);
     C4.add(btnA);
     C3.add(C1);
     C3.add(C2);
     C3.add(C4);
     
     add(C3);
  
     
     

                   }}}
