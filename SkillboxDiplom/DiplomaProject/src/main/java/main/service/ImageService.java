package main.service;

import main.api.response.ImageUploadResponse;
import main.api.response.responsedto.ImageUploadErrorsDTO;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    @Value("${image.uploadFolder}")
    private String imagePath;

    @Value("${image.imagePathForLink}")
    private String pathForLink;

    @Value("${image.avatarWidth}")
    private int avatarWidth;

    @Value("${image.avatarHeight}")
    private int avatarHeight;

    @Value("${image.otherImageWidth}")
    private int otherImageWidth;

    @Value("${image.otherImageHeight}")
    private int otherImageHeight;

    @Value("${image.imageSizeTooLargeError}")
    private String imageSizeTooLargeError;

    @Value("${image.imageFormatIsIncorrectError}")
    private String imageFormatIsIncorrectError;

    @Value("${image.validFormat1}")
    private String validFormat1;

    @Value("${image.validFormat2}")
    private String validFormat2;

    @Value("${image.validSize}")
    private int validSize;

    public ResponseEntity uploadImage(MultipartFile photo, boolean isAvatar) {
        ImageUploadResponse response = new ImageUploadResponse();
        ImageUploadErrorsDTO errors = new ImageUploadErrorsDTO();

        if (photo.getSize() / 1024 / 1024 > validSize) {
            errors.setImage(imageSizeTooLargeError);
            response.setErrors(errors);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

        String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
        if (extension == null || (!extension.equalsIgnoreCase(validFormat1) && !extension.equalsIgnoreCase(validFormat2))) {
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

        StringBuilder pathBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            pathBuilder.append(UserRegistrationService.generateRandomAlphabeticString()).append("/");
        }

        String fileName = photo.getOriginalFilename();
        String path = imagePath + pathBuilder;

        if (!saveMultipartFile(path, fileName, photo, isAvatar)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        String finalPath = pathForLink + pathBuilder + fileName;

        return new ResponseEntity(finalPath, HttpStatus.OK);
    }

    private boolean saveMultipartFile(String uploadDir, String fileName, MultipartFile multipartFile, boolean isAvatar) {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                return false;
            }
        }

        File outputFile = new File(uploadDir + fileName);

        try {
            BufferedImage originalImage = ImageIO.read(multipartFile.getInputStream());

            if (isAvatar) {
                originalImage = Scalr.resize(originalImage, avatarWidth, avatarHeight);
            } else {
                originalImage = Scalr.resize(originalImage, otherImageWidth, otherImageHeight);
            }
            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            ImageIO.write(originalImage, extension, outputFile);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
