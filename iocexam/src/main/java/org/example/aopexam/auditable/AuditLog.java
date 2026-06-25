package org.example.aopexam.auditable;

import java.time.LocalDateTime;

public class AuditLog {
    private String action;
    private String username;
    private LocalDateTime timestamp;
    private String methodName;
    private Object[] arguments;
    private Object result;
    private String status;  // SUCCESS, FAILED
    private String errorMessage;

    // 생성자
    public AuditLog(String action, String username, String methodName) {
        this.action = action;
        this.username = username;
        this.methodName = methodName;
        this.timestamp = LocalDateTime.now();
    }

    // Getter, Setter 생략
    public void setArguments(Object[] arguments) { this.arguments = arguments; }
    public void setResult(Object result) { this.result = result; }
    public void setStatus(String status) { this.status = status; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    @Override
    public String toString() {
        return String.format(
                "[AUDIT] Action: %s, User: %s, Method: %s, Time: %s, Status: %s",
                action, username, methodName, timestamp, status
        );
    }
}
