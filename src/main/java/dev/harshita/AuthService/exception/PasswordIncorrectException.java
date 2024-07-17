package dev.harshita.AuthService.exception;

public class PasswordIncorrectException extends RuntimeException{
    public PasswordIncorrectException(String s) {
        super(s);
    }
}
