package freshman.allbaback.domain.members;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Data
@Getter
@NoArgsConstructor
@Document(collection = "members")
public class Members {

    @Id
    private String pid;
    private String pwd;
    private String name;

    private String phone;
    private String email;
    private String company_name;

    @Builder
    public Members(String pid,String pwd,String name,String phone,String email,String company_name){
        this.pid=pid;
        this.pwd=pwd;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.company_name=company_name;
    }

}
