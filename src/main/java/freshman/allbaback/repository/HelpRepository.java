package freshman.allbaback.repository;

import freshman.allbaback.domain.Help;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HelpRepository extends MongoRepository<Help,String> {
    List<Help> findByRequestPid(String requestPid);

    Optional<Object> findByCompanyName(String companyName);
    Optional<Object> findByPart(String part);
}
