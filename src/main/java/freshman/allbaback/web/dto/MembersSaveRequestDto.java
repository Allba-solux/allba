package freshman.allbaback.web.dto;

import freshman.allbaback.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class MembersSaveRequestDto {
    private String pid;
    private String pwd;
    private String name;
    private String phone;
    private String email;
    private String company_name;

    @Builder //빌더 클래스 생성, 생성자 위에 선언 시 해당 필드들만 빌더에 포함한다.
    public MembersSaveRequestDto(String pid,String pwd,String name,String phone,String email,String company_name){
        this.pid=pid;
        this.pwd=pwd;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.company_name=company_name;
    }

    public Members toEntity(){
        return Members.builder()
                .pid(pid)
                .pwd(pwd)
                .name(name)
                .phone(phone)
                .email(email)
                .company_name(company_name)
                .build();
    }
}
