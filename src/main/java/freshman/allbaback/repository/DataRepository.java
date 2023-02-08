package freshman.allbaback.repository;

import freshman.allbaback.domain.DATA;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DataRepository  extends MongoRepository<DATA, String> {
    public Optional<DATA> findByScheduleID(String scheduleID);
}
