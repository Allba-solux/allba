package freshman.allbaback.repository;

import freshman.allbaback.domain.members.Members;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MembersRepositoryTest {
    @Autowired
    MembersRepository membersRepository;

    @After
    public void cleanup(){
        membersRepository.deleteAll();
    }

    @Test
    public void 회원가입저장_불러오기(){
        //given
        String pid="crystal";
        String pwd = "0000";
        String name = "김둘리";
        String phone = "010-2704-0568";
        String email = "ss@sookmyung.ac.kr";
        String company_name = "SM컴퍼니";

        membersRepository.save(Members.builder()
                .pid(pid)
                .pwd(pwd)
                .name(name)
                .phone(phone)
                .email(email)
                .company_name(company_name)
                .build());

        //when
        List<Members> membersList = membersRepository.findAll();
        //then
        Members members = membersList.get(0);
        assertThat(members.getPid()).isEqualTo(pid);
        assertThat(members.getPid()).isEqualTo(pid);
    }
}
