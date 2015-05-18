package es.josocas;

/**
 * Created by jsoler on 17.05.15.
 */
public class ConcurrentSender {

    public static void main(String[] args){

        Runnable sendingWork = new Runnable() {
            @Override
            public void run() {
                System.out.println("Sending DHL Packet... such a heavy one :..-(");
                try {
                   Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread t1 = new Thread(sendingWork);
        t1.run();

        //Doing very important stuff meanwhile, cannot wait for something else...

        //Now let's check if the worker has finished
        while (t1.getState() != Thread.State.TERMINATED){
            System.out.println("Waiting for the sending work to finish...");
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
