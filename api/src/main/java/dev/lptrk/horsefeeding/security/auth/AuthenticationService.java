package dev.lptrk.horsefeeding.security.auth;
import dev.lptrk.horsefeeding.security.config.JwtService;
import dev.lptrk.horsefeeding.user.Role;
import dev.lptrk.horsefeeding.entity.User;
import dev.lptrk.horsefeeding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The AuthenticationService class handles user registration and authentication.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Registers a new user.
     *
     * @param request The RegisterRequest containing user registration information.
     * @return An AuthenticationResponse with a JWT token.
     */
    public AuthenticationResponse register(RegisterRequest request) {
        // Create a UserEty object with user details
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        // Save the user to the repository
        repository.save(user);

        // Generate a JWT token for the registered user
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .jwt(jwtToken)
                .build();
    }

    /**
     * Authenticates a user.
     *
     * @param request The AuthenticationRequest containing user authentication information.
     * @return An AuthenticationResponse with a JWT token.
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Authenticate the user's credentials using the AuthenticationManager
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Fetch the user from the repository
        var user = repository.findByEmail(request.getEmail()).orElseThrow();

        // Generate a JWT token for the authenticated user
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .jwt(jwtToken)
                .build();
    }
}
