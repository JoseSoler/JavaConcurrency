package es.josocas;

/**
 * Created by jsoler on 20.05.15.
 */
public class MikeEater implements Runnable {

    private final Object plate;
    private final Object fork;
    private final Object knife;

    public MikeEater(Object plate, Object fork, Object knife) {
        this.fork = fork;
        this.knife = knife;
        this.plate = plate;
    }


    @Override
    public void run() {
        System.out.println("Mike says: Staring to eat");
        System.out.println("Mike says: Getting the knife");
        synchronized (knife) {
            lookAroundInTheCampus();
            System.out.println("Mike says: Getting the fork");
            synchronized (fork) {
                lookAroundInTheCampus();
                System.out.println("Mike says: Getting the plate");
                synchronized (plate) {
                    System.out.println("Mike says: I'm full, such a tasty salad !!");
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
