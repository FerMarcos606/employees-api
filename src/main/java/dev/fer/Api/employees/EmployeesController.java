package dev.fer.Api.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.fer.Api.employees.dtos.EmployeesDTOReponse;
import dev.fer.Api.employees.dtos.EmployeesDTORequest;


@RestController
@RequestMapping(path = "${api-endpoint}/employees")
public class EmployeesController {

    private final EmployeesService service;

    public EmployeesController(EmployeesService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<EmployeesEntity> index() {
         return service.getEmployees(); 
    }
    
        @GetMapping("{id}")
    public EmployeesEntity getById(@PathVariable("id") Long id) {
        return service.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }


    @PostMapping("")
    public EmployeesDTOReponse create(@RequestBody EmployeesDTOReponse requestDto) {
        // Llama al método create del service
        return service.createEmployee(requestDto);
    } 

    @PutMapping("{id}")
    public EmployeesDTOReponse updateEmployee(
            @PathVariable("id") Long employeeId,
            @RequestBody EmployeesDTORequest updatedEmployeeRequest) {

        EmployeesDTOReponse employeesDTOResponse = service.updateEmployee(employeeId, updatedEmployeeRequest);

        return employeesDTOResponse;
    }

    @Autowired
    private EmployeesService employeesService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {

        employeesService.deleteEmployee(id);

        return ResponseEntity.ok("El empleado fue eliminado con éxito");
    
    }

    @GetMapping("/name/{name}")
        
    public EmployeesEntity getByName(@PathVariable("name") String name) {
       return service.findByName(name);
       
    }

    }


 
    


