package dev.lptrk.horsefeeding.security.auth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The AuthenticationRequest class represents a request to authenticate a user.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    /**
     * The email address associated with the user's account.
     */
    private String email;

    /**
     * The user's password for authentication.
     */
    private String password;
}
