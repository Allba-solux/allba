package freshman.allbaback.web;

import freshman.allbaback.domain.Help;
import freshman.allbaback.service.HelpService;
import freshman.allbaback.web.dto.HelpSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
