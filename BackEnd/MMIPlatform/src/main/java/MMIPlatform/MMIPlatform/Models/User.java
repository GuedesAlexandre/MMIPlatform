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
    private int User_id;

    @Column(name = "Nom", updatable = true, nullable = false)
    private String Nom;

    @Column(name = "Prenom", updatable = true, nullable = false)
    private String Prenom;
    @Column(name = "Email", updatable = true, nullable = false)
    private String Email;

    @Column(name = "Password", updatable = true, nullable = false)
    private String Password;

    @Column(name = "Promo", updatable = true, nullable = false)
    private String Promo;

    @ManyToMany
    @JoinTable(
            name = "Etu_IUT",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "IUT_id"))
    private List<IUT> IUTs;


}
