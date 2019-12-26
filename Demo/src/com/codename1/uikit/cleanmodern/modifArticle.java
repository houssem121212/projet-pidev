/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import Entity.Article;
import static com.codename1.charts.util.ColorUtil.CYAN;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;


import java.io.IOException;
import rest.file.uploader.tn.FileUploader;
import service.ServiceArticle;


/**
 *
 * @author Oumayma
 */
public class modifArticle extends Form {

    Form f;
    TextField TITRE;
    TextField TITREimage;
    TextField TITREcontenue;
    TextField TITREvnt;

    Button btnMod, btnAnnuler, imgBtn;
    ImageViewer imv;
    Image img;
    String path;
    EncodedImage enc;

    String imgName;
    String imgUrl;

    public modifArticle(Article ta, Resources res) {
        f = new Form("Modification");
        ImageViewer imgV = new ImageViewer();
        Image placeholder = Image.createImage(180, 150);
        try {
            enc = EncodedImage.create("/load.png");
            //imgName = "img" + compteur;
            imgUrl = "http://localhost/tech-event/public/uploads/"+ta.getImage_Article();
        } catch (IOException ex) {
        }
        //img = URLImage.createToStorage(enc, imgName, imgUrl, URLImage.RESIZE_SCALE);
             
        img=URLImage.createToStorage(enc,""+ta.getImage_Article(), imgUrl, URLImage.RESIZE_SCALE);
             int displayHeight = Display.getInstance().getDisplayHeight();
        ScaleImageLabel scaleImageLabel = new ScaleImageLabel(img);
        Image scImage = img.scaled(-1, displayHeight / 10);
         imv= new ImageViewer(scImage);
       // imv = new ImageViewer(img);
        //compteur++;
        TITRE = new TextField(ta.getNom_Article());
        TITRE.getAllStyles().setFgColor(CYAN);
        TITREcontenue = new TextField(ta.getContenu_Article());
         TITREcontenue.getAllStyles().setFgColor(CYAN);
        TITREvnt = new TextField(ta.getTitre_Event());
       
        btnMod = new Button("Modifier");
        btnAnnuler = new Button("Annuler");
       
        
        btnMod.addActionListener((e) -> {
            ServiceArticle ser = new ServiceArticle();
            ta.setNom_Article(TITRE.getText());
            ta.setContenu_Article(TITREcontenue.getText());
            ta.setTitre_Event(TITREvnt.getText());
          
            ser.modifierArticle(ta, res);

        });

        btnAnnuler.addActionListener((e) -> {
         
        });
         f.add(img);
        f.add(TITRE);
        f.add(TITREcontenue);
        f.add(TITREvnt);
     
        f.add(btnMod);
        f.add(btnAnnuler);
        add(f);
    }

   

}
