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
public class reclamationadmin {
    
    private int IdRecAdmin;
    private int IdRecMembre;
    private String NameCat;
    private String TitreRecMembre;
    private Date DateRecAmin;
    private String ContenuRecAdmin;
    private String ReponseRecMembre;

    public reclamationadmin() {
    }

    public int getIdRecAdmin() {
        return IdRecAdmin;
    }

    public void setIdRecAdmin(int IdRecAdmin) {
        this.IdRecAdmin = IdRecAdmin;
    }

    public int getIdRecMembre() {
        return IdRecMembre;
    }

    public void setIdRecMembre(int IdRecMembre) {
        this.IdRecMembre = IdRecMembre;
    }

    public String getNameCat() {
        return NameCat;
    }

    public void setNameCat(String NameCat) {
        this.NameCat = NameCat;
    }

    public String getTitreRecMembre() {
        return TitreRecMembre;
    }

    public void setTitreRecMembre(String TitreRecMembre) {
        this.TitreRecMembre = TitreRecMembre;
    }

    public Date getDateRecAmin() {
        return DateRecAmin;
    }

    public void setDateRecAmin(Date DateRecAmin) {
        this.DateRecAmin = DateRecAmin;
    }

    public String getContenuRecAdmin() {
        return ContenuRecAdmin;
    }

    public void setContenuRecAdmin(String ContenuRecAdmin) {
        this.ContenuRecAdmin = ContenuRecAdmin;
    }

    public String getReponseRecMembre() {
        return ReponseRecMembre;
    }

    public void setReponseRecMembre(String ReponseRecMembre) {
        this.ReponseRecMembre = ReponseRecMembre;
    }

    
    
}
