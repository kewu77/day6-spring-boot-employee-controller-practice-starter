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
    }

    public List<Employee> getAll(){
        return employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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

    public Employee update(Employee employee) {
        Employee originEmployee = employees.stream()
                .filter(thisEmployee -> thisEmployee.getId().equals(employee.getId()))
                .findFirst().orElseThrow();
        originEmployee.setAge(employee.getAge());
        originEmployee.setSalary(employee.getSalary());
        return originEmployee;
    }

    public Employee delete(Integer id) {
        Employee originEmployee = employees.stream()
                .filter(thisEmployee -> thisEmployee.getId().equals(id))
                .findFirst().orElseThrow();
        employees.remove(originEmployee);
        return originEmployee;
    }
}
