package ru.albertgazin.springLearning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.albertgazin.springLearning")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

}
