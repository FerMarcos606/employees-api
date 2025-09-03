package dev.fer.Api.employees;

import java.util.List;
import dev.fer.Api.exceptions.EmployeesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fer.Api.employees.dtos.EmployeesDTOReponse;
import dev.fer.Api.employees.dtos.EmployeesDTORequest;
import dev.fer.Api.employees.mappers.EmployeesMapper;
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

      @Autowired
        private EmployeesRepository employeeRepository;

        public EmployeesDTOReponse createEmployee(EmployeesDTOReponse requestDto) {
            // 1. Mapear DTO de solicitud a la entidad
            EmployeesEntity employee = mapToEntity(requestDto);

            // 2. Guardar el empleado en la base de datos
            EmployeesEntity savedEmployee = employeeRepository.save(employee);

            // 3. Mapear la entidad guardada al DTO de respuesta
            return mapToDTOResponse(savedEmployee);
        }

        // Convierte DTORequest a entidad
        private EmployeesEntity mapToEntity(EmployeesDTOReponse requestDto) {
            EmployeesEntity employee = new EmployeesEntity();
            employee.setName(requestDto.name()); 
            return employee;
        }

        // Convierte entidad a DTOResponse
        private EmployeesDTOReponse mapToDTOResponse(EmployeesEntity savedEmployee) {
            return new EmployeesDTOReponse (savedEmployee.getId(), savedEmployee.getName());
        }

                
        public EmployeesDTOReponse updateEmployee(Long id, EmployeesDTORequest requestDto) {

            EmployeesEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeesNotFoundException(
                    "No existe un empleado con esa ID " + id
                ));

            // actualizar sólo el nombre
            employee.setName(requestDto.name());

            EmployeesEntity updatedEmployee = employeeRepository.save(employee);

            return EmployeesMapper.toDTO(updatedEmployee);
        }

      
           public void deleteEmployee(Long id) {
            EmployeesEntity employee = repository.findById(id)
                .orElseThrow(() -> new EmployeesNotFoundException("Empleado con id " + id + " ha sido eliminado."));

            repository.delete(employee);
        }

            public EmployeesEntity findByName(String name) {
            return repository.findByName(name)
                            .orElseThrow(() -> new NoResultException("No hay empleados/as con ese nombre"));
        }

    }
            
        
            
    
    
    
   







