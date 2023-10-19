package dev.lptrk.horsefeeding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.SpringSecurityCoreVersion;

@SpringBootApplication
public class HorseFeedingApplication {

    public static void main(String[] args) {
        System.out.println("Verwendete Spring Security-Version: " + SpringSecurityCoreVersion.getVersion());
        SpringApplication.run(HorseFeedingApplication.class, args);
    }

}