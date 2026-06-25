package org.example.restapitask.exception;

public class DuplicateUserException extends RuntimeException {

    public DuplicateUserException(String loginId) {
        super("이미 존재하는 로그인 ID입니다. loginId: " + loginId);
    }
}