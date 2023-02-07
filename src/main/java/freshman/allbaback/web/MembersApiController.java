package freshman.allbaback.web;

import freshman.allbaback.service.members.MembersService;
import freshman.allbaback.web.dto.MembersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MembersApiController {
    private final MembersService membersService;
    @PostMapping("/user/new")
    public String save(@RequestBody MembersSaveRequestDto requestDto){
        return membersService.save(requestDto);
    }

    @GetMapping("/user/{id}/mypage")
    public Object findById(@PathVariable String id) {
        return membersService.findByPid(id).get();
    }

}
