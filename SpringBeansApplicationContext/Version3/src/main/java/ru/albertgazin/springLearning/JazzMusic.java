package ru.albertgazin.springLearning;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class JazzMusic implements Music {
    @Override
    public String getSong() {
        return "Moon river is playing";
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("JazzMusic's init method");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("JazzMusic's destroy method");
    }
}
