package main.api.response;

import lombok.Data;
import main.api.response.responsedto.ImageUploadErrorsDTO;

@Data
public class ImageUploadResponse {
    private boolean result;
    private ImageUploadErrorsDTO errors;
}
