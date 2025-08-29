package dev.fer.Api.employees;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.persistence.NoResultException;

import static org.hamcrest.MatcherAssert.assertThat;


@ExtendWith(MockitoExtension.class)
public class EmployeesServiceTest {
    
     @Mock
    private EmployeesRepository repository;
    
     @InjectMocks
    private EmployeesService service;

    
    @Test
    void testGetEmployees_ShouldReturnAllEmployees() {
        List<EmployeesEntity> employeesMock = List.of(
            new EmployeesEntity(1L, "RaulS"),
            new EmployeesEntity(2L, "AngelesT")
            
        );

        when(repository.findAll()).thenReturn(employeesMock);

        List<EmployeesEntity> employees = service.getEmployees();

        assertThat(employees.size(), equalTo(2));
        assertThat(employees.get(0).getName(), equalTo("RaulS"));
        assertThat(employees.get(1).getName(), equalTo("AngelesT"));
    }

     @Test
    void testFindById_ShouldThrowExceptionWhenEmployeeNotFound() {
        // excepción cuando se llama con ID 0
        when(repository.findById(0L)).thenThrow(new NoResultException("Empleado/a no existe"));

        
        Throwable exception = assertThrows(NoResultException.class, () -> 
            service.findById(0L));

        // Verifica que el mensaje de la excepción es correcto
        assertThat(exception.getMessage(), equalTo("Empleado/a no existe"));
    }

}
