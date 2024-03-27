package MMIPlatform.MMIPlatform.Models;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long ticket_id;
    
    @Column(name = "Nom", nullable = false, updatable = true)
        public String nom;

    @Column(name = "Langages", nullable = true, updatable = true)
        public String langage;
    
    @Column(name = "Desciptions", nullable = false, updatable=true)
        public String description;

    @Column(name = "Matière", nullable = false, updatable=true)
        public String matiere;
    
    @Column(name = "img", nullable = true, updatable = true)
        public String img;
    


    public Ticket(){}

    public long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
