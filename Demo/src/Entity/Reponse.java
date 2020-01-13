/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author bhk
 */
public class Reponse {
   private int id_rep;
    private int id_quest;
   private String descriptionReponse;
    private String username;
      private String dateReponse ;
       private String	titreQuestion;
       private String descriptionQuestion;
      private String dateQuestion;
         private int user_id;
    public Reponse() {
    }

    public Reponse(int id_quest, String descriptionReponse, String dateReponse) {
        this.id_quest = id_quest;
        this.descriptionReponse = descriptionReponse;
        this.dateReponse = dateReponse;
    }

    public Reponse(int id_rep, int id_quest, String descriptionReponse, String username, String dateReponse, String titreQuestion, String descriptionQuestion, String dateQuestion, int user_id) {
        this.id_rep = id_rep;
        this.id_quest = id_quest;
        this.descriptionReponse = descriptionReponse;
        this.username = username;
        this.dateReponse = dateReponse;
        this.titreQuestion = titreQuestion;
        this.descriptionQuestion = descriptionQuestion;
        this.dateQuestion = dateQuestion;
        this.user_id = user_id;
    }

    public Reponse(String titreQuestion, String descriptionQuestion, String dateQuestion) {
        this.titreQuestion = titreQuestion;
        this.descriptionQuestion = descriptionQuestion;
        this.dateQuestion = dateQuestion;
    }

    public Reponse(String descriptionReponse, String dateReponse) {
        this.descriptionReponse = descriptionReponse;
        this.dateReponse = dateReponse;
    }

    public Reponse(int id_rep, int id_quest, String descriptionReponse, String dateReponse) {
        this.id_rep = id_rep;
        this.id_quest = id_quest;
        this.descriptionReponse = descriptionReponse;
        this.dateReponse = dateReponse;
    }
    

    public int getId_rep() {
        return id_rep;
    }

    public void setId_rep(int id_rep) {
        this.id_rep = id_rep;
    }

    public int getId_quest() {
        return id_quest;
    }

    public void setId_quest(int id_quest) {
        this.id_quest = id_quest;
    }

    public String getDescriptionReponse() {
        return descriptionReponse;
    }

    public void setDescriptionReponse(String descriptionReponse) {
        this.descriptionReponse = descriptionReponse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(String dateReponse) {
        this.dateReponse = dateReponse;
    }

    public String getTitreQuestion() {
        return titreQuestion;
    }

    public void setTitreQuestion(String titreQuestion) {
        this.titreQuestion = titreQuestion;
    }

    public String getDescriptionQuestion() {
        return descriptionQuestion;
    }

    public void setDescriptionQuestion(String descriptionQuestion) {
        this.descriptionQuestion = descriptionQuestion;
    }

    public String getDateQuestion() {
        return dateQuestion;
    }

    public void setDateQuestion(String dateQuestion) {
        this.dateQuestion = dateQuestion;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id_rep=" + id_rep + ", id_quest=" + id_quest + ", descriptionReponse=" + descriptionReponse + ", username=" + username + ", dateReponse=" + dateReponse + ", titreQuestion=" + titreQuestion + ", descriptionQuestion=" + descriptionQuestion + ", dateQuestion=" + dateQuestion + ", user_id=" + user_id + '}';
    }

   

 

    
}
