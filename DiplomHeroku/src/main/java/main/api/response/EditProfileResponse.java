package main.api.response;

import lombok.Data;
import main.api.response.responsedto.EditProfileErrorsDTO;

@Data
public class EditProfileResponse {
    private boolean result;
    private EditProfileErrorsDTO errors;
}
