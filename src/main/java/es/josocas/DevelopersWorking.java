package es.josocas;

/**
 * Created by jsoler on 18.05.15.
 */
public class DevelopersWorking {


    public static void main(String[] args) throws InterruptedException {

        BestJavaClassEver class1 = new BestJavaClassEver();
        BestJavaClassEver class2 = new BestJavaClassEver();
        BestJavaClassEver class3 = new BestJavaClassEver();

        Thread mike = new Thread(new CodingWork(class1));
        Thread magda = new Thread(new CodingWork(class2));
        Thread iryna = new Thread(new CodingWork(class3));

        mike.setName("Mike");
        magda.setName("Magda");
        iryna.setName("Iryna");

        mike.start();
        magda.start();
        iryna.start();

        mike.join();
        magda.join();
        iryna.join();

        System.out.println(class1.toString());
        System.out.println(class2.toString());
        System.out.println(class3.toString());

    }
}
