package com.example.readitai;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // Regular expression patterns for email and password validation
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{7,}$";

    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValidEmail(String email) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
}

