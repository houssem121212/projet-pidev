/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import Entity.reclamationadmin;
import Entity.reclamationmembre;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import static com.codename1.uikit.cleanmodern.SignInForm.res;
import service.ServiceArticle;
import service.ServiceReclamation;
import service.ServiceReclamationAdmin;

/**
 *
 * @author ACER
 */
public class ReclamationReponse extends Form{
   
    
  
    
    
    public ReclamationReponse(int id,Resources res){
        
    Button btnMod = new Button("valider");
    Button btnRnv = new Button("Renvoyer");
   btnMod.addActionListener((e) -> {
            ServiceReclamation ser = new ServiceReclamation();
            ser.validerRecla(id, res);
            
            
            ReclamationAffiche a = new ReclamationAffiche(res);
           a.show();
            

        });
   btnRnv.addActionListener((e) -> {
            ServiceReclamation ser = new ServiceReclamation();
            ser.RenvoyerRecla(id, res);
            
          ReclamationAffiche a = new ReclamationAffiche(res);
           a.show();  

        });
   
   
        ServiceReclamationAdmin se = new ServiceReclamationAdmin();
                   for (reclamationadmin ev : se.getList2(id)) {
                       
                    Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                       Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                          Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                          Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                
                          
                          Label titreE = new Label("Titre: " + ev.getTitreRecMembre());
                       SpanLabel contenu =  new SpanLabel("contenu: " + ev.getContenuRecAdmin());
                Label nameCat = new Label("Categorie: " + ev.getNameCat());
                SpanLabel reponse =  new SpanLabel("reponse: " + ev.getReponseRecMembre());
              Button btnA = new Button("afficher "); 
                    
              
              btnA.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent o) {



     
   
            
               }
           });
         
     C1.add(titreE);
     C2.add(contenu);
     C5.add(reponse);
     C3.add(C1);
     C3.add(C2);
     C3.add(C5);
     add(C3);
  
     
     

                   }
   add(btnMod);
   add(btnRnv);
    }


   
}

   
   
   
   
   
  
        


    