package ru.albertgazin.springLearning;

public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind of change is playing";
    }

    public void initMethod() {
        System.out.println("RockMusic's init method");
    }

    public void destroyMethod() {
        System.out.println("RockMusic's destroy method");
    }
}
