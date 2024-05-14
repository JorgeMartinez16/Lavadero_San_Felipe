package com.jota.sanfelipe.controllers;

import com.jota.sanfelipe.entities.Employee;
import com.jota.sanfelipe.entities.EmployeeCommissions;
import com.jota.sanfelipe.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.registerEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/commission/{id}/{date}")
    public ResponseEntity<EmployeeCommissions> getEmployeeCommission(@PathVariable("id") Long employee_id, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)Date date){
        EmployeeCommissions employeeCommissions  = employeeService.getEmployeeCommissions(employee_id, date);
        return new ResponseEntity<>(employeeCommissions, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("the employee has been delete succefusslly");
    }
}
