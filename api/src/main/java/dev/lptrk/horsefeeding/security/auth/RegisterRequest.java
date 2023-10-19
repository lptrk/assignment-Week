package dev.lptrk.horsefeeding.security.auth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The RegisterRequest class represents a request for user registration.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    /**
     * The first name of the user to be registered.
     */
    private String firstName;

    /**
     * The last name of the user to be registered.
     */
    private String lastName;

    /**
     * The email address of the user to be registered.
     */
    private String email;

    /**
     * The password chosen by the user for registration.
     */
    private String password;
}
