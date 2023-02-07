package freshman.allbaback.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Getter
@Setter
@Document(collection = "help")
public class Help { //대타요청
    @MongoId
    private String id;
    private String requestPid;
    private String requestName;
    private String companyName;

    private String startDate;
    private String endDate;
    private String part;
    private String startTime;//오픈,미들,마감
    private String endTime;
    private String helperPid;
    private String helperName;

    @Builder
    public Help(String id,String requestPid,String requestName,String companyName,String startDate,String endDate,String startTime,
                String endTime,String part){
        this.id=id;
        this.requestPid=requestPid;
        this.requestName=requestName;
        this.companyName=companyName;
        this.startDate=startDate;
        this.endDate=endDate;
        this.part=part;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public void allow(String id,String helperPid,String helperName) {
        this.id = id;
        this.helperPid=helperPid;
        this.helperName=helperName;
    }

}
