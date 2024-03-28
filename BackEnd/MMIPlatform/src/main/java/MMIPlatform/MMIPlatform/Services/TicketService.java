package MMIPlatform.MMIPlatform.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MMIPlatform.MMIPlatform.Repositories.TicketRepository;
import MMIPlatform.MMIPlatform.Models.Ticket;


@Service
public class TicketService {
    @Autowired
        private TicketRepository ticketRepository;

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

  
    public Ticket findById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("ID cannot be null");
        }
        return ticketRepository.findById(id).orElse(null);
    }


}
