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
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import service.authuser;

/**
 * Base class for the forms with common functionality
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {

  
    public BaseForm() {
    }

    public BaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public BaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    protected void addSideMenu(Resources res) {
        Toolbar tb = getToolbar();
        Image img = res.getImage("tech.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        tb.addComponentToSideMenu(LayeredLayout.encloseIn(
                sl,
                FlowLayout.encloseCenterBottom(
                        new Label(res.getImage("tech.jpg"), "PictureWhiteBackgrond"))
        ));

        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_SETTINGS, e -> System.err.println("Profile"));
        tb.addMaterialCommandToSideMenu("Evennements", FontImage.MATERIAL_UPDATE, e ->new Homes(res).show());
     //   tb.addMaterialCommandToSideMenu("Panier", FontImage.MATERIAL_SHOPPING_BASKET, e -> new PanierForm().getF().show());
        tb.addMaterialCommandToSideMenu("Formations", FontImage.MATERIAL_EXIT_TO_APP, e -> System.err.println("Formation"));
        tb.addMaterialCommandToSideMenu("Articles", FontImage.MATERIAL_DETAILS, e -> new HomeArticle(res).show());
        tb.addMaterialCommandToSideMenu("Forum", FontImage.MATERIAL_CHAT_BUBBLE_OUTLINE, e -> System.err.println("Forum"));
        tb.addMaterialCommandToSideMenu("Reclamations", FontImage.MATERIAL_DETAILS, e -> System.err.println("Reclamation"));
//        tb.addMaterialCommandToSideMenu("Evenement", FontImage.MATERIAL_DETAILS, e -> new Affichage(res).show());
      //  tb.addMaterialCommandToSideMenu("Ajout Evenement", FontImage.MATERIAL_DETAILS, e -> new HomeForm().HomeForm(res).show());
//        tb.addMaterialCommandToSideMenu("Enseigne ", FontImage.MATERIAL_DETAILS, e -> new AffichageE(res).getF().show());

//      tb.addMaterialCommandToSideMenu("Souk", FontImage.MATERIAL_DETAILS, e -> {
//            {
//                MapsDemo maCarte = new MapsDemo();
//                maCarte.start();
//
//            }
//        });
//
     tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_EXIT_TO_APP, e -> new SignInForm(res).show());

    }
}
