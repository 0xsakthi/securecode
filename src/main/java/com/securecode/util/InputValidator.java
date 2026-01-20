package com.securecode.util;

import java.util.regex.Pattern;

public class InputValidator {

    // Regex pattern for a strong password
    private static final Pattern PASSWORD_PATTERN = 
            Pattern.compile("^(?=.*[0-9])" +  
            "(?=.*[a-z])(?=.*[A-Z])" +  
            "(?=.*[@#$%^&+=])" +  
            ".{8,}$");

    // Validate email format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }

    // Validate password strength
    public static boolean isValidPassword(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }

    // Validate username: Alphanumeric and 3-15 characters
    public static boolean isValidUsername(String username) {
        String usernameRegex = "^[a-zA-Z0-9]{3,15}$";
        return username != null && username.matches(usernameRegex);
    }
}