package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    private String[] data = {"fortune1", "fortune2", "fortune3"};
    private Random random = new Random();

    public String getFortune() {
        int index = random.nextInt(data.length);
        return data[index];
    }
}
