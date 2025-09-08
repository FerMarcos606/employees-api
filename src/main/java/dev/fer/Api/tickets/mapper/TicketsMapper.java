package dev.fer.Api.tickets.mapper;

import org.springframework.stereotype.Component;

import dev.fer.Api.tickets.TicketsEntity;
import dev.fer.Api.tickets.dtos.TicketsDTORequest;
import dev.fer.Api.tickets.dtos.TicketsDTOResponse;

@Component
public class TicketsMapper {

    public static TicketsEntity toEntity(TicketsDTORequest dtoRequest) {
        TicketsEntity ticket = new TicketsEntity();
        ticket.setEmployeesName(dtoRequest.employeesName());
        ticket.setSubject(dtoRequest.subject());
        ticket.setTicketLocalDateTime(dtoRequest.ticketLocalDateTime());
        ticket.setDescription(dtoRequest.description());
        ticket.setTechnicianNameEmployee(dtoRequest.technicianNameEmployee());
        ticket.setPendingRequest(dtoRequest.pendingRequest());
        ticket.setDateRequestFullfilled(dtoRequest.dateRequestFullfilled());
        ticket.setEditionRequest(dtoRequest.editionRequest());

        return ticket;
    }

    public static TicketsDTOResponse toDTO(TicketsEntity entity) {
        if (entity == null) return null;

        return new TicketsDTOResponse(
            entity.getId(),
            entity.getEmployeesName(),
            entity.getSubject(),
            entity.getTicketLocalDateTime(),
            entity.getDescription(),
            entity.getTechnicianNameEmployee(),
            entity.isPendingRequest(),
            entity.getDateRequestFullfilled(),
            entity.getEditionRequest()
        );
    }
}

