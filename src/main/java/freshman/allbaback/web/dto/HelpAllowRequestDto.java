package freshman.allbaback.web.dto;

import freshman.allbaback.domain.Help;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@NoArgsConstructor
public class HelpAllowRequestDto {
    @MongoId
    private String id;
    private String helperPid;
    private String helperName;

    @Builder
    public HelpAllowRequestDto(Help entity){
        this.helperPid=helperPid;
        this.helperName=helperName;
    }

}
