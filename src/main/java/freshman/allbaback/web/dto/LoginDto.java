package freshman.allbaback.web.dto;
import javax.validation.constraints.NotBlank;

import freshman.allbaback.domain.members.Members;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto {
    @NotBlank
    private String pid;
    @NotBlank
    private String pwd;
    public LoginDto(Members entity){ //이 생성자는 필드 중 일부만 사용하므로 Entity 형태로 인자를 받아온다.
        this.pid=pid;
        this.pwd=pwd;
    }
}
