package freshman.allbaback.service;

import freshman.allbaback.domain.MyCompany;
import freshman.allbaback.repository.MyCompanyRepository;
import freshman.allbaback.web.dto.MyCompanySaveRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MyCompanyService {
    private final MyCompanyRepository myCompanyRepository;

    public MyCompanyService(MyCompanyRepository myCompanyRepository) {
        this.myCompanyRepository = myCompanyRepository;
    }


    @Transactional
    public String save(MyCompanySaveRequestDto requestDto) {
        return myCompanyRepository.save(requestDto.toEntity()).getPid();
    }

    public List<MyCompany> findByPid(String pid) {
        return myCompanyRepository.findByPid(pid);
    }
    public Optional<Object> findByCompanyName(String companyName) {
        return myCompanyRepository.findByCompanyName(companyName);
    }
    public List<MyCompany> findMembers() {
        return myCompanyRepository.findAll();
    }

}
