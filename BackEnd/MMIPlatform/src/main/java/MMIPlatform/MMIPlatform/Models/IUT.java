package MMIPlatform.MMIPlatform.Models;

import jakarta.persistence.*;

@Entity
public class IUT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IUT_id;

    @Column(name = "Nom", updatable = true, nullable = false)
    private String Nom;

    public IUT() {

    }
    public Integer getIUT_id() {
        return IUT_id;
    }

    public void setIUT_id(Integer IUT_id) {
        this.IUT_id = IUT_id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void forEach(Object o) {
    }
}


