package freshman.allbaback.web;

import freshman.allbaback.domain.Help;
import freshman.allbaback.service.HelpService;
import freshman.allbaback.web.dto.HelpAllowRequestDto;
import freshman.allbaback.web.dto.HelpSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HelpController {
    private final HelpService helpService;

    @PostMapping("scheduler/help/request/")
    public Help save(@RequestBody HelpSaveRequestDto requestDto){
        return helpService.save(requestDto);
    }

    @GetMapping("scheduler/{companyName}/help/")
    public Object findByCompanyName(@PathVariable String companyName) {
        return helpService.findByCompanyName(companyName).get();
    }

    //내가 요청한 리스트
    @GetMapping("scheduler/help/request/{requestPid}")
    public List<Help> findByRequestPid(@PathVariable String requestPid) {
        return helpService.findByRequestPid(requestPid);
    }
    @PatchMapping("scheduler/help/{id}/allow")
    public String allow(@PathVariable String id, @RequestBody HelpAllowRequestDto dto) {
        return helpService.allow(id, dto);
    }

    //내가 도와준 리스트
    @GetMapping("scheduler/helpers/{helperPid}")
    public Optional<Help> findByHelperPid(@PathVariable String helperPid) {
        return helpService.findByHelperPid(helperPid);
    }

//    //나를 도움준 리스트
//    @GetMapping("scheduler/helpers/{requestPid}")
//    public Optional<Helper> findAllByRequestPid(@PathVariable String requestPid,@PathVariable String helperPid) {
//        if (helperPid!=null)
//        return helperService.findAllByRequestPid(requestPid);
//    }


}
