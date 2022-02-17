package main.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.api.response.responsedto.PostCommentDTO;
import main.api.response.responsedto.PostUserResponseDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostByIdResponse {
    private int id;
    private long timestamp;
    private boolean active;
    private PostUserResponseDTO user;
    private String title;
    private String text;
    private int likeCount;
    private int dislikeCount;
    private int viewCount;
    private List<PostCommentDTO> comments;
    private List<String> tags;
}
