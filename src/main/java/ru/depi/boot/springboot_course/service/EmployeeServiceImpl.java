package ru.depi.boot.springboot_course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.depi.boot.springboot_course.dao.EmployeeDAO;
import ru.depi.boot.springboot_course.entity.Employee;

import java.util.List;

/**
 * @author DePi
 **/

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;


    @Override
    @Transactional
    public List<Employee> getAllEmp() {
        return employeeDAO.getAllEmp();
    }

    @Override
    @Transactional
    public void saveEmp(Employee employee) {
        employeeDAO.saveEmp(employee);
    }

    @Override
    @Transactional
    public Employee getEmp(int id) {
        return employeeDAO.getEmp(id);
    }

    @Override
    @Transactional
    public void deleteEmp(int id) {
        employeeDAO.deleteEmp(id);
    }

    @Override
    @Transactional
    public List<Employee> findAllByName(String name) {
         return employeeDAO.findAllByName(name);
    }


}
