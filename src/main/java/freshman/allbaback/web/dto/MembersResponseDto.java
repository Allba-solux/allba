package freshman.allbaback.web.dto;

import freshman.allbaback.domain.members.Members;
import lombok.Getter;

@Getter
public class MembersResponseDto {
    private String pid;
    private String pwd;
    private String name;
    private String phone;
    private String email;
    private String company_name;

    public MembersResponseDto(Members entity){ //이 생성자는 필드 중 일부만 사용하므로 Entity 형태로 인자를 받아온다.
        this.pid=pid;
        this.pwd=pwd;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.company_name=company_name;
    }
}
