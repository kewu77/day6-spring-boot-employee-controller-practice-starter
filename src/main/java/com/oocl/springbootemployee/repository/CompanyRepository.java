package com.oocl.springbootemployee.repository;

import com.oocl.springbootemployee.Entity.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {
    private List<Company> companies;

    public CompanyRepository() {
        companies = new ArrayList<>();
        companies.add(new Company(1,"Company1"));
        companies.add(new Company(2,"Company2"));
        companies.add(new Company(3,"Company3"));
    }

    public List<Company> getAll(){
        return companies;
    }
}
