package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))") // match any class and any method
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))") // match any class and any method
    private void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))") // match any class and any method
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> @Before calling method: " + method);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            logger.info("====> argument: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> @AfterReturning from method: " + method);

        logger.info("====>> result: " + result);
    }

}
