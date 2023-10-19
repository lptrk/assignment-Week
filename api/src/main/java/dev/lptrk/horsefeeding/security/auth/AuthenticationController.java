package dev.lptrk.horsefeeding.security.auth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The AuthenticationController class handles authentication-related HTTP requests.
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    /**
     * Register a new user.
     *
     * @param request The RegisterRequest containing user registration information.
     * @return ResponseEntity with an AuthenticationResponse indicating the registration result.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    /**
     * Authenticate a user.
     *
     * @param request The AuthenticationRequest containing user authentication information.
     * @return ResponseEntity with an AuthenticationResponse indicating the authentication result.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
