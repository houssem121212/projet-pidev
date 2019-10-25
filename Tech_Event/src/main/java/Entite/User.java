package Entite;

/**
 *
 * @author Hudson
 */
public class User {

     private int Id_User;
    private String Login;
    private String Mdp;
    private String E_mailU;
    private String NomU;
    private String PrenomU;
    private int NumTel;
    private String PhotoProfil;
    private String RoleU;

    public User(int Id_User, String Login, String Mdp) {
        this.Id_User = Id_User;
        this.Login = Login;
        this.Mdp = Mdp;
    }

    
    
    
    
    public int getId_User() {
        return Id_User;
    }

    public String getLogin() {
        return Login;
    }

    public String getMdp() {
        return Mdp;
    }

    public String getE_mailU() {
        return E_mailU;
    }

    public String getNomU() {
        return NomU;
    }

    public String getPrenomU() {
        return PrenomU;
    }

    public int getNumTel() {
        return NumTel;
    }

    public String getPhotoProfil() {
        return PhotoProfil;
    }

    public String getRoleU() {
        return RoleU;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setMdp(String Mdp) {
        this.Mdp = Mdp;
    }

    public void setE_mailU(String E_mailU) {
        this.E_mailU = E_mailU;
    }

    public void setNomU(String NomU) {
        this.NomU = NomU;
    }

    public void setPrenomU(String PrenomU) {
        this.PrenomU = PrenomU;
    }

    public void setNumTel(int NumTel) {
        this.NumTel = NumTel;
    }

    public void setPhotoProfil(String PhotoProfil) {
        this.PhotoProfil = PhotoProfil;
    }

    public void setRoleU(String RoleU) {
        this.RoleU = RoleU;
    }

    @Override
    public String toString() {
        return "User{" + "Id_User=" + Id_User + ", Login=" + Login + ", Mdp=" + Mdp + ", E_mailU=" + E_mailU + ", NomU=" + NomU + ", PrenomU=" + PrenomU + ", NumTel=" + NumTel + ", PhotoProfil=" + PhotoProfil + ", RoleU=" + RoleU + '}';
    }


   

}
