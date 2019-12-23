/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import static com.codename1.charts.util.ColorUtil.CYAN;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
//import service.ServiceEvent;
//import entity.Event;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import rest.file.uploader.tn.FileUploader;
import service.authuser;


/**
 *
 * @author sana
 */
public class HomeForm  extends BaseForm{

    Form f;
    TextField ttitre;
    TextField tdescription;
    TextField tlieu;
    TextField tprix;
    TextField tnbreticket;
    TextField image;
    String path;

    Button btnajout,btnaff,imgBtn;
 //  private Resources res;
   
    /*  public void init(Object context) {
        res = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        
        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
        
    }*/
 //public HomeForm()  {
        
        //this(com.codename1.ui.util.Resources.getGlobalResources());
   // }
    public Form HomeForm(Resources res) {
        //super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);
        
        //super.addSideMenu(res);
            // tb.addSearchCommand(e -> {});
   
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }/*
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("15364 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("5648 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(2, 
                            facebook,
                            twitter
                    )
                )
        ));

        
        */
        f = new Form("home");
        ttitre = new TextField();
        ttitre.setHint("Titre");
                        //username.setSingleLineTextArea(true);
        ttitre.setSingleLineTextArea(true);
        ttitre.getAllStyles().setFgColor(CYAN);

        tdescription = new TextField();
        tdescription.setHint("Description");
        tdescription.getAllStyles().setFgColor(CYAN);
        tprix = new TextField();
        tprix.setHint("Prix");
        tprix.getAllStyles().setFgColor(CYAN);

        tlieu = new TextField();
        tlieu.setHint("Lieu");
        tlieu.getAllStyles().setFgColor(CYAN);
                image = new TextField();
                
                 imgBtn = new Button("Inserer Image");
        imgBtn.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        path = (String) ev.getSource();
                        System.out.println(path.substring(7));
                        Image img = null;
                        image.setText(path.substring(7));//image heya just label nsob feha fel path
                        try {
                            img = Image.createImage(FileSystemStorage.getInstance().openInputStream(path));
                            System.out.println(img);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }, Display.GALLERY_IMAGE);
        });

        tnbreticket = new TextField();
        tnbreticket.setHint("Nombre Tickets");
        tnbreticket.getAllStyles().setFgColor(CYAN);
        
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        f.add(ttitre);
        f.add(tdescription);
        f.add(tprix);
        f.add(imgBtn);
        f.add(tlieu);
        f.add(tnbreticket);
        
        
        f.add(btnajout);
        f.add(btnaff);
        btnajout.addActionListener((e) -> {
            FileUploader fc = new FileUploader("localhost/madame/web/");
            try {
                String f = fc.upload(image.getText());
                System.out.println(f);
//                ServiceEvent ser = new ServiceEvent();
              //Integer idu=  authuser.user.getId();
//            Event t = new Event(  /*authuser.user.getId() ,*/ ttitre.getText(),
//                    tlieu.getText() ,
//                    Double.valueOf(tprix.getText()), 
//                   // Double.parseDouble(tprix.getText()),
//                    tdescription.getText(), f,      
//                    Integer.parseInt(tnbreticket.getText()));
            //Event t = new Event( ttitre.getText(), tdescription.getText(), Double.parseDouble(tprix.getText()), tlieu.getText() ,Integer.parseInt(tnbreticket.getText()));

//            ser.ajoutEvent(t);
            
            } catch (Exception ex) {
                
            }
            
            
            

        }); 
        
        btnaff.addActionListener((e)->{
       // Affichage a=new Affichage().Affichage(res).show();
        //a.getF().show();
        });
    f.show();
          return f;
    }


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return ttitre;
    }

    public void setTnom(TextField ttitre) {
        this.ttitre = ttitre;
    }

}
