package MMIPlatform.MMIPlatform.Controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import MMIPlatform.MMIPlatform.Models.Ticket;
import MMIPlatform.MMIPlatform.Services.TicketService;

import java.util.List;


@RestController
public class TicketController {
    @Autowired
        private TicketService TicketService;


    @GetMapping("/tickets")
        public List<Object> GetAllTickets(){
            return TicketService.GetAllTicketsWithUsers();
        }

}
