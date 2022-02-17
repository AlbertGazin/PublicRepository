package main.api.response;

import lombok.Data;
import main.api.response.responsedto.UserRegistrationErrorsDTO;

@Data
public class UserRegistrationResponse {
    private boolean result;
    private UserRegistrationErrorsDTO errors;
}
