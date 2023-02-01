package allba.alllbaback.service;

import allba.alllbaback.domain.Company;
import allba.alllbaback.repository.CompanyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@Component
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    // 지점 새로 등록
    public void registerCompany(Company company) {
        System.out.println("register");
        companyRepository.insert(company);
        System.out.println("A");
        companyRepository.save(company);
        System.out.println("B");
    }

    // 모든 지점 조회
    public List<Company> findCompanies() {
        return companyRepository.findAll();
    }

    // 지점 검색(이름으로)
    public Optional<Company> findOne(String companyName) {
        return companyRepository.findById(companyName);
    }

    // 지점 삭제
    public  void delete(String companyCode){
        companyRepository.deleteById(companyCode);
    }

    // 지점 참가 요청

    // 대타 요청

    //
    public String a(String companyName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (companyRepository.findByCompanyName(companyName) == null) {
                return String.format("user name : %s not exist!!", companyName);
            } else {
                return objectMapper.writeValueAsString(companyRepository.findByCompanyName(companyName));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
