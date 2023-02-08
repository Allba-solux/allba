package freshman.allbaback.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "DATA")
public class DATA {

    private String scheduleID;
    private String companyCode;

    private String helpName;
    private String requestName;

    @Builder
    public DATA(String scheduleID, String companyCode, String helpName, String requestName) {
        this.scheduleID = scheduleID;
        this.companyCode = companyCode;
        this.helpName = helpName;
        this.requestName = requestName;
    }
}
