package com.codingrecipe.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // http://localhost:8080/list
    @GetMapping("/list")
    public List<EmployeeDTO> findAll() {
        return employeeService.findAll();
    }

    // http://localhost:8080/list/3
    @GetMapping("/list/{id}")
    public EmployeeDTO findById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    // http://localhost:8080/save
    // { "name": "kim","salary": 200 }
    @PostMapping("/save")
    public void save(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    // http://localhost:8080/update
    // { "id": 1, "name": "lee", "salary": 300 }
    @PostMapping("/update")
    public void update(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.update(employeeDTO);
    }

    // http://localhost:8080/delete
    // { "id": 2 }
    @PostMapping("/delete")
    public void delete(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.delete(employeeDTO.getId());
    }
}
