package freshman.allbaback.controller;

import freshman.allbaback.domain.Company;
import freshman.allbaback.domain.Scheduler;
import freshman.allbaback.domain.members.Members;
import freshman.allbaback.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/scheduler")
@RequiredArgsConstructor
@RestController
public class SchedulerController {

    private final SchedulerService schedulerService;
    // 스케줄 생성
    @PostMapping("/{companyCode}/new")
    public String createNewSchedule(@PathVariable String companyCode, @RequestBody Scheduler scheduler) {
        scheduler.setCompanyCode(companyCode);
        schedulerService.addScheduler(scheduler);
        return "newSchedule";
    }

    // 지점 스케줄러 조회
    @GetMapping("{companyCode}")
    public List<Scheduler> viewAll(@PathVariable String companyCode) {


        // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);
        return schedulerService.findSchedulers(companyCode);

    }


}
