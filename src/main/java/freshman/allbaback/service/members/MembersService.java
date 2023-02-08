package freshman.allbaback.service.members;

import freshman.allbaback.domain.members.Members;
import freshman.allbaback.repository.MembersRepository;
import freshman.allbaback.web.dto.MembersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class MembersService {

    private final MembersRepository membersRepository;

    public MembersService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    private void validateDuplicateMember(Members members) {
        membersRepository.findByPid(members.getPid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    @Transactional
    public String save(MembersSaveRequestDto requestDto) {
        validateDuplicateMember(requestDto.toEntity());
        return membersRepository.save(requestDto.toEntity()).getPid();
    }

    public Optional<Object> findByPid(String id) {
        return membersRepository.findByPid(id);
    }
    public List<Members> findMembers() {
        return membersRepository.findAll();
    }

}
