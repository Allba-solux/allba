package freshman.allbaback.repository;

import freshman.allbaback.domain.MyCompany;
import freshman.allbaback.domain.members.Members;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface MyCompanyRepository extends MongoRepository<MyCompany,String> {
    MyCompany save(MyCompany myCompany);

    List<MyCompany> findByPid(String pid);//내가 일하는 매장 조회
    Optional<Object> findByCompanyName(String companyName);//해당 매장에 일하는 사람 조회
}
