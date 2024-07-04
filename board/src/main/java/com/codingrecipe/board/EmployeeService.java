package com.codingrecipe.board;

//import com.employee.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeDTO findById(Long id) {
        return employeeRepository.findById(id);
    }

    public void save(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeDTO);
    }

    public void update(EmployeeDTO employeeDTO) {
        employeeRepository.update(employeeDTO);
    }

    public void delete(Long id) {
        employeeRepository.delete(id);
    }
}
