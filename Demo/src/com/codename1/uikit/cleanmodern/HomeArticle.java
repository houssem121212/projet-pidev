/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;


import Entity.Article;
import com.codename1.io.FileSystemStorage;
import service.ServiceArticle;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author Administrator
 */
public class HomeArticle extends Form{
    //Form hi = new Form();
    //Form f;
    private Label titreEror;
    TextField tnomarticle;
      TextField tncontenueArticle;
    TextField combo;

  
    Container descriptionContainer;
    Button btajout,btnaff,btsupp;

    public HomeArticle(Resources theme)  {
       
        
   ///     f = new Form("home");
        tnomarticle = new TextField("","titre");
        tnomarticle.getUnselectedStyle().setFgColor(000255);
       tncontenueArticle = new TextField("","contenue Article");
       tncontenueArticle.getUnselectedStyle().setFgColor(000255);
         combo = new TextField("","titre Event");
        combo.getUnselectedStyle().setFgColor(000255);
    
        btajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        btsupp=new Button("Supprimer");

        
     
      
       SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
       
        
        
    
        
        Label photoLabel = new Label("Photo");
        Button selectPhoto = new Button("parcourir");
        TextField photoField = new TextField("", "Importer une photo", 10, TextArea.ANY);
        photoField.setEditable(false);
        selectPhoto.addActionListener((evt) -> {
            if (Dialog.show("Photo!", "une annonce avec des  photos est 10 fois plus visible", "app photo", "Gallerie") == false) {
                Display.getInstance().openGallery((e) -> {
                   
                    
                    if (e != null && e.getSource() != null) {
                    String     path = (String) e.getSource();
                        System.out.println(path.substring(7));
                        Image img = null;
                        photoField.setText(path.substring(7));//image heya just label nsob feha fel path
                        try {
                            img = Image.createImage(FileSystemStorage.getInstance().openInputStream(path));
                            System.out.println(img);
                        } catch (Exception ex) {
                            
                        }
                    }
                    
                    
                    
                }, Display.GALLERY_IMAGE);
            } else {
                System.out.println("ici on va accerder à l'appareille photo");
            }
        });
        Container photoContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        photoContainer.add(photoLabel);
        photoContainer.add(photoField);
        photoContainer.add(selectPhoto);

        add(tnomarticle);
       add(tncontenueArticle);
       add(combo);

       
      
        add(photoContainer);
        add(btajout);
        add(btnaff);
         add(btsupp);
        btajout.addActionListener((e) -> {
            
            if (tnomarticle.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","TITRE VIDE","OK","ANNULER");
            }

             
     
            else if (photoField.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Choisisez une image","OK","ANNULER");
            }
             
            else{

            
            ServiceArticle ser = new ServiceArticle();
            
            
            FileUploader fc = new FileUploader("localhost/tech-event/");
 try{
 String f = fc.upload(photoField.getText());
            
            
            Article article = new Article(1,tnomarticle.getText(),tncontenueArticle.getText(),f,combo.getText(),
                   1,"12/12/2020" );
           
            ser.ajoutArticle(article);
           Dialog.show("felicitation", " votre Article a ete ajoute", "ok", null);            
 }catch(Exception ex){}       
 
 }
        });
       
        btnaff.addActionListener((e)->{
       AffichageArticle a =new AffichageArticle();
       a.show();
        });
    }
//
//    public Form getF() {
//        return f;
//    }
//
//    public void setF(Form f) {
//        this.f = f;
//    }

  
    public Label getTitreEror() {
        return titreEror;
    }

    public void setTitreEror(Label titreEror) {
        this.titreEror = titreEror;
    }

    public TextField getTnomarticle() {
        return tnomarticle;
    }

    public void setTnomarticle(TextField tnomarticle) {
        this.tnomarticle = tnomarticle;
    }

    public TextField getCombo() {
        return combo;
    }

    public void setCombo(TextField combo) {
        this.combo = combo;
    }

    public Container getDescriptionContainer() {
        return descriptionContainer;
    }

    public void setDescriptionContainer(Container descriptionContainer) {
        this.descriptionContainer = descriptionContainer;
    }

    public Button getBtajout() {
        return btajout;
    }

    public void setBtajout(Button btajout) {
        this.btajout = btajout;
    }

    public Button getBtnaff() {
        return btnaff;
    }

    public void setBtnaff(Button btnaff) {
        this.btnaff = btnaff;
    }

   
   
    
   

    public boolean isAFloat(String x) {
        try {
            Float.parseFloat(x);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    
public boolean isAEntier(String x) {
        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
