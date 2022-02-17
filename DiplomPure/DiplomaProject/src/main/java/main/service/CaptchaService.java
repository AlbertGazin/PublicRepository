package main.service;

import com.github.cage.Cage;
import com.github.cage.image.Painter;
import main.api.response.CaptchaResponse;
import main.model.entities.CaptchaCode;
import main.repository.CaptchaCodeRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;

@Service
public class CaptchaService {

    @Value("${captcha.width}")
    private int captchaWidth;

    @Value("${captcha.height}")
    private int captchaHeight;

    @Value("${captcha.secretCodeLength}")
    private int secretCodeLength;

    @Value("${captcha.captchaLength}")
    private int captchaLength;

    @Value("${captcha.errorMessage}")
    private String captchaError;

    @Value("${captcha.captchaPath}")
    private String captchaPath;

    @Value("${captcha.timeZone}")
    private String captchaTimeZone;

    @Autowired
    private CaptchaCodeRepository captchaCodeRepository;

    public CaptchaResponse getCaptchaInfo() throws NoSuchAlgorithmException {
        Painter painter = new Painter(captchaWidth, captchaHeight, null, null, null, null);
        Cage cage = new Cage(painter, null, null, null, null, null, null);
        String token = cage.getTokenGenerator().next().substring(0, captchaLength);

        StringBuilder result = new StringBuilder();

        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            cage.draw(token, bytes);
            result.append(Base64.encodeBase64String(bytes.toByteArray()));
        } catch (IOException e) {
            result.append(captchaError);
        }

        String secretCode = String.valueOf(generateKey());

        CaptchaCode captchaCode = new CaptchaCode();
        captchaCode.setTime(Calendar.getInstance(TimeZone.getTimeZone(captchaTimeZone)).getTime());
        captchaCode.setCode(token);
        captchaCode.setSecretCode(secretCode);
        captchaCodeRepository.save(captchaCode);

        CaptchaResponse captchaResponse = new CaptchaResponse();
        captchaResponse.setSecret(secretCode);
        captchaResponse.setImage(captchaPath + result);

        return captchaResponse;
    }

    private SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(secretCodeLength);
        return keyGenerator.generateKey();
    }
}
