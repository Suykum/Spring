package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from spring container
        CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
        //call methods
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        //call our new methods to get literal values
        System.out.println(coach.getEmailAddress());
        System.out.println(coach.getTeam());
        //close context
        context.close();
    }
}
