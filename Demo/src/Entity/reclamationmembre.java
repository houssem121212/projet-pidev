/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author aymen
 */
public class reclamationmembre {
    
    private int IdRecMembre;
    private String TitreRecMembre;
    private Date DateRecMembre;
    private String ContenuRecMembre;
    private String EtatRecMembre;
    private String NameCat;
    private int id;

    public reclamationmembre() {
    }

    public reclamationmembre(String TitreRecMembre, String ContenuRecMembre, String NameCat) {
        this.TitreRecMembre = TitreRecMembre;
        this.ContenuRecMembre = ContenuRecMembre;
        this.NameCat = NameCat;
    }
    
    

    public int getIdRecMembre() {
        return IdRecMembre;
    }

    public void setIdRecMembre(int IdRecMembre) {
        this.IdRecMembre = IdRecMembre;
    }

    public String getTitreRecMembre() {
        return TitreRecMembre;
    }

    public void setTitreRecMembre(String TitreRecMembre) {
        this.TitreRecMembre = TitreRecMembre;
    }

   

    public Date getDateRecMembre() {
        return DateRecMembre;
    }

    public void setDateRecMembre(Date DateRecMembre) {
        this.DateRecMembre = DateRecMembre;
    }

    public String getContenuRecMembre() {
        return ContenuRecMembre;
    }

    public void setContenuRecMembre(String ContenuRecMembre) {
        this.ContenuRecMembre = ContenuRecMembre;
    }

    public String getEtatRecMembre() {
        return EtatRecMembre;
    }

    public void setEtatRecMembre(String EtatRecMembre) {
        this.EtatRecMembre = EtatRecMembre;
    }

    public String getNameCat() {
        return NameCat;
    }

    public void setNameCat(String NameCat) {
        this.NameCat = NameCat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

   
}
