package freshman.allbaback.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
@Document(collection = "schedule")
public class Scheduler {

    // schdule id 따로 있음
    private String companyCode;
    private Boolean help = false;

    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;

    private String userName;



}
