package main.api.response.responsedto;

import lombok.Data;

@Data
public class EditProfileErrorsDTO {
    private String email;
    private String photo;
    private String name;
    private String password;
}
