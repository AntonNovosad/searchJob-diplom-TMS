package by.teachmeskills.diplom.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecurityConfigurationTest {
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Test
    void passwordEncoder() {
        String password = "admin";
        String encode = passwordEncoder.encode(password);
        assertTrue(passwordEncoder.matches(password, encode));
    }
}
