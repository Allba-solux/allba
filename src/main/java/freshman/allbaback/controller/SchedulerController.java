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
    @PostMapping("/new")
    public String createNewSchedule(@RequestBody Scheduler scheduler) {
        schedulerService.addScheduler(scheduler);
        return "newSchedule";
    }

    // 지점 스케줄러 조회
    @GetMapping("")
    public List<Scheduler> viewAll() {


        // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);
        return schedulerService.findSchedulers();

    }


}
