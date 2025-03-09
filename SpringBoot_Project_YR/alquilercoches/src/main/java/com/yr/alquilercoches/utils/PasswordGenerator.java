
package com.yr.alquilercoches.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "admin";
        String encoded = encoder.encode(password);
        System.out.println("Encoded password for '" + password + "': " + encoded);
    }
}