package MMIPlatform.MMIPlatform.Models;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Table(name="Etudiant")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long User_id;

    @Column(name = "Nom", updatable = true, nullable = false)
    private String Nom;

    @Column(name = "Prenom", updatable = true, nullable = false)
    private String Prenom;
    @Column(name = "Email", updatable = true, nullable = false)
    private String Email;

    @Column(name = "Password", updatable = true, nullable = false)
    private String Password;



    @ManyToOne
    @JoinTable(
            name = "Etu_IUT",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "IUT_id"))
    private IUT iut;

    @ManyToOne
    @JoinTable(
            name = "Etu_Promo",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "Promo_id"))
    private Promo promo;




    public User() {

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

    public List<Promo> getPromo() {
        return List.of(promo);
    }

    public List<IUT> getIut() {
        return List.of(iut);
    }

    public void setIut(IUT iut) {
        this.iut = iut;
    }
}
