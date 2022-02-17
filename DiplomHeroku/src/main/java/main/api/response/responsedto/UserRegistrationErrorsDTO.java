package main.api.response.responsedto;

import lombok.Data;

@Data
public class UserRegistrationErrorsDTO {
    private String email;
    private String name;
    private String password;
    private String captcha;
}
