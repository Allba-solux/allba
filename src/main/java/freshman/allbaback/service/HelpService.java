package freshman.allbaback.service;

import freshman.allbaback.domain.Help;
import freshman.allbaback.repository.HelpRepository;
import freshman.allbaback.web.dto.HelpAllowRequestDto;
import freshman.allbaback.web.dto.HelpSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertTrue;


@Service
@RequiredArgsConstructor
public class HelpService {
    private final HelpRepository helpRepository;


    private Help settingTime(Help help) {
        if(assertTrue(help.getPart().equals("오픈"))){
            help.setStartTime("08:00");
            help.setEndTime("12:00");
        }else if (assertTrue(help.getPart().equals("미들"))) {
            help.setStartTime("12:00");
            help.setEndTime("16:00");
        }else if (assertTrue(help.getPart().equals("마감"))) {
            help.setStartTime("16:00");
            help.setEndTime("20:00");
        }
        return help;
    }


    @Transactional
    //대타 요청
    public Help save(HelpSaveRequestDto requestDto) {
        Help help = settingTime(requestDto.toEntity());
        //help.setEndDate(help.getStartDate());
        System.out.println(help);
        return helpRepository.save(help);
    }

    //내가 요청한 대타 리스트
    public List<Help> findByRequestPid(String requestPid) {
        return helpRepository.findByRequestPid(requestPid);
    }
    //해당 지점의 대타 요청 리스트
    public List<Help> findByCompanyName(String companyName) {
        List<Help> all = helpRepository.findByCompanyName(companyName);
        List<Help> datas = new ArrayList<Help>();
        for(Help i : all) {
            if(i.getHelperName() == null) datas.add(i);
        }
        return datas;
    }
    //해당 지점의 대타 요청 수락 포함 리스트
    public List<Help> findByCompanyName2(String companyName) {
        return helpRepository.findByCompanyName(companyName);
    }
    public List<Help> findAll(){
        return helpRepository.findAll();
    };
    public String allow(String id,HelpAllowRequestDto dto) {
        Help entity = helpRepository.findById(id).get();

        entity.setHelperPid(dto.getHelperPid());
        entity.setHelperName(dto.getHelperName());
        return helpRepository.save(entity).getId();

    }
    public List<Help> findByHelperPid(String helperPid) {
        return helpRepository.findByHelperPid(helperPid);
    }

    public List<Help> findAllByRequestPid(String requestPid) {
        List<Help> all = helpRepository.findByRequestPid(requestPid);
        List<Help> res = new ArrayList<Help>();
        for(Help i : all) {
            if(i.getHelperPid() != null)
                res.add(i);
        }
        return res;
    }
}
