/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import Entity.Article;
import Entity.reclamationmembre;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import service.ServiceArticle;
import service.ServiceReclamation;

/**
 *
 * @author ACER
 */
public class HomeReclamation extends Form{
    
    TextField TitreRecMembre;
    TextField ContenuRecMembre;
    TextField NameCat;
    Button btnAjout;
     String s1;
    ComboBox<String> cb1 = new ComboBox();
    
    public HomeReclamation(Resources theme){
        
       Container cnt1=new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
    TitreRecMembre = new TextField(""," titre ");
    ContenuRecMembre =  new TextField(""," Contenu ");
    NameCat = new TextField("","name categorie");
    btnAjout = new Button("reclamer");
    

        cb1.addItem("Article");
        cb1.addItem("Formation");
        cb1.addItem("Evenement");
    
    
    
    cnt1.add(TitreRecMembre);
    cnt1.add(ContenuRecMembre);
    cnt1.add(cb1);
    cnt1.add(btnAjout);
    add(cnt1);
     btnAjout.addActionListener((e) -> {
            
            if (TitreRecMembre.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","TITRE VIDE","OK","ANNULER");
            }

            else if (ContenuRecMembre.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","contenu VIDE","OK","ANNULER");
            }
            
             
            else{

            
             if (cb1.getSelectedIndex()==0){
                s1 ="Article";
           }
             if (cb1.getSelectedIndex()==1){
                 s1 ="Formation";
           }
              if (cb1.getSelectedItem().equals("Evenement")){
                 s1 ="Evenement";
           }
            
                
                
                
                ServiceReclamation ser = new ServiceReclamation();
                reclamationmembre rec = new reclamationmembre(TitreRecMembre.getText(),ContenuRecMembre.getText(), s1);
           
            ser.ajoutreclamation(rec);
           Dialog.show("felicitation", " votre reclamation a ete ajoute", "ok", null);            
        
            ReclamationAffiche a = new ReclamationAffiche(theme);
            a.show();
            
            }
        });
    
    
    
    
    
    
    }
     
}
