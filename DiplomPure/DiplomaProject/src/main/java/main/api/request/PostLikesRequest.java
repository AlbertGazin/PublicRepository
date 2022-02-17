package main.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostLikesRequest {
    @JsonProperty("post_id")
    private int postId;
}
