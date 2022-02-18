package ru.albertgazin.springLearning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        player.playMusic();
        System.out.println(player.getName());
        System.out.println(player.getVolume());

        context.close();
    }
}
