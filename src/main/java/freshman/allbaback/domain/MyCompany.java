package freshman.allbaback.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "my_company")
public class MyCompany {
    private String pid;

    private String name;
    private String companyName;
    private String part;
    private Double pay;

    @Builder
    public MyCompany(String pid,String name,String companyName,String part,Double pay){
        this.pid=pid;
        this.name=name;
        this.companyName=companyName;
        this.part=part;
        this.pay=pay;
    }
}

