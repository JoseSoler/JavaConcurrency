package es.josocas;

import java.util.Objects;

/**
 * Created by jsoler on 20.05.15.
 */
public class SvenEater implements Runnable {

    private final Object plate;
    private final Object fork;
    private final Object knife;

    public SvenEater(Object plate, Object fork, Object knife) {
        this.fork = fork;
        this.knife = knife;
        this.plate = plate;
    }


    @Override
    public void run() {
        System.out.println("Sven says: Staring to eat");
        System.out.println("Sven says: Getting the plate");
        synchronized (plate) {
            System.out.println("Sven says: Getting the fork");
            synchronized (fork) {
                lookAroundInTheCampus();
                System.out.println("Sven says: Getting the knife");
                synchronized (knife) {
                    lookAroundInTheCampus();
                    System.out.println("Sven says: I'm full, such a tasty boiled potatoes!!");
                }
            }
        }
    }

    private void lookAroundInTheCampus() {
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
