package freshman.allbaback.web;

import freshman.allbaback.domain.Helper;
import freshman.allbaback.service.HelperService;
import freshman.allbaback.web.dto.HelperSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HelperController {
    private final HelperService helperService;

    @PostMapping("scheduler/help/request/allow")
    public Helper allow(@RequestBody HelperSaveRequestDto requestDto){
        return helperService.allow(requestDto);
    }


    //내가 도와준 리스트
    @GetMapping("scheduler/helpers/{helperPid}")
    public Optional<Helper> findByHelperPid(@PathVariable String helperPid) {
        return helperService.findByHelperPid(helperPid);
    }

    //나를 도움준 리스트
    @GetMapping("scheduler/helpers/{requestPid}")
    public Optional<Helper> findAllByRequestPid(@PathVariable String requestPid) {
        return helperService.findAllByRequestPid(requestPid);
    }
}
