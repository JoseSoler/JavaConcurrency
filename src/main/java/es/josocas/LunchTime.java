package es.josocas;


public class LunchTime
{
    public static void main( String[] args )  {

        //Sadly we have to share tools to eat today
        Object plate = new Object();
        Object fork = new Object();
        Object knife = new Object();

        Thread sven = new Thread(new SvenEater(plate, fork, knife));
        Thread mike = new Thread(new JoseEater(plate, fork, knife));
        Thread jose = new Thread(new MikeEater(plate, fork, knife));

        //start eating.. of course
        sven.start();
        mike.start();
        jose.start();

    }
}
