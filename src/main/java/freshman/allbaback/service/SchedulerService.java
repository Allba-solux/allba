package freshman.allbaback.service;

import freshman.allbaback.domain.Scheduler;
import freshman.allbaback.domain.SchedulerFullCalendar;
import freshman.allbaback.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SchedulerService {

    @Autowired
    private SchedulerRepository schedulerRepository;

    // 스케줄 등록
    public void addSchedule(Scheduler scheduler) {
        schedulerRepository.insert(scheduler);
    }

    // 스케줄 조회
    public List<SchedulerFullCalendar> findSchedulers(String companyCode) {
        List<Scheduler> V_Calendars = schedulerRepository.findByCompanyCode(companyCode);
        List<SchedulerFullCalendar> fullCalendars = new ArrayList<SchedulerFullCalendar>();
        for(Scheduler i : V_Calendars) {
            String start = i.getStartDate() + "T" + i.getStartTime() + ":00";
            String end = i.getEndDate() + "T" + i.getEndTime()+ ":00";
            String title = i.getUserName();
            fullCalendars.add(new SchedulerFullCalendar(start, end, title));
        }
        return fullCalendars;
    }

    // 스케줄 삭제
    public void deleteSchedule(String id) {
        schedulerRepository.deleteById(id);
    }

    // 대타 조회
    public List<Scheduler> findDatas(String companyCode) {
        List<Scheduler> all = schedulerRepository.findByCompanyCode(companyCode);
        List<Scheduler> datas = new ArrayList<Scheduler>();
        for(Scheduler i : all) {
            if(i.getHelp()) datas.add(i);
        }
        return datas;
    }

//    // 대타 요청
//    public void allbaPlease(Scheduler scheduler) {
//        schedulerRepository.insert(scheduler);
//
//    }

//    // 대타 수락
//    public void allbaOK(String id) {
//        schedulerRepository.findById(id);
//    }
}
