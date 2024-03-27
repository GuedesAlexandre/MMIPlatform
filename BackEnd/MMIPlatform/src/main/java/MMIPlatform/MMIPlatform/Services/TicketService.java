package MMIPlatform.MMIPlatform.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MMIPlatform.MMIPlatform.Repositories.TicketRepository;


@Service
public class TicketService {
    @Autowired
        private TicketRepository ticketRepository;


}
