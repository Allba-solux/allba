package freshman.allbaback.web.dto;

import freshman.allbaback.domain.MyCompany;
import freshman.allbaback.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyCompanySaveRequestDto {
    private String pid;

    private String name;
    private String companyName;
    private String part;
    private Double pay;

    @Builder
    public MyCompanySaveRequestDto(String pid,String name,String companyName,String part,Double pay){
        this.pid=pid;
        this.name=name;
        this.companyName=companyName;
        this.part=part;
        this.pay=pay;
    }

    public MyCompany toEntity(){
        return MyCompany.builder()
                .pid(pid)
                .name(name)
                .companyName(companyName)
                .part(part)
                .pay(pay)
                .build();
    }
}
