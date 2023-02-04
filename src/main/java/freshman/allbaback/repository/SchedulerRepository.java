package freshman.allbaback.repository;

import freshman.allbaback.domain.Scheduler;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SchedulerRepository extends MongoRepository<Scheduler,String> {
    //public List<Scheduler> findByCompanyName(String companyName);
}
