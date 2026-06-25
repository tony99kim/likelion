package org.example.aopexam.afteraop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Before("execution(* org.example.aopexam.afteraop.*Dao.*(..))")
    public void logging(){
        System.out.println("로그를 남깁니다");
    }
}
