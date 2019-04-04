package com.luv2code.aopdemo.aspect;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//UNORDERED ASPECT
//@Aspect
//@Component
public class MyDemoLogingAspect {
    // matches all method in package
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    // pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // pointcut include package and exclude getter and setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====> Performing API analytics");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n=====> Logging to Cloud");
    }

    // this is where we add all of our related advices for logging
    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") // match specific class
    //@Before("execution(public void addAccount())") // match all addAccount from any class
    //@Before("execution( * add*())") // match all method from any class starting with add with any return type

    /*@Before("execution(public void add*())") // match all method from any class starting with add
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Executing @Before advice on addAccount without parameter");
    }*/

    //@Before("execution(public void add*(..))") // match all method from any class starting with add with 0 to many parameters
    //@Before("execution(public void add*(com.luv2code.aopdemo.Account, ..))") // match all method from any class starting with
    // add with starting parameter Account and following 0 to many parameters
    // @Before("execution(* com.luv2code.aopdemo.doa.*.*(..))") // matches with any return type, any class,
    // any method with any parameter of doa package

    /*@Before("execution(public void add*(com.luv2code.aopdemo.Account))") // match all method from any class starting with
    // add and Account parameter
    public void beforeAddAccountAdvicewithParam() {
        System.out.println("\n======>>> Executing @Before advice on addAccount with Account parameter");
    }*/


}
