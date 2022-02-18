package ru.albertgazin.springLearning;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind of change is playing";
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("RockMusic's init method");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("RockMusic's destroy method");
    }
}
