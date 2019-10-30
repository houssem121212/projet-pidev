/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Controller.AcceuilreservationController;
import Entite.Evennement;
import Entite.Reservation;
import Service.ReservationService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AffichresController implements Initializable {

    @FXML
    private JFXTextField a;
    @FXML
    private TableView<Reservation> table;
    
    @FXML
    private Pane pane2;
    @FXML
    private TableColumn<Reservation, String> ds;
     @FXML
    private TableColumn<Reservation,LocalDate> dd;

    @FXML
    private TableColumn<Reservation,LocalDate> df;

    
    @FXML
    private TableColumn<Reservation, String> mail;
     @FXML
    private TableColumn<Reservation, Integer> num;
      @FXML
    private TableColumn<Reservation, String> tt;
         @FXML
    private JFXTextField log;
         @FXML
  private JFXButton aa;
                @FXML
  private JFXButton suppR;
                    @FXML
    private JFXButton idpdf;
     

   


     
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
         
         public void LOG(String text)
    {
        log.setText(text);
    }

        
        
       
    

    @FXML
    private void affr(ActionEvent event) throws SQLException{
         String login =log.getText();
           System.out.println(login);
            ReservationService rs = new ReservationService();
           ArrayList<Reservation> arrayList = null;
           arrayList = (ArrayList<Reservation>) rs.readAll(login);
        
  ObservableList obs = FXCollections.observableArrayList(arrayList);
             table.setItems(obs);
              tt.setCellValueFactory(new PropertyValueFactory<Reservation,String>("Titre_Event"));
             ds.setCellValueFactory(new PropertyValueFactory<Reservation,String>("Descr_Event"));
           dd.setCellValueFactory(new PropertyValueFactory<Reservation,LocalDate>("DATED_EVENT"));   
         df.setCellValueFactory(new PropertyValueFactory<Reservation,LocalDate>("DATEF_EVENT"));   
        
           mail.setCellValueFactory(new PropertyValueFactory<Reservation,String>("E_mailU"));
         num.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("NumTel"));
                
    
}
    
     @FXML
    private void deleteRow(ActionEvent event) {
        //tt.getCellData(0);
         //System.out.println( tt.getCellData(0));
          //System.out.println( tt.getCellData(1));
          //table.getSelectionModel().getSelectedCells().get(0);
          
           
          //table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
          Reservation R =new Reservation();
          R=table.getSelectionModel().getSelectedItem();
          ReservationService RS = new ReservationService();
          RS.supprimerReserv(R.getId_Res());
          System.out.println(R.getId_Res());
          table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
          
          
          
       
    }
    
          
          
          
       
    
    
    
     @FXML
    void CONVERTIONPDF(ActionEvent event) {
   System.out.println("To Printer!");
   PrinterJob job=PrinterJob.createPrinterJob();
     if(job!=null){
         Window PrimaryStage = null;
       Window primary = null;
       
         job.showPrintDialog(PrimaryStage);
         Node root=this.table;
         job.printPage(root);
         job.endJob();
         
         job.endJob();
     }
    }
    
    
    
  /*  @FXML
    private void modres(ActionEvent event) throws IOException {

                              
                        try {      Stage stage = (Stage) an.getScene().getWindow();
                System.err.println("bbb2");
            Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("fxml/modifier.fxml"));
      
            //System.err.println(info);
          
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
   // }
                    } catch (IOException ex) {
				Logger.getLogger(AcceuilForumController.class.getName()).log(Level.SEVERE, null, ex);
			}
    
  
   
    
    }*/
}

  


