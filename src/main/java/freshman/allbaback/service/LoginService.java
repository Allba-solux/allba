package freshman.allbaback.service;

import freshman.allbaback.domain.members.Members;
import freshman.allbaback.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class LoginService {

    private final MembersRepository membersRepository;
    public Members loginMem(String pid, String pwd) {
        System.out.println(pid+"\n"+pwd);
        return membersRepository.findByPid(pid).filter(m -> m.getPwd().equals(pwd)).orElse(null);//.orElse(null)
    }
}
