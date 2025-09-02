package dev.fer.Api.tickets;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TicketsService {

    private final TicketsRepository repository;

    public TicketsService(TicketsRepository repository) {
        this.repository = repository;
    }

    public List<TicketsEntity> getTickets() {
        return repository.findAll(); 
    }
    public TicketsEntity saveTickets(TicketsEntity ticket) {
    return repository.save(ticket); // repository ya sabe guardar
    }
    // Nuevo método para crear un ticket
    public TicketsEntity createTicket(TicketsEntity ticket) {
        return repository.save(ticket);
    }
    public TicketsEntity getTicketById(Long id) {
    return repository.findById(id).orElse(null);
}

}
