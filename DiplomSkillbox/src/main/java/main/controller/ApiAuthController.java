package main.controller;

import main.api.request.LoginRequest;
import main.api.request.PasswordChangeRequest;
import main.api.request.PasswordRestoreRequest;
import main.api.request.UserRegistrationDTO;
import main.api.response.*;
import main.repository.UserRepository;
import main.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private final UserRegistrationService userRegistrationService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Autowired
    public ApiAuthController(UserRegistrationService userRegistrationService
            , AuthenticationManager authenticationManager
            , UserRepository userRepository) {
        this.userRegistrationService = userRegistrationService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthCheckResponse> login(@RequestBody LoginRequest loginRequest) {
        return userRegistrationService.login(loginRequest, authenticationManager);
    }

    @GetMapping("/logout")
    public LogoutResponse logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return new LogoutResponse();
    }

    @GetMapping("/check")
    private ResponseEntity<AuthCheckResponse> authCheckResponse(Principal principal) {
        if (principal == null) {
            return ResponseEntity.ok(new AuthCheckResponse());
        }
        return ResponseEntity.ok(userRegistrationService.getAuthCheckResponse(principal.getName()));
    }

    @PostMapping("/register")
    public UserRegistrationResponse registration(@RequestBody UserRegistrationDTO user) {
        return userRegistrationService.saveUser(user);
    }

    @PostMapping("/restore")
    public PasswordRestoreResponse restorePassword(@RequestBody PasswordRestoreRequest request) {
        return userRegistrationService.restorePassword(request);
    }

    @PostMapping("/password")
    public PasswordChangeResponse changePassword(@RequestBody PasswordChangeRequest request) {
        return userRegistrationService.changePassword(request);
    }
}