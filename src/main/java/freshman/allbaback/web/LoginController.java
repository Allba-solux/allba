package freshman.allbaback.web;

import freshman.allbaback.domain.members.Members;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import freshman.allbaback.service.LoginService;
import freshman.allbaback.web.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginForm(@ModelAttribute("user") LoginDto loginDto) {

        System.out.println("로그인화면 호출합니다.");
        return "/LoginView";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody @Validated LoginDto loginDto,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL, HttpServletRequest request) {
        Members loginMember = loginService.loginMem(loginDto.getPid(), loginDto.getPwd());
        if (loginMember == null) {
            bindingResult.reject("Fail", "아이디 또는 비밀번호가 맞지 않습니다.");
            System.out.println("입력값"+loginMember);
            return "false";
        }else if (bindingResult.hasErrors()) {
            String n = String.valueOf(bindingResult);
            return "뭔지 모르게써"+n;
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession();
        session.setAttribute(LoginSession.LOGIN_MEMBER, loginMember);
        System.out.println(loginMember.getName());
        session.setAttribute("name",loginMember.getName());
        session.setAttribute("company",loginMember.getName());
        return String.valueOf(session.getAttribute("name"));

    }
    

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  
        }

        return "redirect:/";
    }

//    @GetMapping("/")
//    public String home(@SessionAttribute(name = LoginSession.LOGIN_MEMBER, required = false) Members loginMember, Model model) {
//        // 세션에 회원 데이터가 없으면 홈으로 이동
//        if (loginMember == null) {
//            return "세션없음";
//        }
//
//        // 세션이 유지되면 로그인 홈으로 이동
//        model.addAttribute("member", loginMember);
//        return "세션 유지";
//    }
}
