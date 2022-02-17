package main.service;

import main.api.request.*;
import main.api.response.*;
import main.api.response.responsedto.AuthUserResponseDTO;
import main.api.response.responsedto.EditProfileErrorsDTO;
import main.api.response.responsedto.PasswordChangeErrorsDTO;
import main.api.response.responsedto.UserRegistrationErrorsDTO;
import main.model.entities.User;
import main.model.enumerated.ModerationStatus;
import main.repository.CaptchaCodeRepository;
import main.repository.PostRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

@Service
public class UserRegistrationService {

    @Value("${user.emailAlreadyExists}")
    private String emailAlreadyExists;

    @Value("${user.wrongName}")
    private String wrongName;

    @Value("${user.incorrectPassword}")
    private String incorrectPassword;

    @Value("${user.incorrectCaptcha}")
    private String incorrectCaptcha;

    @Value("${user.incorrectEmail}")
    private String incorrectEmail;

    @Value("${user.incorrectChangePassLink}")
    private String incorrectChangePassLink;

    @Value("${image.photoNotUploadedError}")
    private String photoNotUploadedError;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CaptchaCodeRepository codeRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CaptchaCodeRepository captchaCodeRepository;

    @Autowired
    private ImageService imageService;

    @Value("${email.from}")
    private String fromEmail;

    @Value("${email.pass}")
    private String senderPassword;

    @Value("${email.subject}")
    private String emailSubject;

    @Value("${email.passRestoreLink}")
    private String passRestoreLink;

    @Value("${email.port}")
    private String smtpPort;

    @Value("${email.host}")
    private String smtpHost;

    @Value("${email.protocol}")
    private String smtpProtocol;

    public UserRegistrationResponse saveUser(UserRegistrationDTO user) {
        UserRegistrationResponse response = new UserRegistrationResponse();
        UserRegistrationErrorsDTO userErrors = new UserRegistrationErrorsDTO();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (isEmailAlreadyExists(user.getEmail())) {
            response.setResult(false);
            userErrors.setEmail(emailAlreadyExists);
            response.setErrors(userErrors);
            return response;
        }

        if (!isNameCorrect(user.getName())) {
            response.setResult(false);
            userErrors.setName(wrongName);
            response.setErrors(userErrors);
            return response;
        }

        if (!isPasswordCorrect(user.getPassword())) {
            response.setResult(false);
            userErrors.setPassword(incorrectPassword);
            response.setErrors(userErrors);
            return response;
        }

        if (!isCaptchaCorrect(user.getCaptcha(), user.getCaptchaSecret())) {
            response.setResult(false);
            userErrors.setPassword(incorrectCaptcha);
            response.setErrors(userErrors);
            return response;
        }

        User userToSave = new User();
        userToSave.setIsModerator(0);
        userToSave.setRegTime(Calendar.getInstance().getTime());
        userToSave.setName(user.getName());
        userToSave.setEmail(user.getEmail());
        userToSave.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(userToSave);

        response.setResult(true);
        return response;
    }

    public boolean isEmailAlreadyExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean isNameCorrect(String name) {
        if (name == null) {
            return false;
        }
        if (name.replaceAll("[a-zA-Zа-яА-Я]", "").length() != 0) {
            return false;
        } else return name.length() <= 255;
    }

    public boolean isPasswordCorrect(String password) {
        return password.length() >= 6;
    }

    public boolean isCaptchaCorrect(String captcha, String captchaSecret) {
        return codeRepository.getCaptchaCode(captchaSecret).equals(captcha);
    }

    private boolean isEmailCorrect(String email) {
        if (email == null) {
            return false;
        }
        InternetAddress address;
        try {
            address = new InternetAddress(email);
            address.validate();
        } catch (AddressException e) {
            return false;
        }
        return true;
    }

    public ResponseEntity<AuthCheckResponse> login(LoginRequest loginRequest, AuthenticationManager authenticationManager) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        if (userOptional.isEmpty()) {
            AuthCheckResponse response = new AuthCheckResponse(false, new AuthUserResponseDTO());
            return ResponseEntity.ok(response);
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        main.model.entities.User userTryToLogin = userOptional.get();

        if (!encoder.matches(loginRequest.getPassword(), userTryToLogin.getPassword())) {
            AuthCheckResponse response = new AuthCheckResponse(false, new AuthUserResponseDTO());
            return ResponseEntity.ok(response);
        }

        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        return ResponseEntity.ok(getAuthCheckResponse(user.getUsername()));
    }

    public AuthCheckResponse getAuthCheckResponse(String email) {
        main.model.entities.User currentUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        AuthUserResponseDTO responseDTO = new AuthUserResponseDTO(currentUser);
        if (responseDTO.isModeration()) {
            responseDTO.setModerationCount(postRepository.findAllPostsByModStatusAndActivityStatus(
                    (short) 1
                    , ModerationStatus.NEW).size());
        }
        return new AuthCheckResponse(true, responseDTO);
    }

    public PasswordRestoreResponse restorePassword(PasswordRestoreRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isEmpty()) {
            return new PasswordRestoreResponse();
        }
        main.model.entities.User currentUser = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(request.getEmail()));

        String code = generateRandomAlphabeticString();
        String msg = passRestoreLink + code;

        String[] toEmail = {request.getEmail()};
        if (
                sendFromGMail(
                        fromEmail
                        , senderPassword
                        , toEmail
                        , emailSubject
                        , msg)) {
            currentUser.setCode(code);
            userRepository.save(currentUser);
            PasswordRestoreResponse response = new PasswordRestoreResponse();

            response.setResult(true);
            return response;
        } else {
            return new PasswordRestoreResponse();
        }
    }

    public static String generateRandomAlphabeticString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private boolean sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", smtpProtocol);

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (InternetAddress address : toAddress) {
                message.addRecipient(Message.RecipientType.TO, address);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(smtpHost, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            return false;
        }
        return true;
    }

    public PasswordChangeResponse changePassword(PasswordChangeRequest request) {
        PasswordChangeResponse response = new PasswordChangeResponse();
        PasswordChangeErrorsDTO errors = new PasswordChangeErrorsDTO();

        User currentUser = new User();

        try {
            currentUser = userRepository.findByCode(request.getCode())
                    .orElseThrow(() -> new UsernameNotFoundException(request.getCode()));
        } catch (UsernameNotFoundException e) {
            errors.setCode(incorrectChangePassLink);
            response.setErrors(errors);
            return response;
        }

        if (!currentUser.getCode().equals(request.getCode())) {
            errors.setCode(incorrectChangePassLink);
            response.setErrors(errors);
            return response;
        }

        String captchaCode = captchaCodeRepository.getCaptchaCode(request.getCaptchaSecret());

        if (!captchaCode.equals(request.getCaptcha())) {
            errors.setCaptcha(incorrectCaptcha);
            response.setErrors(errors);
            return response;
        }

        if (!isPasswordCorrect(request.getPassword())) {
            errors.setPassword(incorrectPassword);
            response.setErrors(errors);
            return response;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        currentUser.setPassword(encoder.encode(request.getPassword()));

        userRepository.save(currentUser);
        response.setResult(true);
        return response;
    }

    public EditProfileResponse editProfile(EditProfileRequest request) {
        EditProfileResponse response = new EditProfileResponse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return response;
        }

        org.springframework.security.core.userdetails.User user
                = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        response = checkEditData(request, currentUser);

        if (response.isResult()) {
            if (request.getRemovePhoto() != 0) {
                currentUser.setPhoto(null);
            }

            currentUser.setName(request.getName());
            currentUser.setEmail(request.getEmail());
            if (request.getPassword() != null) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                currentUser.setPassword(encoder.encode(request.getPassword()));
            }

            response.setResult(true);
            userRepository.save(currentUser);
        }

        return response;
    }

    public EditProfileResponse editProfile(MultipartFile photo, String name, String email, String password) {
        EditProfileResponse response = new EditProfileResponse();
        EditProfileErrorsDTO errors = new EditProfileErrorsDTO();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return response;
        }

        org.springframework.security.core.userdetails.User user
                = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        EditProfileRequest request = new EditProfileRequest();
        request.setName(name);
        request.setEmail(email);
        request.setPassword(password);

        response = checkEditData(request, currentUser);

        if (response.isResult()) {
            if (request.getRemovePhoto() != 0) {
                currentUser.setPhoto(null);
            }

            if (!photo.isEmpty()) {
                ResponseEntity responseEntity = imageService.uploadImage(photo, true);
                if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                    errors.setPhoto(photoNotUploadedError);
                }
                String photoPath = (String) responseEntity.getBody();
                currentUser.setPhoto(photoPath);
            }

            currentUser.setName(request.getName());
            currentUser.setEmail(request.getEmail());
            if (request.getPassword() != null) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                currentUser.setPassword(encoder.encode(request.getPassword()));
            }

            response.setResult(true);
            userRepository.save(currentUser);
        }

        return response;
    }

    private EditProfileResponse checkEditData(EditProfileRequest request, User currentUser) {
        EditProfileResponse response = new EditProfileResponse();
        EditProfileErrorsDTO errors = new EditProfileErrorsDTO();

        if (!isEmailCorrect(request.getEmail())) {
            errors.setEmail(incorrectEmail);
            response.setErrors(errors);
            return response;
        }

        if (!isNameCorrect(request.getName())) {
            errors.setName(wrongName);
            response.setErrors(errors);
            return response;
        }

        if (isEmailAlreadyExists(request.getEmail()) && !request.getEmail().equals(currentUser.getEmail())) {
            errors.setEmail(emailAlreadyExists);
            response.setErrors(errors);
            return response;
        }

        if (request.getPassword() != null) {
            if (!isPasswordCorrect(request.getPassword())) {
                errors.setPassword(incorrectPassword);
                response.setErrors(errors);
                return response;
            }
        }

        response.setResult(true);
        return response;
    }
}