package main.api.response;

import lombok.Data;
import main.api.response.responsedto.PostResponseDTO;

import java.util.List;

@Data
public class PostResponse {
    private int count;
    private List<PostResponseDTO> posts;
}