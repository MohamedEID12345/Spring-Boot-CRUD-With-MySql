package com.springdata.first.services;

import com.springdata.first.model.entity.Employee;

import java.util.List;

public interface EmpService {
    void addEmployee(Employee employee);

    List<Employee> getEmployee();

    Employee getEployeeById(Integer id);

    void updateEmployee(Integer id, Employee employee);

    void deleteEmployee(Integer id);
}
