package freshman.allbaback.service;

import freshman.allbaback.domain.Helper;
import freshman.allbaback.repository.HelperRepository;
import freshman.allbaback.web.dto.HelperSaveRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertTrue;


@Service
public class HelperService {
    private final HelperRepository helperRepository;

    public HelperService(HelperRepository helperRepository) {
        this.helperRepository = helperRepository;
    }
    private Helper settingTime(Helper help) {
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

    //대타 수락
    public Helper allow(HelperSaveRequestDto requestDto) {
        Helper help = settingTime(requestDto.toEntity());
        return helperRepository.save(help);
    }


    //내가 대타해준 리스트
    public Optional<Helper> findByHelperPid(String helperPid) {
        return helperRepository.findByHelperPid(helperPid);
    }


    //나를 대타해준 리스트
    public Optional<Helper> findAllByRequestPid(String requestPid) {
        return helperRepository.findAllByRequestPid(requestPid);
    }



}
