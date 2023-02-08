package freshman.allbaback.service;

import freshman.allbaback.domain.DATA;
import freshman.allbaback.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public void addDATA(String id, String companyCode, String helperName, String requestName) {
        DATA data  = new DATA(id, companyCode, helperName, requestName);
        dataRepository.insert(data);
    }
}
