/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entite;

/**
 *
 * @author Houssem
 */
public class Evennement {
    private int Id_Event;
    private String Descr_Event;
    private String Image_Event;
    private String Titre_Event;
    private String Date_Event;
    private String Localisation;

    public Evennement(String Descr_Event, String Image_Event, String Titre_Event, String Date_Event, String Localisation) {
        this.Descr_Event = Descr_Event;
        this.Image_Event = Image_Event;
        this.Titre_Event = Titre_Event;
        this.Date_Event = Date_Event;
        this.Localisation = Localisation;
    }

    public Evennement(int Id_Event, String Descr_Event, String Image_Event, String Titre_Event, String Date_Event, String Localisation) {
        this.Id_Event = Id_Event;
        this.Descr_Event = Descr_Event;
        this.Image_Event = Image_Event;
        this.Titre_Event = Titre_Event;
        this.Date_Event = Date_Event;
        this.Localisation = Localisation;
    }

    public int getId_Event() {
        return Id_Event;
    }

    public void setId_Event(int Id_Event) {
        this.Id_Event = Id_Event;
    }

    public String getDescr_Event() {
        return Descr_Event;
    }

    public void setDescr_Event(String Descr_Event) {
        this.Descr_Event = Descr_Event;
    }

    public String getImage_Event() {
        return Image_Event;
    }

    public void setImage_Event(String Image_Event) {
        this.Image_Event = Image_Event;
    }

    public String getTitre_Event() {
        return Titre_Event;
    }

    public void setTitre_Event(String Titre_Event) {
        this.Titre_Event = Titre_Event;
    }

    public String getDate_Event() {
        return Date_Event;
    }

    public void setDate_Event(String Date_Event) {
        this.Date_Event = Date_Event;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(String Localisation) {
        this.Localisation = Localisation;
    }

    @Override
    public String toString() {
        return "Evennement{" + "Id_Event=" + Id_Event + ", Descr_Event=" + Descr_Event + ", Image_Event=" + Image_Event + ", Titre_Event=" + Titre_Event + ", Date_Event=" + Date_Event + ", Localisation=" + Localisation + '}';
    }
   
    
    
}
