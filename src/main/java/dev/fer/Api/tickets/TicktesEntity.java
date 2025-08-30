package dev.fer.Api.tickets;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicktesEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeesName;
    private String theme;
    private LocalDateTime ticketLocalDateTime;
    private String description;
    private String nameTecnichEmployee;
    private boolean pendingRequest;
    private LocalDateTime dateRequestFullfilled; // solicitud atendida
    private LocalDateTime editionLocalDateTime; // solicitud editada


    public TicktesEntity(){

        
}
}