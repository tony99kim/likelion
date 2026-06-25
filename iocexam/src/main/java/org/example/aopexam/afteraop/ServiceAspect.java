package org.example.aopexam.afteraop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ServiceAspect {
    @Pointcut("execution(* org.example..SimpleService.*())")
    public void pc(){}

    @Pointcut("execution(String org.example..SimpleService.*())")
    public void pc2(){}

    @Pointcut("execution(* org.example..SimpleService.hello())")
    public void helloPc(){}

    @Before("pc()")
    public void before(JoinPoint joinPoint){
        System.out.println("Before 메서드가 실행되기 전에 실행되는 advice"+" "+joinPoint.getSignature().getName());
    }

    @After("helloPc()")
    public void after(JoinPoint joinPoint){
        System.out.println("After 메서드가 실행된 후에 실행되는 advice"+" "+joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut ="pc2()", returning ="result")
    public void afterReturning(String result){
        System.out.println("AfterReturning 메서드가 실행된 후에 실행되는 advice");
        System.out.println("Return value : "+result);
    }

    @AfterThrowing(pointcut ="pc()",throwing ="ex")
    public void afterThrowing(Exception ex){
        System.out.println("AfterThrowing 메서드가 예외가 발생한 후에 실행되는 advice");
        System.out.println("Exception message : "+ex.getMessage());
    }

    @Around("pc2()")
    public String around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("Around 메서드가 실행되기 전에 실행되는 advice"+pjp.getSignature().getName());
        String result = (String) pjp.proceed();

        result += "around";
        return result;
    }
}
