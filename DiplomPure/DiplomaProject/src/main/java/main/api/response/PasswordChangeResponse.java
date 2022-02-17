package main.api.response;

import lombok.Data;
import main.api.response.responsedto.PasswordChangeErrorsDTO;

@Data
public class PasswordChangeResponse {
    private boolean result;
    private PasswordChangeErrorsDTO errors;
}
