package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class ArroundDemoApp {
    private static Logger logger = Logger.getLogger(ArroundDemoApp.class.getName());
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        String data = trafficFortuneService.getFortune(); // without exception
        logger.info(data);

        String data2 = trafficFortuneService.getFortune(true);  // with exception
        logger.info(data2);
        context.close();
    }
}
