package allba.alllbaback.repository;

import allba.alllbaback.domain.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {
    public List<Company> findByCompanyName(String companyName);
}
