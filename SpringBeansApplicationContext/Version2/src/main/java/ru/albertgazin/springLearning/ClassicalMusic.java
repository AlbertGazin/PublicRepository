package ru.albertgazin.springLearning;

import org.springframework.stereotype.Component;

public class ClassicalMusic implements Music {
    private static ClassicalMusic classicalMusic;

    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        if(classicalMusic == null) {
            return new ClassicalMusic();
        } else {
            return classicalMusic;
        }
    }

    public void initMethod() {
        System.out.println("ClassicalMusic's init method");
    }

    public void destroyMethod() {
        System.out.println("ClassicalMusic's destroy method");
    }

    @Override
    public String getSong() {
        return "Vivaldi is playing";
    }
}
