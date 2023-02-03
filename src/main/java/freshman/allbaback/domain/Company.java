package freshman.allbaback.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Getter @Setter
@Document(collection = "company")
public class Company {
    @MongoId
    private String companyCode;

    private String companyName;
    private String companyPW;
    private String companyDescription;

    //private Scheduler companySchedule;
    //private List<Member> employee;
}
