/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.User;
import Service.UserService;
import com.jfoenix.controls.JFXTextField;
import fxml.AuthentificationController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AcceuilTechController implements Initializable {
    
    @FXML
    private AnchorPane bp;
    @FXML
    private HBox id_evta;
    @FXML
    private Label evnta;
    @FXML
    private HBox resa;
    @FXML
    private Label reserva;
    @FXML
    private HBox arta;
    @FXML
    private HBox forma;
    @FXML
    private Pane content;
    @FXML
    private HBox id_comta;
    @FXML
    private Label evnta1;
    @FXML
    private HBox id_recla;
    @FXML
    private Label evnta11;
     @FXML
    private JFXTextField a;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
     @FXML
    public void MyLogin(String text)
    {  a.setText(text);
       
    }
    
    
    @FXML
    private void btn_afficherTouse(MouseEvent event) {
        int id=AuthentificationController.test;
          User p = new User();
         UserService us =new UserService();
        
         String test= us.rechercherparrole(id);
         if (event.getTarget() == id_evta) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/afficherE.fxml"));
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilTechController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
         
         if ((event.getTarget() == id_comta)&&(test.equals("admin"))) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/GstionCompteAdmin.fxml"));
                                System.err.println("hhhhhhhhh");
				content.getChildren(
                                ).clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilTechController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
          if ((event.getTarget() == id_comta)&&((test.equals("MembreActif"))||(test.equals("Membre")))) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/GestionCompteMembre.fxml"));
                                System.err.println("hhhhhhhhh");
				content.getChildren(
                                ).clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilTechController.class.getName()).log(Level.SEVERE, null, ex);
			}
          }
           if ((event.getTarget() == id_recla)&&(test.equals("admin"))) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/ReclamationAdmin.fxml"));
                                System.err.println("hhhhhhhhh");
				content.getChildren(
                                ).clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilTechController.class.getName()).log(Level.SEVERE, null, ex);
			}
          
         }
         if ((event.getTarget() == id_recla)&&((test.equals("MembreActif"))||(test.equals("Membre")))) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/ReclamationUser.fxml"));
                                System.err.println("hhhhhhhhh");
				content.getChildren(
                                ).clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilTechController.class.getName()).log(Level.SEVERE, null, ex);
			}
        
    }
         
         if ((event.getTarget() == arta)) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/AcceuilArticle.fxml"));
                                System.err.println("hhhhhhhhh");
				content.getChildren(
                                ).clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilTechController.class.getName()).log(Level.SEVERE, null, ex);
			}
        
    }
    
          if ((event.getTarget() == forma)) {
			try {
                                
				Parent root = FXMLLoader.load(getClass().getResource("/fxml/AcceuilForum.fxml"));
                                System.err.println("hhhhhhhhh");
				Stage stage = (Stage) bp.getScene().getWindow();
                                System.err.println("*****");
            
      
                                System.err.println("go to inscription");
          
                                    Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
			} catch (IOException ex) {
				Logger.getLogger(AcceuilTechController.class.getName()).log(Level.SEVERE, null, ex);
			}
        
    }
       
          if (event.getTarget() == resa) {
			try {
				//AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/Acceuilreservation.fxml"));
                               FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Acceuilreservation.fxml"));
                              
                                 AnchorPane newLoadedPane =loader.load();
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
                                AcceuilreservationController accR=loader.getController();
                            
                                
                              
                                accR.FinalLogin(a.getText());
			} catch (IOException ex) {
				Logger.getLogger(AcceuilTechController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
         
    }}
