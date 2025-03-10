package com.yr.alquilercoches.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10); // Use same strength as SecurityConfig
        String password = "as";
        String encoded = encoder.encode(password);
        System.out.println("Raw password: " + password);
        System.out.println("Encoded password: " + encoded);
        
        // Verify the password matches
        boolean matches = encoder.matches(password, encoded);
        System.out.println("Password matches: " + matches);
    }
}