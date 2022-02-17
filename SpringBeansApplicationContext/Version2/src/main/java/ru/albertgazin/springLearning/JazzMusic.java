package ru.albertgazin.springLearning;

import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music {
    @Override
    public String getSong() {
        return "Moon river is playing";
    }

    public void initMethod() {
        System.out.println("JazzMusic's init method");
    }

    public void destroyMethod() {
        System.out.println("JazzMusic's destroy method");
    }
}
