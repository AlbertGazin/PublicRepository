package ru.albertgazin.springLearning;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
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

    @PostConstruct
    public void initMethod() {
        System.out.println("ClassicalMusic's init method");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("ClassicalMusic's destroy method");
    }

    @Override
    public String getSong() {
        return "Vivaldi is playing";
    }
}
