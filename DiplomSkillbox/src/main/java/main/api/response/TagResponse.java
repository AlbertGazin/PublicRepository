package main.api.response;

import lombok.Data;
import main.api.response.responsedto.TagResponseDTO;

import java.util.List;

@Data
public class TagResponse {
    private List<TagResponseDTO> tags;
}