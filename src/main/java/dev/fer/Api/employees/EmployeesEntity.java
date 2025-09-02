package dev.fer.Api.employees;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;



    @Entity
    @Table(name = "employees")
    public class EmployeesEntity {
        
        @Id 
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        public EmployeesEntity(){

        }

        public EmployeesEntity(Long id, String name){
            this.id =id;
            this.name = name;
        }

        public Long getId(){
            return id;
        }    

        public void setId(Long id){
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

    }
