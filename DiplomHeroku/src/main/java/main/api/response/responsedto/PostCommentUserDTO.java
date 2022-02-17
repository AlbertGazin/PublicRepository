package main.api.response.responsedto;

import lombok.Data;
import main.model.entities.PostComment;

@Data
public class PostCommentUserDTO {
    private int id;
    private String name;
    String photo;

    public PostCommentUserDTO(PostComment postComment) {
        this.id = postComment.getUser().getId();
        this.name = postComment.getUser().getName();
        this.photo = postComment.getUser().getPhoto();
    }
}