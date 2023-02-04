package freshman.allbaback.web;

import freshman.allbaback.service.MyCompanyService;
import freshman.allbaback.service.members.MembersService;
import freshman.allbaback.web.dto.MembersSaveRequestDto;
import freshman.allbaback.web.dto.MyCompanySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MyCompanyController {
    private final MyCompanyService myCompanyService;
    @PostMapping("/company/join")
    public String save(@RequestBody MyCompanySaveRequestDto requestDto){
        return myCompanyService.save(requestDto);
    }

    @GetMapping("/mycompany/{pid}")
    public List findByPid(@PathVariable String pid) {
        return myCompanyService.findByPid(pid);
    }

    @GetMapping("/{companyName}/worker")
    public Object findByCompany_Name(@PathVariable String companyName) {
        return myCompanyService.findByCompanyName(companyName).get();
    }

}
