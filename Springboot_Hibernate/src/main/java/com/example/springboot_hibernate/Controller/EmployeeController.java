package com.example.springboot_hibernate.Controller;

import com.example.springboot_hibernate.Model.Employee;
import com.example.springboot_hibernate.Repository.EmployeeRepository;
import com.example.springboot_hibernate.SpringbootHibernateApplication;
import com.example.springboot_hibernate.exception.ResourceNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    private static Logger logger = Logger.getLogger(SpringbootHibernateApplication.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    //getAll employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        logger.info("info log: getAllEmployee...");
        return employeeRepository.findAll();
    }

    //create new employee
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        logger.info("Post new employee"+employee.getId());
        return employeeRepository.save(employee);
    }
    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        //return employeeService.getEmployeesByName(key);
        logger.info("info log: Find employees by id:" + id);
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                                    new ResourceNotFoundException("Không tìm đc employee có id là:" + id));
        return ResponseEntity.ok(employee);
    }

    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
        logger.info("info log: Update employees by id:" + id);
        Employee oldEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Không tìm đc employee có id là: " + id));
        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
        oldEmployee.setEmail(employee.getEmail());
        Employee newEmployee = employeeRepository.save(oldEmployee);
        return ResponseEntity.ok(newEmployee);
    }
    //delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm đc employee có id là : " + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        logger.info("info log: Delete employees id:" + id);
        return ResponseEntity.ok(response);
    }
}
