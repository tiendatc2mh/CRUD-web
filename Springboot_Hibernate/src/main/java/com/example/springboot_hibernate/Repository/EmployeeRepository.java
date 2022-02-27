package com.example.springboot_hibernate.Repository;

import com.example.springboot_hibernate.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
