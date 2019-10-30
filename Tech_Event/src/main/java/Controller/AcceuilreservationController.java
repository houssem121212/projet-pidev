/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import Controller.AffichresController;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import Controller.ModifierController;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AcceuilreservationController implements Initializable {

    @FXML
    private Pane content;
    @FXML
    private Pane pane1;
    @FXML
    private HBox id_affich_res;
    @FXML
    private HBox id_ajout_res;
    @FXML
    private HBox id_mod_res;
    @FXML
    private JFXTextField b;

    /**
     * Initializes the controller class.
     *
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void FinalLogin(String text) {
        b.setText(text);
    }

    @FXML
    private void affichres(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Affichres.fxml"));

        AnchorPane newLoadedPane = loader.load();
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);
        AffichresController aff = loader.getController();
        aff.LOG(b.getText());

    }
    
    @FXML
    private void update(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/modifier.fxml"));

        AnchorPane newLoadedPane = loader.load();
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);
        ModifierController mm=loader.getController();
        mm.LOG2(b.getText());

    }


    @FXML
    void btn_afficher_res(MouseEvent event) throws IOException {
        if (event.getTarget() == id_ajout_res) {

            try {
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/AjoutRéservation.fxml"));
                content.getChildren().clear();
                content.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilreservationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //}
        /* if (event.getTarget() == id_mod_res) {
	 FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/modifier.fxml"));
                              
                        try {       AnchorPane newLoadedPane =loader.load();
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
                                ModifierController modd=loader.getController();
                                modd.LOG2(b.getText());
         
   // }
                    } catch (IOException ex) {
				Logger.getLogger(AcceuilForumController.class.getName()).log(Level.SEVERE, null, ex);
			}
       
   // }
                
                
               }*/
    }
}

/* @FXML 
    private void affichres(ActionEvent event) throws IOException {
      FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Affichres.fxml"));
                              
                               AnchorPane newLoadedPane =loader.load();
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
                                AffichresController aff=loader.getController();
                                aff.LOG(b.getText());
        
    }*/
