package com.oocl.springbootemployee.controller;

import com.oocl.springbootemployee.Entity.Company;
import com.oocl.springbootemployee.repository.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    public CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/all")
    public List<Company> getAll(){
        return companyRepository.getAll();
    }
}
