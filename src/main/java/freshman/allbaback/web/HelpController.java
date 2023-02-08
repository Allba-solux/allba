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

    // 대타 요청
    @PostMapping("scheduler/help/request/")
    public Help save(@RequestBody HelpSaveRequestDto requestDto){
        return helpService.save(requestDto);
    }

    // 대타 리스트 조회
    @GetMapping("scheduler/{companyName}/help/")
    public List<Help> findByCompanyName(@PathVariable String companyName) {
        return helpService.findByCompanyName(companyName);
    }

    //내가 요청한 리스트
    @GetMapping("scheduler/help/request/{requestPid}")
    public List<Help> findByRequestPid(@PathVariable String requestPid) {
        return helpService.findByRequestPid(requestPid);
    }

    // 대타 수락
    @PatchMapping("scheduler/help/{id}/allow")
    public void allow(@PathVariable String id, @RequestBody HelpAllowRequestDto dto) {
        helpService.allow(id, dto);
    }

    //내가 도와준 리스트
    @GetMapping("scheduler/give/{helperPid}")
    public List<Help> findByHelperPid(@PathVariable String helperPid) {
        return helpService.findByHelperPid(helperPid);
    }

    //나를 도움준 리스트
    @GetMapping("scheduler/take/{requestPid}")
    public List<Help> findAllByRequestPid(@PathVariable String requestPid) {
        return helpService.findAllByRequestPid(requestPid);
    }


}
