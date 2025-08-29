package dev.fer.Api.employees;

import java.util.List;
import org.springframework.stereotype.Service;

import jakarta.persistence.NoResultException;

@Service
public class EmployeesService {

    private final EmployeesRepository repository;

    public EmployeesService(EmployeesRepository repository) {
        this.repository = repository;
    }

    public List<EmployeesEntity> getEmployees() {
        return repository.findAll(); // devuelve todas las entidades directamente
    }

    public EmployeesEntity findById(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new NoResultException("Empleado no existe"));
    }
}

