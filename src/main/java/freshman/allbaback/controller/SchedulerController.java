package freshman.allbaback.controller;

import freshman.allbaback.domain.Company;
import freshman.allbaback.domain.Scheduler;
import freshman.allbaback.domain.SchedulerFullCalendar;
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
    }

//    @PutMapping("/{companyCode}/{scheduler_id}/DATAaccept")
//    public void allbaOK(@PathVariable String companyCode, @PathVariable String scheduler_id) {
//        //schedulerService.allbaOK(id);
//    }

}
