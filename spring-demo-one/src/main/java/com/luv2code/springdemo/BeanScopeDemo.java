package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);
        Coach alpahaCoach = context.getBean("myCoach", Coach.class);
        System.out.println(coach==alpahaCoach);
        System.out.println(coach);
        System.out.println(alpahaCoach);
        context.close();
    }
}
