package main.api.response.responsedto;

import lombok.Data;

@Data
public class PasswordChangeErrorsDTO {
    private String code;
    private String password;
    private String captcha;
}
