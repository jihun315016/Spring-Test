    package com.codingrecipe.board;


import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final SqlSessionTemplate sql;

    public List<EmployeeDTO> findAll() {
        return sql.selectList("Employee.findAll");
    }

    public EmployeeDTO findById(Long id) {
        return sql.selectOne("Employee.findById", id);
    }

    public void save(EmployeeDTO employeeDTO) {
        sql.insert("Employee.save", employeeDTO);
    }

    public void update(EmployeeDTO employeeDTO) {
        sql.update("Employee.update", employeeDTO);
    }

    public void delete(Long id) {
        sql.delete("Employee.delete", id);
    }
}
