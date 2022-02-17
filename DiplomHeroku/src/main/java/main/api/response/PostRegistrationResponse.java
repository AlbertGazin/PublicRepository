package main.api.response;

import lombok.Data;
import main.api.response.responsedto.PostRegistrationErrorsDTO;

@Data
public class PostRegistrationResponse {
    private boolean result;
    private PostRegistrationErrorsDTO errors;
}
