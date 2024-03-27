package MMIPlatform.MMIPlatform.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("Promo_id")
    private Integer Promo_id;

    @Column(name = "Nom", updatable = true, nullable = false)
    private String Nom;

    @Column(name="Quantité", updatable = true, nullable = false)
    private String Quantite;

    @Column(name="Specialité", updatable = true, nullable = false)
    private String Specialite;
    public Promo() {
    }
    

    public int getPromo_id() {
        return Promo_id;
    }

    public void setPromo_id(int promo_id) {
        Promo_id = promo_id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getQuantite() {
        return Quantite;
    }

    public void setQuantite(String quantite) {
        Quantite = quantite;
    }

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String specialite) {
        Specialite = specialite;
    }
}
