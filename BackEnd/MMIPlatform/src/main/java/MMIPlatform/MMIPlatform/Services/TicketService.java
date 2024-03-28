package MMIPlatform.MMIPlatform.Services;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MMIPlatform.MMIPlatform.Repositories.TicketRepository;
import jakarta.transaction.Transactional;
import MMIPlatform.MMIPlatform.Models.Ticket;
import MMIPlatform.MMIPlatform.Models.User;

import java.util.List;

@Service
public class TicketService {

    private static final Log LOG = LogFactory.getLog(TicketService.class);
    @Autowired
        private TicketRepository ticketRepository;
        private UserServices UserServices;

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

  @Transactional
    public List<Ticket> GetAllTickets(){
    List<Ticket> TicketListe = ticketRepository.findAll();
    TicketListe.forEach(Tickets -> {
        Tickets.getNom();
        Tickets.getDescription();
        Tickets.getMatiere();
        Tickets.getImg();
        Tickets.getLangage();
        Tickets.getTicket_id();
      
    });

    return TicketListe;
}
    public Ticket findById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("ID cannot be null");
        }
        return ticketRepository.findById(id).orElse(null);
    }


}
