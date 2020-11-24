package com.project.employeeperformence.controller;

import com.project.employeeperformence.model.Admin;
import com.project.employeeperformence.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.employeeperformence.repository.AdminRepository;
import com.project.employeeperformence.service.EmployeeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AdminRepository adminRepository;

    @PostMapping(value="/save")
    public ResponseEntity saveEmployeeDetails(@RequestBody Employee employee){
        return this.employeeService.saveEmployees(employee);
    }

    @GetMapping(value="/view")
    public ResponseEntity<List<Employee>> getDetails(){
      return this.employeeService.getAllEmployees();
    }

    @GetMapping(value="/find")
    public ResponseEntity findAdmin(@RequestParam(value="user", required=true) String userName,
                                    @RequestParam(value="password", required=false) String password){
        Admin admin = this.adminRepository.findByUserNameAndPassword(userName,password);
        if(admin!=null){
            return new ResponseEntity<>("Admin is exists", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Admin is not exists", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
