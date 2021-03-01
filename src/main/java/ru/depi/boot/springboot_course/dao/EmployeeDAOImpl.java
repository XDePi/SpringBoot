package ru.depi.boot.springboot_course.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.depi.boot.springboot_course.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author DePi
 **/

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> getAllEmp() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public void saveEmp(Employee employee) {
        Employee employee1 = entityManager.merge(employee);
        employee.setId(employee1.getId());

    }

    @Override
    public Employee getEmp(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmp(int id) {
        Query query = entityManager.createQuery("delete from Employee " +
                "where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    @Override
    public List<Employee> findAllByName(String name) {
        Query query = entityManager.createQuery("from Employee " +
                "where name=:employeeName");
        query.setParameter("employeeName", name);
        List<Employee> list = query.getResultList();
        return list;
    }
}
