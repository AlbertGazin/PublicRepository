package main.api.response.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.model.entities.PostComment;

@Data
@AllArgsConstructor
public class PostCommentDTO {
    private int id;
    private long timestamp;
    private String text;
    private PostCommentUserDTO user;

    public PostCommentDTO(PostComment comment) {
        this.id = comment.getId();
        this.timestamp = comment.getTime().getTime() / 1000;
        this.text = comment.getText();
        this.user = new PostCommentUserDTO(comment);
    }
}
