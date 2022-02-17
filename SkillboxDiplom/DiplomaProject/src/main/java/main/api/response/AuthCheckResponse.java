package main.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.api.response.responsedto.AuthUserResponseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthCheckResponse {
    private boolean result;
    private AuthUserResponseDTO user;
}