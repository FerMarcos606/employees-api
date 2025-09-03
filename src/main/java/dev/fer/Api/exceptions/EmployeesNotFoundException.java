package dev.fer.Api.exceptions;


public class EmployeesNotFoundException extends RuntimeException {
    public EmployeesNotFoundException (String message) {
        super(message);
    }
}

