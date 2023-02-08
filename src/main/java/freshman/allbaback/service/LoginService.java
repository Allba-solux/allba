package freshman.allbaback.service;

import freshman.allbaback.domain.members.Members;
import freshman.allbaback.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final MembersRepository membersRepository;

    public Members login(String pid, String pwd) {

        return membersRepository.findByLoginPid(pid)
                .filter(m -> m.getPwd().equals(pwd))
                .orElse(null);//로그인 실패
    }
}
