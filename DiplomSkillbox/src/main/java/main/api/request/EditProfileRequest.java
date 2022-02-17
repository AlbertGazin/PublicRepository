package main.api.request;

import lombok.Data;

@Data
public class EditProfileRequest {
    private String name;
    private String email;
    private String password;
    private short removePhoto;
}
