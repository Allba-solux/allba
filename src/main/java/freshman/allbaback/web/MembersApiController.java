package freshman.allbaback.web;

import freshman.allbaback.service.members.MembersService;
import freshman.allbaback.web.dto.MembersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController//해당 컨트롤러가 json 형태로 반환되게 만들어줌. @ResponseBody 여러번 선언할 거 한번에 해결.
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
