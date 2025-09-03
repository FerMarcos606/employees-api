package dev.fer.Api.employees.mappers;

import org.springframework.stereotype.Component;

import dev.fer.Api.employees.EmployeesEntity;
import dev.fer.Api.employees.dtos.EmployeesDTOReponse;
import dev.fer.Api.employees.dtos.EmployeesDTORequest;

@Component
public class EmployeesMapper {
    
    public static EmployeesEntity toEntity(EmployeesDTORequest dtoRequest) {
        EmployeesEntity employees = new EmployeesEntity();
        employees.setName(dtoRequest.name());

        return employees;
    }

    public static EmployeesDTOReponse toDTO(EmployeesEntity entity) {
        EmployeesDTOReponse dtoResponse = new EmployeesDTOReponse();
        return dtoResponse;
        
    }
}
