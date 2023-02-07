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

@Slf4j
@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginDto loginDto) {
        return "frontend/src/views/LoginView";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginDto loginDto,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "LoginView";
        }

        Members loginMember = loginService.login(loginDto.getPid(), loginDto.getPwd());

        if (loginMember == null) {
            bindingResult.reject("Fail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "LoginView";
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession();
        session.setAttribute(LoginSession.LOGIN_MEMBER, loginMember);

        return "redirect:LoginView";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  
        }

        return "redirect:/";
    }

    @GetMapping("/")
    public String home(@SessionAttribute(name = LoginSession.LOGIN_MEMBER, required = false) Members loginMember, Model model) {
        // 세션에 회원 데이터가 없으면 홈으로 이동
        if (loginMember == null) {
            return "home";
        }

        // 세션이 유지되면 로그인 홈으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
