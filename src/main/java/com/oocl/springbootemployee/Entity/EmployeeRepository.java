package com.oocl.springbootemployee.Entity;

import com.oocl.springbootemployee.commmon.Gender;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository() {
        employees = new ArrayList<>();
        employees.add(new Employee(1,"tom",21, Gender.Male,new BigDecimal(3000)));
        employees.add(new Employee(2,"jack",27, Gender.Female,new BigDecimal(7000)));
        employees.add(new Employee(3,"kevin",23, Gender.Male,new BigDecimal(13000)));
    }

    public List<Employee> getAll(){
        return employees;
    }

    public Employee getById(Integer id){
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> getByGender(Gender gender) {
        return employees.stream()
                .filter(employee -> employee.getGender() == gender)
                .collect(Collectors.toList());
    }

    public Employee save(Employee employee) {
        employee.setId(employees.size() + 1);
        employees.add(employee);
        return employee;
    }
}
