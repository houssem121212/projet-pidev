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
public class Question {
   private int id;
   private String titre_question;
   private String description_question;
    private String username_question;
      private String date_question ;
      	
         private int user_id;
    public Question() {
    }


    public Question(String titre_question, String description_question, String username_question, String date_question, int user_id) {
        this.titre_question = titre_question;
        this.description_question = description_question;
        this.username_question = username_question;
        this.date_question = date_question;
        this.user_id = user_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre_question() {
        return titre_question;
    }

    public void setTitre_question(String titre_question) {
        this.titre_question = titre_question;
    }

    public String getDescription_question() {
        return description_question;
    }

    public void setDescription_question(String description_question) {
        this.description_question = description_question;
    }

    public String getDate_question() {
        return date_question;
    }

    public void setDate_question(String date_question) {
        this.date_question = date_question;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername_question() {
        return username_question;
    }

    public void setUsername_question(String username_question) {
        this.username_question = username_question;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", titre_question=" + titre_question + ", description_question=" + description_question + ", username_question=" + username_question + ", date_question=" + date_question + ", user_id=" + user_id + '}';
    }
    

 

    
}
