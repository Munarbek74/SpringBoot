package com.peaksoft.service;

import com.peaksoft.models.Company;
import com.peaksoft.models.Student;
import com.peaksoft.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public List<Company> getAll() {
       return companyRepository.findAll();

    }

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteByIdCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company findByIdCompany(Long id) {
        return companyRepository.findById(id).get();
    }


}
