
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

/**
 *
 * @author Marwen
 */
public class User {
    int id;
    String nom;
    String prenom;
    String classe;
    String email;
    String password;
    String numTel;
    String image;
    String lien_fb;
    String lien_linkedin;
    String role;
    String code;
    
    public User(int id,String nom,String prenom) {
        this.id = id;
        
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(int id, String nom, String email, String password, String numTel, String image, String lien_fb) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.image = image;
        this.lien_fb = lien_fb;
    }
    
    
    

    public User(int id, String nom, String prenom, String classe, String email, String password, String numTel, String image, String lien_fb) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.image = image;
        this.lien_fb = lien_fb;
    }

    
    
    
    public User(int id, String nom, String email, String numTel, String image, String lien_fb) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.numTel = numTel;
        this.image = image;
        this.lien_fb = lien_fb;
    }

    public User(int id, String nom, String prenom, String classe, String email, String password, String numTel, String image, String lien_fb, String lien_linkedin, String role, String code) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
        this.role = role;
        this.code = code;
    }

    public User(String nom, String prenom, String classe, String email, String password, String numTel, String image, String lien_fb,String role, String code) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.role = role;
        this.code = code;
    }
   

    public User(String nom, String email, String mdp, String tel, String image, String lien_fb, String role, String code,int x) {
        this.nom = nom;
        this.email = email;
        this.password=mdp;
        this.numTel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.role = role;
        this.code = code;
    }

    public User(int id, String nom, String prenom, String classe, String email, String password, String numTel, String image, String lien_fb, String lien_linkedin, String role, int x) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe=classe;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
        this.role = role;
        
    }

   public User(String nom, String prenom, String classe, String email, String password, String numTel, String image, String lien_fb,String code,String role,int x) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.code = code;
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String get;

    public User() {
    }

  /*  public User(int id, String nom, String prenom, String classe, String email, String numTel, String lien_fb) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.numTel = numTel;
        this.lien_fb = lien_fb;
    }*/

    public User(String nom, String prenom, String email,String classe, String password,String tel, String lien_fb) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email=email;
        this.password = password;
        this.numTel = tel;
        this.lien_fb = lien_fb;
    }

    public User(int id, String nom, String email, String pwd, String tel, String image, String lien_fb, String role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = pwd;
        this.numTel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.role = role;
    }

   /*public User(String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.password = pwd;
        this.numTel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
    }
*/
    public User(String nom, String prenom, String classe, String email, String pwd, String tel,String image, String lien_fb, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.password = pwd;
        this.numTel = tel;
        this.image=image;
        this.lien_fb = lien_fb;
        this.role = role;
    }
   
    
    

   /* public User(String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb, String lien_linkedin, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.password = pwd;
        this.numTel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
        this.role = role;
    }    */

   /* public User(String nom, String email, String pwd, String tel, String lien_fb, String role, String code) {
        this.nom = nom;
        this.email = email;
        this.password = pwd;
        this.numTel = tel;
        this.lien_fb = lien_fb;
        this.role = role;
        this.code = code;
    */
  /*  public User(String nom, String email, String pwd, String tel, String image, String lien_fb, String role) {
        this.nom = nom;
        this.email = email;
        this.password = pwd;
        this.numTel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.role = role;
    }*/
/*
    public User(int id, String nom, String prenom, String classe, String email, String tel, String lien_fb, String lien_linkedin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.numTel = tel;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
    }
*/
    public User(String nom, String email, String pwd, String tel, String image, String lien_fb) {
        this.nom = nom;
        this.email = email;
        this.password = pwd;
        this.numTel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
    }

    public User(String nom, String prenom, String classe, String email, String numTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.numTel = numTel;
    }

    public User(int id, String nom, String prenom, String classe, String email, String pwd, String tel, String image, String lien_fb, String lien_linkedin, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.email = email;
        this.password= pwd;
        this.numTel = tel;
        this.image = image;
        this.lien_fb = lien_fb;
        this.lien_linkedin = lien_linkedin;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", classe=" + classe + ", email=" + email + ", password=" + password + ", numTel=" + numTel + ", image=" + image + ", lien_fb=" + lien_fb + ", lien_linkedin=" + lien_linkedin + ", role=" + role + ", code=" + code + ", get=" + get + '}';
    }

  

    public User(int id, String nom, String email, String tel, String lien_fb) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.numTel = tel;
        this.lien_fb = lien_fb;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLien_fb() {
        return lien_fb;
    }

    public void setLien_fb(String lien_fb) {
        this.lien_fb = lien_fb;
    }

    public String getLien_linkedin() {
        return lien_linkedin;
    }

    public void setLien_linkedin(String linkedin) {
        this.lien_linkedin = linkedin;
    }

   /* public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    */

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getRole() {
        return "1";
    }

    public void setRole(String role) {
        this.role = role;
    }

 
    
           
    
    
}
