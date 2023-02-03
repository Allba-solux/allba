package freshman.allbaback.repository;

import freshman.allbaback.domain.members.Members;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface MembersRepository extends MongoRepository<Members,String> {
    Members save(Members members);

    Optional<Object> findByPid(String pid);
}
