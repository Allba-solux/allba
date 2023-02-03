package freshman.allbaback.controller;

import freshman.allbaback.domain.Company;
import freshman.allbaback.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/company")
@RequiredArgsConstructor
@RestController
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping(value = "/new")
    public String createNewCompany(@RequestBody Company company) {
        System.out.println("createNewCompany");
        companyService.registerCompany(company);
        return "company";
    }

    @DeleteMapping("/{companyCode}/delete")
    public void delete(@PathVariable String companyCode) {
        companyService.delete(companyCode);
    }

    @GetMapping("")
    public List<Company> finding() {
        return companyService.findCompanies();
    }

    @GetMapping("/{companyName}/find")
    public List<Company> findingOne(@PathVariable String companyName) {
        return companyService.findOne(companyName);
    }

    @PutMapping("/{companyName}/{pid}/join")
    public void joinCompany(@PathVariable String companyName, @PathVariable String pid) {

    }

}
