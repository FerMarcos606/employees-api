package dev.fer.Api.tickets.dtos;
import java.time.LocalDateTime;


public record TicketsDTORequest(

    String employeesName,
    String subject,
    LocalDateTime ticketLocalDateTime,
    String description,
    String technicianNameEmployee,
    boolean pendingRequest,
    LocalDateTime dateRequestFullfilled,
    LocalDateTime editionRequest
) {}


