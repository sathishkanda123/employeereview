package com.project.employeeperformence.service;

import com.project.employeeperformence.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.employeeperformence.repository.EmployeeRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = this.employeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.ACCEPTED);
    }

    public ResponseEntity saveEmployees(Employee employee){
        try{

            this.employeeRepository.save(employee);

        }catch(DataIntegrityViolationException exception){

            return new ResponseEntity<>("Employee Already Exits", HttpStatus.ALREADY_REPORTED);
        }catch (Exception e){
            return new ResponseEntity<>("Exception ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
