package freshman.allbaback.web.dto;

import freshman.allbaback.domain.Help;
import lombok.Getter;

@Getter
public class HelpResponseDto {
    private String requestPid;
    private String requestName;
    private String companyName;

    private String startDate;
    private String endDate;
    private String part;
    private String startTime;
    private String endTime;

    private String helperPid;
    private String helperName;
    public HelpResponseDto(Help entity){
        this.requestPid=requestPid;
        this.requestName=requestName;
        this.companyName=companyName;
        this.startDate=startDate;
        this.endDate=endDate;
        this.part=part;
        this.startTime=startTime;
        this.endTime=endTime;
        this.helperPid=helperPid;
        this.helperName=helperName;
    }
}
