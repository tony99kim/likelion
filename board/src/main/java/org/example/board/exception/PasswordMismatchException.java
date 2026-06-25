package org.example.board.exception;

public class PasswordMismatchException extends RuntimeException {

    public PasswordMismatchException(String message) {
        super(message);
    }

    public PasswordMismatchException() {
        super("암호가 일치하지 않습니다.");
    }
}