package com.example.laba4rsoi;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
