package dev.fer.Api.tickets;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicketsEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeesName;
    private String subject;
    private LocalDateTime ticketLocalDateTime;
    private String description;
    private String technicianNameEmployee;
    private boolean pendingRequest;
    private LocalDateTime dateRequestFullfilled;
    private LocalDateTime editionRequest;


    public TicketsEntity(){
        
    }

    public TicketsEntity(Long id, String employeesName, String subject, LocalDateTime ticketLocalDateTime, String description, String technicianNameEmployee, boolean pendingRequest, LocalDateTime dateRequestFullfilled, LocalDateTime editionRequest){
        this.id = id;
        this.employeesName = employeesName;
        this.subject= subject;
        this.ticketLocalDateTime = ticketLocalDateTime;
        this.description = description; 
        this.technicianNameEmployee = technicianNameEmployee;
        this.pendingRequest = pendingRequest; 
        this.dateRequestFullfilled = dateRequestFullfilled;
        this.editionRequest = editionRequest; 
    }

    // Getters y Setters corregidos
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public String getEmployeesName(){
        return employeesName;
    }

    public void setEmployeesName(String employeesName){
        this.employeesName = employeesName;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject; 
    }

    public LocalDateTime getTicketLocalDateTime(){
        return ticketLocalDateTime;
    }

    public void setTicketLocalDateTime(LocalDateTime ticketLocalDateTime){
        this.ticketLocalDateTime = ticketLocalDateTime;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription( String description){
        this.description = description;
    }

    public String getTechnicianNameEmployee(){
        return technicianNameEmployee;
    }

    public void setTechnicianNameEmployee(String technicianNameEmployee){
        this.technicianNameEmployee = technicianNameEmployee;
    }
    
    // getter de booleano corregido a 'is'
    public boolean isPendingRequest(){
        return pendingRequest;
    }
    
    public void setPendingRequest(boolean pendingRequest){
        this.pendingRequest = pendingRequest;
    }

    public LocalDateTime getDateRequestFullfilled(){
        return dateRequestFullfilled;
    }

    public void setDateRequestFullfilled(LocalDateTime dateRequestFullfilled){
        this.dateRequestFullfilled = dateRequestFullfilled;
    }

    // getter y setter de editionRequest corregidos
    public LocalDateTime getEditionRequest(){
        return editionRequest;
    }

    public void setEditionRequest(LocalDateTime editionRequest){
        this.editionRequest = editionRequest;
    }
}