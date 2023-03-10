package freshman.allbaback.repository;

import com.mongodb.client.DistinctIterable;
import freshman.allbaback.domain.members.Members;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public interface MembersRepository extends MongoRepository<Members,String> {
    Members save(Members members);

    Optional<Members> findByPid(String pid);

}
