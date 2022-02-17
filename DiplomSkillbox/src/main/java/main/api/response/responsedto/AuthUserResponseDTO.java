package main.api.response.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserResponseDTO {
    private int id;
    private String name;
    private String photo;
    private String email;
    private boolean moderation;
    private int moderationCount;
    private boolean settings;

    public AuthUserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.photo = user.getPhoto();
        this.email = user.getEmail();
        this.moderation = user.getIsModerator() == 1;
        if (user.getIsModerator() == 1) {
            this.settings = true;
        }
    }
}
