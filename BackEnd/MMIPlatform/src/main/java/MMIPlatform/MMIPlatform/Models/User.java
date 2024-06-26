package MMIPlatform.MMIPlatform.Models;
import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import MMIPlatform.MMIPlatform.Models.IUT;
import MMIPlatform.MMIPlatform.Models.Promo;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("user_id")
    private Long User_id;

    @JsonProperty("nom")
    private String Nom;

    @JsonProperty("prenom")
    private String Prenom;

    @JsonProperty("email")
    private String Email;

    @JsonProperty("password")
    private String Password;

    @JsonProperty("role")
    private String Role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Etu_IUT",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "IUT_id"))
    private IUT iut;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Etu_Promo",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "Promo_id"))
    private Promo promo;


    public User() {

    }
    public String getRole() {
        return Role;
    }





    public Long getUser_id() {
        return User_id;
    }

    public void setUser_id(Long user_id) {
        User_id = user_id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Promo getPromo() {
        return promo;
    }

    public IUT getIut() {
        return iut;
    }
    public void setPromo(Promo promo) {
        this.promo = promo;
    }
    public void setIut(IUT iut) {
        this.iut = iut;
    }

    public void setRole(String role) {
        this.Role = role;
    }
}









