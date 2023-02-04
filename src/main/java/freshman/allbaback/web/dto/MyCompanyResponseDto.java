package freshman.allbaback.web.dto;

import freshman.allbaback.domain.MyCompany;
import freshman.allbaback.domain.members.Members;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MyCompanyResponseDto {
    private String pid;

    private String name;
    private String company_Name;
    private String part;
    private Double pay;


    public MyCompanyResponseDto(MyCompany entity){
        this.pid=pid;
        this.name=name;
        this.company_Name=company_Name;
        this.part=part;
        this.pay=pay;
    }
}
