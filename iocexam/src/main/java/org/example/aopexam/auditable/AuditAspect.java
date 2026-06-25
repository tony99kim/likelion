package org.example.aopexam.auditable;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class AuditAspect {

    private static final Logger log = LoggerFactory.getLogger(AuditAspect.class);

    @Around("@annotation(auditable)")
    public Object audit(ProceedingJoinPoint joinPoint, Auditable auditable)
            throws Throwable {

        // 감사 로그 생성
        String action = auditable.action();
        String username = UserContext.getCurrentUser() != null ?
                UserContext.getCurrentUser().getUsername() : "Anonymous";
        String methodName = joinPoint.getSignature().getName();

        AuditLog auditLog = new AuditLog(action, username, methodName);
        auditLog.setArguments(joinPoint.getArgs());

        // 실행 전 로깅
        log.info("[AUDIT-START] Action: {}, User: {}, Method: {}, Args: {}",
                action, username, methodName, Arrays.toString(joinPoint.getArgs()));

        try {
            // 대상 메서드 실행
            Object result = joinPoint.proceed();

            // 성공 로깅
            auditLog.setResult(result);
            auditLog.setStatus("SUCCESS");

            log.info("[AUDIT-SUCCESS] {}, Result: {}",
                    auditLog.toString(), result);

            return result;

        } catch (Exception e) {
            // 실패 로깅
            auditLog.setStatus("FAILED");
            auditLog.setErrorMessage(e.getMessage());

            log.error("[AUDIT-FAILED] {}, Error: {}",
                    auditLog.toString(), e.getMessage());

            throw e;
        }
    }
}
