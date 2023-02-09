package freshman.allbaback.web.dto;

import freshman.allbaback.domain.Help;
import freshman.allbaback.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HelpSaveRequestDto {
    private String id;
    private String requestPid;
    private String requestName;
    private String companyName;

    private String startDate;
    private String endDate;

    private String part;
    private String startTime;//오픈,미들,마감
    private String endTime;

    @Builder
    public HelpSaveRequestDto(Help entity){
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

    public Help toEntity(){
        return Help.builder()
                .requestName(requestName)
                .companyName(companyName)
                .startDate(startDate)
                .endDate(endDate)
                .part(part)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
