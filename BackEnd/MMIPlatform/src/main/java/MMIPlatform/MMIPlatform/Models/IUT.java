package MMIPlatform.MMIPlatform.Models;

import jakarta.persistence.*;

@Entity
public class IUT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IUT_id;

    @Column(name = "Nom", updatable = true, nullable = false)
    private String Nom;

}
