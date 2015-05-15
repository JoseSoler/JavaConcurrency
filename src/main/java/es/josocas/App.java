package es.josocas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        Thread t1 = new LazyThread(Thread.currentThread());
        t1.start();

        t1.join();

        System.out.println( "Bye World!" );
    }
}
