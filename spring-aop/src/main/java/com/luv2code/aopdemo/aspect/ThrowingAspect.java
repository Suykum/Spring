package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ThrowingAspect {
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.simulateThrowing(..))",
            throwing= "exc"
    )
    public void afterThrowingExceptionAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterThrowing method: " + method);
        System.out.println("\n=====> The exception is: " + exc);
    }
}
