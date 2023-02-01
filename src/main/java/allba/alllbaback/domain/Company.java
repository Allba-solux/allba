package allba.alllbaback.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "company")
public class Company {

    private int companyCode;

    private String companyName;
    private String companyPW;
    private String companyDescription;

    private Scheduler companySchedule;
    private List<Member> employee;
}
