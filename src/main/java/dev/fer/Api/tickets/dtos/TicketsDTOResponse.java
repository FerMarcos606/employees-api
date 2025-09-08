package dev.fer.Api.tickets.dtos;

import java.time.LocalDateTime;

public record TicketsDTOResponse (
    Long id,
    String employeesName,
    String subject,
    LocalDateTime ticketLocalDateTime,
    String description,
    String technicianNameEmployee,
    Boolean pendingRequest,
    LocalDateTime dateRequestFullfilled,
    LocalDateTime editionRequest
) {}

