package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        //get the bean from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);
        //call the method
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        // close context
        context.close();
    }
}
