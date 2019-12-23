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

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
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
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import static com.codename1.uikit.cleanmodern.SignUpForm.adresee;
import static com.codename1.uikit.cleanmodern.SignUpForm.confirmPassword;
import static com.codename1.uikit.cleanmodern.SignUpForm.email;
import static com.codename1.uikit.cleanmodern.SignUpForm.numtel;
import static com.codename1.uikit.cleanmodern.SignUpForm.password;
import static com.codename1.uikit.cleanmodern.SignUpForm.username;
import service.ProfilClient;
import service.authuser;

/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ProfileForm extends BaseForm {
       public static TextField username,password,nom,prenom,email;
    ProfilClient pf = new ProfilClient();

    public ProfileForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            facebook,
                            FlowLayout.encloseCenter(
                                new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond")),
                            twitter
                    )
                )
        ));

       username = new TextField(authuser.user.getNom());
        username.setUIID("TextFieldBlack");
        addStringValue("Username", username);

        password = new TextField(authuser.user.getPassword(), "Password", 20, TextField.PASSWORD);
        password.setUIID("TextFieldBlack");
        addStringValue("Password", password);

        nom = new TextField(authuser.user.getNom(),"Nom",20,TextField.ANY);
        nom.setUIID("TextFieldBlack");
        addStringValue("Nom", nom);
        
        prenom = new TextField(authuser.user.getPrenom(),"Prenom",20,TextField.ANY);
        prenom.setUIID("TextFieldBlack");
        addStringValue("Prenom", prenom);
        
        email = new TextField(authuser.user.getEmail(), "E-Mail", 20, TextField.EMAILADDR);
        email.setUIID("TextFieldBlack");
        addStringValue("E-Mail", email);
        
        
        
        
        
          Validator val = new Validator();
        
                val.addConstraint(username, new LengthConstraint(4));
                String testusername="^\\(?([a-z]{3})\\)?";
               val.addConstraint(username, new RegexConstraint(testusername, ""));
               
                val.addConstraint(password, new LengthConstraint(4));
               
            
              
                 val.addConstraint(nom, new LengthConstraint(4));
                String testnom="^\\(?([a-z]{3})\\)?";
               val.addConstraint(nom, new RegexConstraint(testnom, ""));
            
                  val.addConstraint(prenom, new LengthConstraint(4));
               
               val.addConstraint(prenom, new RegexConstraint(testnom, ""));
       
                        
        val.addConstraint(email, RegexConstraint.validEmail());

        
        
        
        
        
        Button edit = new Button("Modifier");
        addStringValue("", edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                pf.Modifier();
            }
        });
    }
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
}
