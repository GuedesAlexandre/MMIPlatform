package MMIPlatform.MMIPlatform.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import MMIPlatform.MMIPlatform.Repositories.TicketRepository;
import jakarta.transaction.Transactional;
import MMIPlatform.MMIPlatform.Models.Ticket;
import MMIPlatform.MMIPlatform.Models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {



    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserServices userServices;

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Transactional
    public List<Object> GetAllTicketsWithUsers(){
        List<Ticket> ticketList = ticketRepository.findAll();
        List<Object> ticketWithUsers = new ArrayList<>().reversed();

        ticketList.forEach(ticket -> {
            List<User> users = ticket.GetUser();
            ticketWithUsers.add(Pair.of(ticket, users));
        });

        return ticketWithUsers;
    }

    public Ticket findById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("ID cannot be null");
        }
        return ticketRepository.findById(id).orElse(null);
    }
}