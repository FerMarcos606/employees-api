package dev.fer.Api.tickets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; // Importa PostMapping
import org.springframework.web.bind.annotation.RequestBody; // Importa RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "${api-endpoint}/tickets")

public class TicketsController {

    private final TicketsService service;

    public TicketsController(TicketsService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<TicketsEntity> getAllTickets() {
        return service.getTickets(); 

    }

    @GetMapping("/{id}")
    public TicketsEntity getTicket(@PathVariable Long id) {
        return service.getTicketById(id);
    }


    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED) 
    public TicketsEntity createTicket(@RequestBody TicketsEntity ticket) {
        return service.createTicket(ticket);
    }

   
}
