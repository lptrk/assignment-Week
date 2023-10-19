package dev.lptrk.horsefeeding.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The CorsConfiguration class configures Cross-Origin Resource Sharing (CORS) for the application.
 */
@Configuration
public class CorsConfiguration {

    /**
     * Create a WebMvcConfigurer bean for configuring CORS settings.
     *
     * @return WebMvcConfigurer for CORS configuration.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowCredentials(true);
            }
        };
    }
}
