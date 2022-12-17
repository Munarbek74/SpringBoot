package com.peaksoft.api;

import com.peaksoft.models.Company;
import com.peaksoft.models.Course;
import com.peaksoft.models.Lesson;
import com.peaksoft.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.service = companyService;
    }


    @GetMapping("/getAllCompanies")
    public String listCompanies(Model model) {
        return "/company/all_companies";
    }

    @GetMapping("/company")
    public String Companies(Model model) {
        List<Company> companyList = service.getAll();
        model.addAttribute("company", companyList);
        return "/company/companies";
    }
    @GetMapping("/addCompany")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
       return "/company/addCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(Company company) {
        service.saveCompany(company);
        return "redirect:/company";
    }


    @GetMapping("/companies/edit/{id}")
    public String updateCompany(@PathVariable("id") Long id, Model model) {
        Company company = service.findByIdCompany(id);
        model.addAttribute("company", company);
        return "/company/addCompany";
    }

    @GetMapping("/companies/delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        service.deleteByIdCompany(id);
        return "redirect:/company";
    }


}
