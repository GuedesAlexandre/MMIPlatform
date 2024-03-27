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
    
    @ManyToMany
        @JoinTable(
            name = "Etu_Ticket",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
        private User user;
}
