package freshman.allbaback.service;

import freshman.allbaback.domain.Scheduler;
import freshman.allbaback.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedulerService {

    @Autowired
    private SchedulerRepository schedulerRepository;

    // 스케줄 등록
    public void addScheduler(Scheduler scheduler) {
        System.out.println("addScheduler");
        schedulerRepository.insert(scheduler);
    }

    // 스케줄 조회
    public List<Scheduler> findSchedulers(String companyCode) {
        return schedulerRepository.findByCompanyCode(companyCode);
    }
    //
}
