package freshman.allbaback.controller;

import freshman.allbaback.domain.Company;
import freshman.allbaback.domain.Scheduler;
import freshman.allbaback.domain.SchedulerFullCalendar;
import freshman.allbaback.domain.members.Members;
import freshman.allbaback.service.DataService;
import freshman.allbaback.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/scheduler")
@RequiredArgsConstructor
@RestController
public class SchedulerController {

    private final SchedulerService schedulerService;
    private final DataService dataService;

    @PostMapping("/{companyCode}/new")
    public String createNewSchedule(@PathVariable String companyCode, @RequestBody Scheduler scheduler) {
        scheduler.setCompanyCode(companyCode);
        schedulerService.addSchedule(scheduler);
        return "newSchedule";
    }

    @GetMapping("{companyCode}")
    public List<SchedulerFullCalendar> viewAll(@PathVariable String companyCode) {
        return schedulerService.findSchedulers(companyCode);
    }

//    @DeleteMapping("/{companyCode}/{scheduler_id}/delete")
//    public void deleteSchedule(@PathVariable String companyCode, @PathVariable String scheduler_id) {
//        schedulerService.deleteSchedule(scheduler_id);
//    }

    @GetMapping("{companyCode}/data")
    public List<Scheduler> viewData(@PathVariable String companyCode) {
        return schedulerService.findDatas(companyCode);
    }

    @PostMapping("/{companyCode}/help")
    public void allbaPlease(@PathVariable String companyCode, @RequestBody Scheduler scheduler) {
        scheduler.setCompanyCode(companyCode);
        scheduler.setHelp(Boolean.TRUE);
        schedulerService.addSchedule(scheduler);
        dataService.addDATA(scheduler.getId(), scheduler.getCompanyCode(), scheduler.getUserName(), "");
    }

    @PutMapping("/{companyCode}/{scheduler_id}/{user_id}/dataAccept")
    public void allbaOK(@PathVariable String companyCode, @PathVariable String scheduler_id, @PathVariable String user_id) {
        System.out.println("ok");
        schedulerService.allbaOK(scheduler_id, user_id);
    }

}
