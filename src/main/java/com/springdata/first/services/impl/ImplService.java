package com.springdata.first.services.impl;

import com.springdata.first.model.entity.Employee;
import com.springdata.first.repository.EmpRepo;
import com.springdata.first.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ImplService implements EmpService {

    @Autowired
    private EmpRepo empRepo;
    @Override
    public void addEmployee(Employee employee) {
        empRepo.save(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEployeeById(Integer id) {
        return empRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid This ID"+id));
    }

    @Override
    public void updateEmployee(Integer id, Employee employee) {
        empRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid This ID"+id));
        employee.setId(id);
        empRepo.save(employee);

    }

    @Override
    public void deleteEmployee(Integer id) {
       Employee employee= empRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid This ID"+id));

empRepo.delete(employee);
    }
}
