package freshman.allbaback.service;

import freshman.allbaback.domain.Company;
import freshman.allbaback.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    // 지점 새로 등록
    public void registerCompany(Company company) {
        System.out.println("register");
        companyRepository.insert(company);
    }

    // 모든 지점 조회
    public List<Company> findCompanies() {
        return companyRepository.findAll();
    }

    // 지점 검색(이름으로)
    public List<Company> findOne(String companyName) {
        return companyRepository.findByCompanyName(companyName);
    }

    // 지점 삭제
    public int delete(String companyCode){
        companyRepository.deleteById(companyCode);
        return 1;
    }

    // 지점 참가 요청

    // 대타 요청


}
