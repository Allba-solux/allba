package freshman.allbaback.service;

import freshman.allbaback.domain.Help;
import freshman.allbaback.repository.HelpRepository;
import freshman.allbaback.web.dto.HelpAllowRequestDto;
import freshman.allbaback.web.dto.HelpSaveRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertTrue;


@Service
public class HelpService {
    private final HelpRepository helpRepository;
    public HelpService(HelpRepository helpRepository) {
        this.helpRepository = helpRepository;
    }
    private Help settingTime(Help help) {
        if(assertTrue(help.getPart().equals("오픈"))){
            help.setStartTime("09:00");
            help.setEndTime("12:00");
        } else if (assertTrue(help.getPart().equals("미들"))) {
            help.setStartTime("12:00");
            help.setEndTime("16:00");
        }else if (assertTrue(help.getPart().equals("마감"))) {
            help.setStartTime("16:00");
            help.setEndTime("21:00");
        }
        return help;
    }


    @Transactional
    //대타 요청
    public Help save(HelpSaveRequestDto requestDto) {
        Help help = settingTime(requestDto.toEntity());
        return helpRepository.save(help);
    }

    //내가 요청한 대타 리스트
    public List<Help> findByRequestPid(String requestPid) {
        return helpRepository.findByRequestPid(requestPid);
    }
    //해당 지점의 대타 요청 리스트
    public Optional<Object> findByCompanyName(String companyName) {
        return helpRepository.findByCompanyName(companyName);
    }

    public String allow(String id,HelpAllowRequestDto dto) {
        Help entity = helpRepository.findById(id).get();

        entity.allow(dto.getId(),dto.getHelperPid(), dto.getHelperName());

        return helpRepository.save(entity).getId();
    }
    public Optional<Help> findByHelperPid(String helperPid) {
        return helpRepository.findByHelperPid(helperPid);
    }

}
