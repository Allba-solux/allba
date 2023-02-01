package allba.alllbaback.controller;

import allba.alllbaback.domain.Company;
import allba.alllbaback.repository.CompanyRepository;
import allba.alllbaback.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/company")
@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/new")
    public String createNewCompany(@RequestParam String companyName) {
        System.out.println("createNewCompany");
        Company company = new Company();
        company.setCompanyName(companyName);
        companyService.registerCompany(company);
        return companyService.a(companyName);
    }

//    @DeleteMapping("/company/{companyCode}")
//    public void delete(@PathVariable String companyCode) {
//        companyService.delete(companyCode);
//    }
//
//    @GetMapping("/company")
//    public List<Company> finding() {
//        return companyService.findCompanies();
//    }
//
//    @GetMapping("/company")
//    public Optional<Company> findingOne(String companyName) {
//        return companyService.findOne(companyName);
//    }
//
//    @GetMapping("/company")
//    public Optional<Company> d(String companyName) {
//        return companyService.findOne(companyName);
//    }

}
