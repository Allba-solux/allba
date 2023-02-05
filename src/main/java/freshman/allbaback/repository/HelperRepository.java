package freshman.allbaback.repository;
import freshman.allbaback.domain.Helper;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HelperRepository extends MongoRepository<Helper,String> {

    Optional<Helper> findByHelperPid(String helperPid);

    Optional<Helper> findAllByRequestPid(String requestPid);
}
