/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import Entity.event;

import Entity.Evennement;
import com.codename1.io.FileSystemStorage;
import service.ServiceEvents;

import com.codename1.l10n.ParseException;
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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import java.io.IOException;

import rest.file.uploader.tn.FileUploader;

//import rest.file.uploader.tn.FileUploader;



/**
 *
 * @author Administrator
 */
public class Homes extends Form{
    //Form hi = new Form();
    //Form f;
    private Label titreEror;
    TextField ttitre;
   
    TextField tEmplacement;
    TextField tcategorie; //categorie
   
    TextField nbplaceeLabel;
    Picker datedeb ;
    Picker datefin;
    Container descriptionContainer;
    Button btnajout,btnaff;

    public Homes(Resources theme)  {
       
        
   ///     f = new Form("home");
        ttitre = new TextField("","titre",20,TextField.ANY);
       ttitre.getUnselectedStyle().setFgColor(621200);
       
        tEmplacement = new TextField("","Emplacement");
        tEmplacement.getUnselectedStyle().setFgColor(621200);
        tcategorie = new TextField("","categorie");
      tcategorie.getUnselectedStyle().setFgColor(621200);
       
        nbplaceeLabel = new TextField("","nbplaceeLabel");
        nbplaceeLabel.getUnselectedStyle().setFgColor(621200);
        btnajout = new Button("ajouter");
        btnajout.getUnselectedStyle().setFgColor(621200);
        btnaff=new Button("Affichage");
        btnaff.getUnselectedStyle().setFgColor(621200);
        
        btnaff.getUnselectedStyle().setFgColor(100000);
        btnajout.getUnselectedStyle().setFgColor(654111);
        
      btnajout.getAllStyles().setBorder(Border.createRoundBorder(12, 12));
        
        Container dateContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Picker datedeb = new Picker();
       datedeb.getUnselectedStyle().setFgColor(621200);
        Label temp = new Label("date de debut");
        dateContainer.add(temp);
        dateContainer.add(datedeb);
        
        Container dateContainer2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Picker datefin = new Picker();
        datefin.getUnselectedStyle().setFgColor(621200);
        Label temp2 = new Label("date de fin");
        dateContainer2.add(temp2);
        dateContainer2.add(datefin);
      
       SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
       
        
        
        Label descriptionLabel = new Label("Description : ");
        TextArea descriptionArea = new TextArea(3, 20);
        Container descriptionContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        descriptionContainer.add(descriptionLabel);
        descriptionContainer.add(descriptionArea);
        
        
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

        add(ttitre);
       
        add(tEmplacement);
        add(tcategorie);
        add(dateContainer);
        add(dateContainer2);
        
        add(nbplaceeLabel);
       
        add(descriptionContainer);
        add(photoContainer);
        add(btnajout);
        add(btnaff);
         
        btnajout.addActionListener((e) -> {
            
            if (ttitre.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","TITRE VIDE","OK","ANNULER");
            }
            
          
            else if (tEmplacement.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Lieu VIDE","OK","ANNULER");
            }
            else if (tcategorie.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Lien VIDE","OK","ANNULER");
            }
            
            
             else if (nbplaceeLabel.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Nbplaces Vide","OK","ANNULER");
            }
             
            
             else if (!isAEntier(nbplaceeLabel.getText())) {
                
                Dialog.show("ERREUR SAISIE","nbplaces doit etre numeric","OK","ANNULER");
            }
            else if (descriptionArea.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Description VIDE","OK","ANNULER");
            }
            else if (photoField.getText().equals("")) {
                
                Dialog.show("ERREUR SAISIE","Choisisez une image","OK","ANNULER");
            }
             
            else{

            
            ServiceEvents ser = new ServiceEvents();
 FileUploader fc = new FileUploader("localhost/tech-event/");
 try{
 String f = fc.upload(photoField.getText());
            Evennement ev1 = new Evennement(descriptionArea.getText(),f,ttitre.getText(), datedeb.getDate(), datefin.getDate(), tEmplacement.getText(),
                   1 ,tcategorie.getText(),Integer.parseInt(nbplaceeLabel.getText()));
            
           
            ser.ajoutEvent(ev1);
           Dialog.show("felicitation", " votre evenement a ete ajoute", "ok", null);            
        }catch(Exception ex){}
            }
            
        });
       
        btnaff.addActionListener((e)->{
        Affichage a;
        
                a = new Affichage();
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

    public TextField getTtitre() {
        return ttitre;
    }

    public void setTtitre(TextField ttitre) {
        this.ttitre = ttitre;
    }

  
    public TextField gettEmplacement() {
        return tEmplacement;
    }

    public void settEmplacement(TextField tEmplacement) {
        this.tEmplacement = tEmplacement;
    }

    public TextField getTcategorie() {
        return tcategorie;
    }

    public void setTcategorie(TextField tcategorie) {
        this.tcategorie = tcategorie;
    }

    public TextField getNbplaceeLabel() {
        return nbplaceeLabel;
    }

    public void setNbplaceeLabel(TextField nbplaceeLabel) {
        this.nbplaceeLabel = nbplaceeLabel;
    }

    public Picker getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(Picker datedeb) {
        this.datedeb = datedeb;
    }

    public Picker getDatefin() {
        return datefin;
    }

    public void setDatefin(Picker datefin) {
        this.datefin = datefin;
    }

    public Container getDescriptionContainer() {
        return descriptionContainer;
    }

    public void setDescriptionContainer(Container descriptionContainer) {
        this.descriptionContainer = descriptionContainer;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
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
