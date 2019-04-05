package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;
        try {
            // simulate exceptions
            accountDAO.simulateThrowing();
        } catch (Exception exc) {
            System.out.println("Catch block from main class: " + exc);
        }


        System.out.println("From AfterThrowingApp main class");
        System.out.println(accounts);

        // close the contex
        context.close();
    }
}
