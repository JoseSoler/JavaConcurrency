package es.josocas;

/**
 * Created by jsoler on 15.05.15.
 */
public class LazyThread extends Thread {

    private Thread anotherThread;

    public LazyThread(Thread thread) {
        this.anotherThread = thread;
    }

    @Override
    public void run() {

        try {
            anotherThread.join();
            System.out.println("Sleeping for a while....");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.exit(1);
        }

        System.out.println("I'm awake !!!");

    }
}
