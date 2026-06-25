package org.example.restapitask.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("사용자를 찾을 수 없습니다. ID: " + id);
    }

    public UserNotFoundException(String loginId) {
        super("사용자를 찾을 수 없습니다. loginId: " + loginId);
    }
}