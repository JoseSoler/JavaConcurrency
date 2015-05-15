package es.josocas;

/**
 * Created by jsoler on 15.05.15.
 */
public class WaitingQueue {

    public static void main(String[] args) throws InterruptedException {

        WaitingQueue wq = new WaitingQueue();

        Thread t1 = new Thread(new WaitingThread(wq));
        Thread t2 = new Thread(new WaitingThread(wq));
        Thread t3 = new Thread(new WaitingThread(wq));
        Thread t4 = new Thread(new WaitingThread(wq));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        synchronized (wq) {
            wq.notifyAll();
        }


    }
}
