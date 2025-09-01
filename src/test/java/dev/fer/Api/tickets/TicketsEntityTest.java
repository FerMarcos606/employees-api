package dev.fer.Api.tickets;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TicketsEntityTest {

    @Test
    void testTicketsEntityConstructor() {
        TicketsEntity ticket = new TicketsEntity();
        assertNotNull(ticket);
        assertNull(ticket.getId());
        assertNull(ticket.getEmployeesName());
    }

    @Test
    void testSettersAndGetters() {
        // 1. Instanciamos la entidad
        TicketsEntity ticket = new TicketsEntity();

        // 2. Definimos valores de prueba
        Long id = 1L;
        String name = "JuanP";
        String description = "Problema con el software.";
        LocalDateTime creationDate = LocalDateTime.now();
        boolean isPending = true;

       
        ticket.setId(id);
        ticket.setEmployeesName(name);
        ticket.setDescription(description);
        ticket.setTicketLocalDateTime(creationDate); 
        ticket.setPendingRequest(isPending); 

        
        assertEquals(id, ticket.getId());
        assertEquals(name, ticket.getEmployeesName());
        assertEquals(description, ticket.getDescription());
        assertEquals(creationDate, ticket.getTicketLocalDateTime()); 
        assertEquals(isPending, ticket.isPendingRequest()); 
    }
}