package freshman.allbaback.web.dto;
import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class LoginDto {
    @NotBlank
    private String pid;
    @NotBlank
    private String pwd;
}
