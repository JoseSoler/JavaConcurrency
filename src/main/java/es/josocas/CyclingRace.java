package es.josocas;

/**
 * Created by jsoler on 17.05.15.
 */
public class CyclingRace {

    public static void main(String[] args) {

        Runnable giroItalia = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " says:  Starting the Race....");

                for (int km = 0; km < 3000; km++) {
                    try {
                        Thread.currentThread().sleep(10); //I'm sorry guys, you can only sleep 10 millis..
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " says:  I've just finished the Race, Mama mia !!");
            }
        };


        Thread contador = new Thread(giroItalia);
        Thread aru = new Thread(giroItalia);
        Thread uran = new Thread(giroItalia);

        contador.setName("Alberto Contador");
        aru.setName("Fabio Aru");
        uran.setName("Rigoberto Uran");

        contador.start();
        aru.start();
        uran.start();

    }
}
