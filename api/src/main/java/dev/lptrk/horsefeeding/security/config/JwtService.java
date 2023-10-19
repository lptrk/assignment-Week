package dev.lptrk.horsefeeding.security.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The JwtService class provides JWT (JSON Web Token) related functionality for authentication and authorization.
 */
@Service
public class JwtService {

    private static final String SECRET_KEY = "4651374f5330413535696f5263334d6262703462535046645657484447773533";

    /**
     * Extract the username from a JWT token.
     *
     * @param token The JWT token from which to extract the username.
     * @return The username extracted from the token.
     */
    public String extractUsername(String token) {
        try {
            final Claims claims = extractAllClaims(token);
            return claims.getSubject();
        } catch (Exception e) {
            //TODO add exception handling
            return null;
        }
    }

    /**
     * Extract a specific claim from a JWT token using a claims resolver function.
     *
     * @param token          The JWT token from which to extract the claim.
     * @param claimsResolver The function to resolve the claim from the token's claims.
     * @param <T>            The type of the claim to extract.
     * @return The resolved claim extracted from the token.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Generate a JWT token for a user based on their UserDetails.
     *
     * @param userDetails The UserDetails of the user for whom the token is generated.
     * @return The generated JWT token.
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Generate a JWT token with additional claims for a user based on their UserDetails.
     *
     * @param extraClaims   Additional claims to include in the JWT token.
     * @param userDetails    The UserDetails of the user for whom the token is generated.
     * @return The generated JWT token.
     */
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Check if a JWT token is valid for a given UserDetails.
     *
     * @param token       The JWT token to validate.
     * @param userDetails  The UserDetails for which to validate the token.
     * @return True if the token is valid for the UserDetails, false otherwise.
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Check if a JWT token has expired.
     *
     * @param token The JWT token to check for expiration.
     * @return True if the token has expired, false otherwise.
     */
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
