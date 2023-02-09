package freshman.allbaback.web.dto;

import freshman.allbaback.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class MembersSaveRequestDto {
    private String id;
    private String pid;
    private String pwd;
    private String name;
    private String phone;
    private String email;
    private String companyName;

    @Builder
    public MembersSaveRequestDto(String id,String pid,String pwd,String name,String phone,String email,String company_name){
        this.id=id;
        this.pid=pid;
        this.pwd=pwd;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.companyName=companyName;
    }

    public Members toEntity(){
        return Members.builder()
                .id(id)
                .pid(pid)
                .pwd(pwd)
                .name(name)
                .phone(phone)
                .email(email)
                .companyName(companyName)
                .build();
    }
}
