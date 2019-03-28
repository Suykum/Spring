package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
    //field injection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // constructor injection
    /* @Autowired
     public TennisCoach(FortuneService fortuneService) {
         this.fortuneService = fortuneService;
     }*/
    public TennisCoach() {
        System.out.println(">>TennisCoach: inside default constructor");
    }

    // setter injection
    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">>TennisCoach: inside setFortuneService method");
        this.fortuneService = fortuneService;
    }*/

    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside of doMyStartupStuff");
    }

    // define destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
    }
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
