package penjat;

public class User implements java.io.Serializable {
    String nom;
    String pass;

    
    public User(String nom, String pass) {
        this.nom = nom;
        this.pass = pass;

    }
}
