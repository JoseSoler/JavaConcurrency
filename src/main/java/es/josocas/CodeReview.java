package es.josocas;

/**
 * Created by jsoler on 20.05.15.
 */
public class CodeReview {


    public static void main(String[] args) {

        PullRequest pullRequest = new PullRequest("RuntimeException");

        Thread magdaReviewing = new Thread(new MagdaReviewJob(pullRequest));
        Thread joseReviewing  = new Thread(new JoseReviewJob(pullRequest));

        magdaReviewing.start();
        joseReviewing.start();


    }



}

