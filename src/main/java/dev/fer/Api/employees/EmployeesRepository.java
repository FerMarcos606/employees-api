package dev.fer.Api.employees;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Long> { Optional<EmployeesEntity> findByName(String name);}

