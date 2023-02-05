package freshman.allbaback.web.dto;

import freshman.allbaback.domain.Helper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HelperSaveRequestDto {
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
    public HelperSaveRequestDto(Helper entity){
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

    public Helper toEntity(){
        return Helper.builder()
                .requestPid(requestPid)
                .requestName(requestName)
                .companyName(companyName)
                .startDate(startDate)
                .endDate(endDate)
                .part(part)
                .startTime(startTime)
                .endTime(endTime)
                .helperPid(helperPid)
                .helperName(helperName)
                .build();
    }
}
