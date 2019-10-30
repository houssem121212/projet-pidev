/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Entite.Reservation;
import Service.ReservationService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjoutRéservationController implements Initializable {

    @FXML
    private AnchorPane id_page_ajout_res;
    @FXML
    private JFXTextField f_titre_ev;
    @FXML
    private JFXTextField f_login;
    @FXML
    private JFXButton btnres;
    @FXML 
    private Label resultat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void Ajoutres(ActionEvent event) {
         Reservation  R = new Reservation();
        R.setTitre_Event((f_titre_ev.getText()));
        R.setLogin((f_login.getText()));
        R.setEtat("en-attente");
        ReservationService sr = new ReservationService();
         try {
            sr.ajouterReservation(R);
           //resultat.setText( sr.ajouterReservation(R));
        } catch (SQLException ex) {
            Logger.getLogger(AjoutRéservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
