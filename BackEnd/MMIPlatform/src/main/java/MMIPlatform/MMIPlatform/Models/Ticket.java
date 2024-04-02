package MMIPlatform.MMIPlatform.Models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonProperty("ticket_id")
        private long ticket_id;
    
    @Column(name = "Nom", nullable = false, updatable = true)
        @JsonProperty("Nom")
        public String nom;

    @Column(name = "Langages", nullable = true, updatable = true)
        @JsonProperty("Langages")
        public String langage;
    
    @Column(name = "Desciptions", nullable = false, updatable=true)
        @JsonProperty("Desciptions")
        public String description;

    @Column(name = "Matière", nullable = false, updatable=true)
        @JsonProperty("Matière")
        public String matiere;
    
    @Column(name = "img", nullable = true, updatable = true)
        @JsonProperty("img")
        public String img;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "etu_ticket",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> Users;
    
    

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

    public List<User> GetUser(){
        return Users;
    }
}
