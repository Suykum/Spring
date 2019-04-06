package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AroundAspect {
    private static Logger logger = Logger.getLogger(AroundAspect.class.getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @Around on method: " + method);

        // get begin time
        long begin = System.currentTimeMillis();

        // execute method
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc) {
            logger.warning(exc.getMessage());

            // handling exception, the main class would'n be know about exception
            result = "Exception happen, but dont worry";

            // if we need rethrow exception than use following line:
            // throw exc;
        }

        // get end time
        long end = System.currentTimeMillis();

        long duration = end - begin;
        logger.info("\n======> Duration: " + duration/1000.0 + " seconds");
        return result;
    }

}
