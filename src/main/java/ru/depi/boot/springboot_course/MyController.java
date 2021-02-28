package ru.depi.boot.springboot_course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.depi.boot.springboot_course.entity.Employee;
import ru.depi.boot.springboot_course.service.EmployeeService;

import java.util.List;

/**
 * @author DePi
 **/

@RestController
public class MyController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmp() {
        List<Employee> employees = employeeService.getAllEmp();
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmp(@PathVariable int id) {
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmp(@RequestBody Employee employee) {
        employeeService.saveEmp(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmp(@RequestBody Employee employee) {
        employeeService.saveEmp(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmp(@PathVariable int id) {
        employeeService.deleteEmp(id);
        return "Employee with id=" + id + " was deleted from db";
    }
}
