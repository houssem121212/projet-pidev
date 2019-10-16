/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Entite.Evennement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Houssem
 */
public class EvennementService {

   Connection c = DataSource.getInstance().getConnection();
    Statement ste;
  
    
      public EvennementService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
  
      public void creerEvennement(Evennement u) throws SQLException{
      
            String req1="INSERT INTO `evenement` (`Descr_Event`, `Image_Event`, `Titre_Event`, `Date_Event`, `Localisation`) VALUES ('"+u.getDescr_Event()+"', '"+u.getImage_Event()+"', '"+u.getTitre_Event()+"', '"+u.getDate_Event()+"', '"+u.getLocalisation()+"');";
            ste.executeUpdate(req1);
            System.out.println("elment inste");
     
    }
    
     public List<Evennement> readAll() throws SQLException
    {List<Evennement> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from evenement");
    Evennement per=null;
    while (res.next()) {            
      per=new Evennement(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
      list.add(per);
        }
    return list;
    } 
     
      public void supprimerEvennement(Evennement p) {
            
        
        try { 
            String req="DELETE FROM `evenement` WHERE `evenement`.`Id_Event` = ?";
            PreparedStatement ps = c.prepareStatement(req);
            ps.setInt(1, p.getId_Event());
            ps.executeUpdate();
            System.out.println("element supprimer");
         
        } catch (SQLException ex) {
            Logger.getLogger(EvennementService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
      public void modifierEvennement(Evennement p) {
        
         
        
   String sql="UPDATE evenement SET `Descr_Event`=?,`Image_Event`=?,`Titre_Event`=?,`Date_Event`=?,`Localisation`=? WHERE Id_Event="+p.getId_Event();
   PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, p.getDescr_Event());
            ps.setString(2, p.getImage_Event());
            
            ps.setString(3, p.getTitre_Event());
            ps.setString(4, p.getDate_Event());
            
            ps.setString(5, p.getLocalisation());
            
                
            ps.executeUpdate();
            int rowsUpdated=ps.executeUpdate();
            if (rowsUpdated>0){
            System.out.println("La modification d'evenement "+p.getId_Event()+" a été éffectué avec succée ");
            }}
        catch (SQLException ex) {
            Logger.getLogger(EvennementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      
      public boolean rechercherparNom(String nom) {
        boolean test=false;
        String req = "SELECT * from evenement where Titre_Event='"+nom+"'";
            
     
        try {
           
            ResultSet stp=ste.executeQuery(req);
            stp.last();
            if(stp.getRow()!=0)
            {
                test=true;
                System.out.println(test+"evenement trouver");
            }
            else
            {
                test=false;
                System.out.println(test+"evenement non trouver");
            }
        }
            catch (SQLException ex) {
            Logger.getLogger(EvennementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
        
    }
     
      
      
}
