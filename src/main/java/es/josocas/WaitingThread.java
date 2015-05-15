package es.josocas;

/**
 * Created by jsoler on 15.05.15.
 */
public class WaitingThread implements Runnable {

    private final Object lock;

    public WaitingThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        System.out.println("Thread: " + Thread.currentThread().getName() + " going to acquire lock and wait.");

        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread: " + Thread.currentThread().getName() + " finished waiting.");

    }
}
