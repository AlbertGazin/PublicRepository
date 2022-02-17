package main.api.response.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostUserResponseDTO {
    private int id;
    private String name;
}
