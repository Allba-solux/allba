package freshman.allbaback.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "help")
public class Help { //대타요청
    private String requestPid;
    private String requestName;
    private String companyName;

    private String startDate;
    private String endDate;
    private String part;
    private String startTime;//오픈,미들,마감
    private String endTime;

    @Builder
    public Help(String requestPid,String requestName,String companyName,String startDate,String endDate,String startTime,
                String endTime,String part){
        this.requestPid=requestPid;
        this.requestName=requestName;
        this.companyName=companyName;
        this.startDate=startDate;
        this.endDate=endDate;
        this.part=part;
        this.startTime=startTime;
        this.endTime=endTime;
    }

}
