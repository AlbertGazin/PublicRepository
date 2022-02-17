package main.api.response;

import lombok.Data;
import main.api.response.responsedto.CommentRegistrationErrorsDTO;

@Data
public class CommentResponse {
    private int id;
    private boolean result;
    private CommentRegistrationErrorsDTO errors;
}
