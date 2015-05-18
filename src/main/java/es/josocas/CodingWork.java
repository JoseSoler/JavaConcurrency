package es.josocas;

/**
 * Created by jsoler on 18.05.15.
 */
public class CodingWork implements Runnable {

    private final BestJavaClassEver bestJavaClassEver;

    public CodingWork(BestJavaClassEver bestJavaClassEver) {
        this.bestJavaClassEver = bestJavaClassEver;
    }

    @Override
    public void run() {

        //Thinking hard....
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String newLineOfCode = Thread.currentThread().getName() + " wrote line of code "
                + bestJavaClassEver.giveMeNewLine() + ", ";
        bestJavaClassEver.setCode(bestJavaClassEver.getCode() + newLineOfCode);

        //Thinking hard....
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        newLineOfCode = Thread.currentThread().getName() + " wrote line of code "
                + bestJavaClassEver.giveMeNewLine() + ", ";
        bestJavaClassEver.setCode(bestJavaClassEver.getCode() + newLineOfCode);

    }
}
