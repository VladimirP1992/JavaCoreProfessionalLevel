package ru.geekbrains.JCoreProfLvl.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private boolean readyForRace;
    private CyclicBarrier rivalsAtStart;
    private CountDownLatch rivalsAtFinish;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public boolean isReadyForRace(){
        return readyForRace;
    }

    public Car(Race race, int speed, CyclicBarrier rivalsAtStart, CountDownLatch rivalsAtFinish) {
        readyForRace = false;
        this.race = race;
        this.speed = speed;
        this.rivalsAtStart = rivalsAtStart;
        this.rivalsAtFinish = rivalsAtFinish;

        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            readyForRace = true;
            rivalsAtStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        rivalsAtFinish.countDown();
    }
}