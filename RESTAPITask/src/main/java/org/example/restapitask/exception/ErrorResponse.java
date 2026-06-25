package org.example.restapitask.exception;

public record ErrorResponse(
        String code,
        String message
) {
}