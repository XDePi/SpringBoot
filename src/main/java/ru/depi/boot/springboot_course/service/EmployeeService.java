package ru.depi.boot.springboot_course.service;

import ru.depi.boot.springboot_course.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmp();

    public void saveEmp(Employee employee);

    public Employee getEmp(int id);

    public void deleteEmp(int id);

    public List<Employee> findAllByName(String name);
}
