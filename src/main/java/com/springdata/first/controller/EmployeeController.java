package com.springdata.first.controller;

import com.springdata.first.model.entity.Employee;
import com.springdata.first.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmpService empService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
       empService.addEmployee(employee);
       return "sucess add employee";
    }

    @GetMapping("/get")
    public List<Employee> getEmployee(){
       return empService.getEmployee();
    }

    @GetMapping("/getById")
    public Employee getEployeeById(@RequestParam Integer id){
        return empService.getEployeeById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateData(@PathVariable Integer id,@RequestBody Employee employee){
        empService.updateEmployee(id,employee);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Integer id){
        empService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
