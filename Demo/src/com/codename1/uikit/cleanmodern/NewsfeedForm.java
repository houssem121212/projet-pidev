/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.cleanmodern;

import Entity.Evennement;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Slider;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import service.ServiceEvents;
import service.authuser;

/**
 * The newsfeed form
 *
 * @author Shai Almog
 */
public class NewsfeedForm extends BaseForm {
   Label nom;
    Label supp;
    Label modif;
    Button ajout;
    Button rech;
    Label jaim;
    Label jaimpas;
    Label panier;
    TextField re;
    
    public NewsfeedForm(Resources res) {
        
        super("Newsfeed", BoxLayout.y());
         Image icon1 = res.getImage("tech.jpg");
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Nos Evennemnt");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        tb.addSearchCommand(e -> {});
        
        tb.addCommandToOverflowMenu("Filtrage", null, new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt) {
                       // ProduitForm fp=new ProduitForm(theme);
                UIBuilder ui = new UIBuilder(); 
         Container ct1 = ui.createContainer(res, "Filtrage");
         Form fp= (Form)ct1;
           
            System.out.println("Filtrage");
            
        fp.show();
        
          Slider sl = (Slider) ui.findByName("Slider", ct1);
          Button btfiltre = (Button) ui.findByName("Button", ct1);
          Label lab = (Label) ui.findByName("Label", ct1);
          
          //getStyle().setBgColor(0x000000);
          
              sl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                lab.setText("Prix:"+sl.getProgress()); 
                System.out.println(sl.getProgress());
            }
        });
              
            Form f1 = new Form();
       Toolbar tf2 = new Toolbar(true);
                        f1.setToolbar(tf2);
                        f1.getToolbar().getStyle().setBgColor(0xD3D3D3);
                        f1.getToolbar().getStyle().setBgTransparency(250);
                        f1.getToolbar().setTitle("Favoris");
                        
                        f1.getToolbar().addCommandToLeftBar("back", res.getImage("back-command.png"), new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                
                                NewsfeedForm produit = new NewsfeedForm(res); // Logger.getLogger(AboutForm.class.getName()).log(Level.SEVERE, null, ex);
                                produit.show();
                            }
                        });  
         btfiltre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                boolean d;
                d =Dialog.show("Prix", "Voulez-vous Choisir le prix "+sl.getProgress(), "Yes", "No");
               
                
                
                     ConnectionRequest conF = new ConnectionRequest();
       // ConnectionRequest con2 = new ConnectionRequest();
        conF.setUrl("http://localhost/madame/web/app_dev.php/pi_mobile/Prix/"+sl.getProgress());
       // con2.setUrl("http://localhost/madame/web/app_dev.php/pi_mobile/produitSearch/"+re.getText());
        
              NetworkManager.getInstance().addToQueue(conF);
       
            
              
            }
        });
          
     
      

            }
 });
       
     
        Tabs swipe = new Tabs();

        Label spacer1 = new Label();
        Label spacer2 = new Label();
        addTab(swipe, res.getImage("news-item.jpg"), spacer1, "", "","");
        addTab(swipe, res.getImage("dog.jpg"), spacer2,"","","");
                
        swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();
        
        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for(int iter = 0 ; iter < rbs.length ; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }
                
        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if(!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });
        
        Component.setSameSize(radioContainer, spacer1, spacer2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));
        
        ButtonGroup barGroup = new ButtonGroup();
          RadioButton news = RadioButton.createToggle("News", barGroup);
        news.setUIID("SelectBar");
        RadioButton Evennement = RadioButton.createToggle("Evennement", barGroup);
        Evennement.setUIID("SelectBar");
        RadioButton traditionalfood = RadioButton.createToggle("Article", barGroup);
        traditionalfood.setUIID("SelectBar");
        RadioButton artisanial = RadioButton.createToggle("Formation", barGroup);
        artisanial.setUIID("SelectBar");
        RadioButton other = RadioButton.createToggle("Other", barGroup);
        other.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");
        
        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(5, news, Evennement, traditionalfood, artisanial, other),
                FlowLayout.encloseBottom(arrow)
        ));
        Tabs tab=new Tabs();
        Container ct=new Container();
   
        news.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(news, arrow);
        });
        bindButtonSelection(news, arrow);
        bindButtonSelection(Evennement, arrow);
        bindButtonSelection(traditionalfood, arrow);
        bindButtonSelection(artisanial, arrow);
        bindButtonSelection(other, arrow);
        
        
        
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });
        
//        artisanial.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("artisanial");
//             ConnectionRequest conE = new ConnectionRequest();
//        conE.setUrl("http://localhost/madame/web/app_dev.php/pi_mobile/Artisanaa");
//        conE.addResponseListener(new ActionListener<NetworkEvent>() {
//
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//
//               ArrayList<Produit> list = new ArrayList<>();
//               list.addAll(getListEtudiant(new String(conE.getResponseData())));
//          
//               
//                for (Produit eq : getListEtudiant(new String(conE.getResponseData()))) {
//                   try {
//                       addItem(eq,res,icon1);
//                   } catch (IOException ex) {
//                    
//                   }
//                }
//                Container C = new Container(new BoxLayout(BoxLayout.X_AXIS));
//             
//                add(C);
//
//            }
//        });
//        NetworkManager.getInstance().addToQueue(conE);
//        //fh.show();
//            }
//        });
        
        //////////////////
        // Affichage Evenement
        //////////
        
            Evennement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.err.println("Evennement");
             ConnectionRequest conE = new ConnectionRequest();
        conE.setUrl("http://localhost/tech-event/web/app_dev.php/tech/listE");
        
        
         conE.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                
                ServiceEvents a = new ServiceEvents();
                
              ArrayList<Evennement> list = new ArrayList<>();
              list.addAll(a.getlistE((new String(conE.getResponseData()))));
              
              System.err.println(list);
              
              for (Evennement eq : a.getlistE(new String(conE.getResponseData()))) {
                   try {
                       
//                       addItem(eq,res,icon1);
                       System.err.println("dkhalt lil try");
                      
                   } catch (Exception ex) {
                       System.err.println("dkhalt lil catch");
                    
                   }
                }
               
          
                System.err.println("RJA3");
            
                Container C = new Container(new BoxLayout(BoxLayout.X_AXIS));
             
                add(C);

            }
        });
        
        
      
        NetworkManager.getInstance().addToQueue(conE);
        //fh.show();
            }
        });
            
//            other.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("other");
//             ConnectionRequest conA = new ConnectionRequest();
//        conA.setUrl("http://localhost/madame/web/app_dev.php/pi_mobile/Otherr");
//       
//        NetworkManager.getInstance().addToQueue(conA);
//        //fh.show();
//            }
//        });
        
////        addButton(res.getImage("news-item-1.jpg"), "Morbi per tincidunt tellus sit of amet eros laoreet.", false, 26, 32);
////        addButton(res.getImage("news-item-2.jpg"), "Fusce ornare cursus masspretium tortor integer placera.", true, 15, 21);
////        addButton(res.getImage("news-item-3.jpg"), "Maecenas eu risus blanscelerisque massa non amcorpe.", false, 36, 15);
////        addButton(res.getImage("news-item-4.jpg"), "Pellentesque non lorem diam. Proin at ex sollicia.", false, 11, 9);
   ConnectionRequest con1 = new ConnectionRequest();
       // ConnectionRequest con2 = new ConnectionRequest();
        con1.setUrl("http://localhost/madame/web/app_dev.php/pi_mobile/filtre");
       // con2.setUrl("http://localhost/madame/web/app_dev.php/pi_mobile/produitSearch/"+re.getText());
        
        NetworkManager.getInstance().addToQueue(con1);

    
    
    
    
    
    
    
    
    }
    
    
    
    private void updateArrowPosition(Button b, Label arrow) {
        arrow.getUnselectedStyle().setMargin(LEFT, b.getX() + b.getWidth() / 2 - arrow.getWidth() / 2);
        arrow.getParent().repaint();
        
        
    }
    
    private void addTab(Tabs swipe, Image img, Label spacer, String likesStr, String commentsStr, String text) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        if(img.getHeight() < size) {
            img = img.scaledHeight(size);
        }
        Label likes = new Label(likesStr);
        Style heartStyle = new Style(likes.getUnselectedStyle());
        heartStyle.setFgColor(0xff2d55);
        FontImage heartImage = FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, heartStyle);
        likes.setIcon(heartImage);
        likes.setTextPosition(RIGHT);

        Label comments = new Label(commentsStr);
        FontImage.setMaterialIcon(comments, FontImage.MATERIAL_CHAT);
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 2) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
        ScaleImageLabel image = new ScaleImageLabel(img);
        image.setUIID("Container");
        image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        Label overlay = new Label(" ", "ImageOverlay");
        
        Container page1 = 
            LayeredLayout.encloseIn(
                image,
                overlay,
                BorderLayout.south(
                    BoxLayout.encloseY(
                            new SpanLabel(text, "LargeWhiteText"),
                            FlowLayout.encloseIn(likes, comments),
                            spacer
                        )
                )
            );

        swipe.addTab("", page1);
    }
    
  
    
    private void bindButtonSelection(Button b, Label arrow) {
        b.addActionListener(e -> {
            if(b.isSelected()) {
                updateArrowPosition(b, arrow);
            }
        });
    }
    
    
    
    
//    
//    
//     public void addItem(Evennement eq,Resources theme,Image icon1) throws IOException {
//         
//         
//         System.err.println(eq);
//         
//         
//         TextField a = new TextField();
//        
//         a.setText(eq.getTitre_Event());
//         
//           UIBuilder  ui = new UIBuilder();
//         Container ct1;
// 
//      Form f1 = new Form();
//         
//    EncodedImage imc;
//    Image img;
//    ImageViewer imv;
//    Container ct3 ;
//   String url="http://localhost/tech-event/public/uploads"+eq.getImage_Event();
//        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
//        Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
//        Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
//      Label  nom = new Label(eq.getTitre_Event());
//       Label supp = new Label("Voir plus");
//    imc = EncodedImage.create("/load.png");
//            
//        img=URLImage.createToStorage(imc,""+eq.getImage_Event(), url, URLImage.RESIZE_SCALE);
//             int displayHeight = Display.getInstance().getDisplayHeight();
//        ScaleImageLabel scaleImageLabel = new ScaleImageLabel(img);
//        Image scImage = img.scaled(-1, displayHeight / 10);
//         imv= new ImageViewer(scImage);
//        supp.getAllStyles().setFgColor(0xFF0000);
//
//      
////     addButton(theme,scImage, eq,nom.getText(), false, 26, 32);
//
//   
//        supp.addPointerPressedListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                
//                
//             f1.show();
//////              Label lnom = new Label ("Le nom est: "+eq.getNom());
//////              Label lref = new Label ("La reference est: "+eq.getReference());
//////              Label lcat = new Label ("La categorie est: "+eq.getCategorie());
//////              
//////              Label ldesc = new Label ("La description est: "+eq.getDescription());
//////              Label lprix = new Label ("Le prix est: "+eq.getPrix()+"DT");
//////              
////              f1.add(lnom);
////              f1.add(lref);
////              f1.add(lcat);
////              f1.add(ldesc);
////              f1.add(lprix);
////     
//              Image scImage1 = img.scaled(-1, displayHeight / 3);
//              ImageViewer imvo;
//              imvo= new ImageViewer (scImage1);
//              
//              
//              Container cnt = new Container (new BoxLayout (BoxLayout.X_AXIS) );
//               Container cnt1 = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
//              cnt.add(imvo);            
//            Label jaim = new Label("J'aime");
//             Label jaimpas= new Label("J'aime pas");
//            Label panier= new Label("Ajouter au panier");
//             jaim.getAllStyles().setFgColor(0xFF0000);
//             jaimpas.getAllStyles().setFgColor(0xFF0000);
//             panier.getAllStyles().setFgColor(0xFF0000);
//             
//             cnt1.add(jaim);
//             cnt1.add(jaimpas);
//             cnt1.add(panier);
//             cnt.add(cnt1);  
//             f1.add(cnt);
//              f1.getToolbar().addCommandToLeftBar("back",icon1,new ActionListener<ActionEvent>() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
////              ProduitForm produit=new ProduitForm(theme);
////                produit.show();
//
//            }
//        });
//
//
//            }
//
//        });
//               
//               
//               
//               
//               
//    }

//    private void addButton(Resources theme, Image scImage, Evennement eq, String text, boolean b, int i, int i0) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    
    
    
    
    
    
}
