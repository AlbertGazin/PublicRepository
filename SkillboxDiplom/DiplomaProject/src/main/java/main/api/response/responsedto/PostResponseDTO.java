package main.api.response.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.model.entities.Post;

@Data
@AllArgsConstructor
public class PostResponseDTO {

    private final int ANNOUNCE_LENGTH = 150;
    private int id;
    private long timestamp;
    private PostUserResponseDTO user;
    private String title;
    private String announce;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;
    private int viewCount;

    public PostResponseDTO(Post post) {
        this.id = post.getId();
        this.timestamp = post.getTime().getTime() / 1000;
        this.user = new PostUserResponseDTO(post.getUser().getId(), post.getUser().getName());
        this.title = post.getTitle();
        String textWithoutHTMLTags = post.getText().replaceAll("\\<.*?\\>", "");
        this.announce = textWithoutHTMLTags.substring(0, Math.min(textWithoutHTMLTags.length(), ANNOUNCE_LENGTH)) +
                (textWithoutHTMLTags.length() > ANNOUNCE_LENGTH ? "..." : "");
        this.likeCount = (int) post.getVotes().stream().filter(v -> v.getValue() == 1).count();
        this.dislikeCount = (int) post.getVotes().stream().filter(v -> v.getValue() == -1).count();
        this.commentCount = post.getComments().size();
        this.viewCount = post.getViewCount();
    }
}