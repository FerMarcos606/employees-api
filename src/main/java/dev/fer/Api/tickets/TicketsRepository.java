package dev.fer.Api.tickets;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<TicketsEntity, Long> {
}
