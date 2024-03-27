package MMIPlatform.MMIPlatform.Models;


import jakarta.persistence.*;

@Entity
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Promo_id;

    @Column(name = "Nom", updatable = true, nullable = false)
    private String Nom;

    @Column(name="Quantité", updatable = true, nullable = false)
    private String Quantite;

    @Column(name="Specialité", updatable = true, nullable = false)
    private String Specialite;









    public Promo() {
    }


}
