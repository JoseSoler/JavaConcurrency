package es.josocas;

/**
 * Created by jsoler on 20.05.15.
 */
public class MagdaReviewJob implements Runnable {

    private final PullRequest pullRequest;

    public MagdaReviewJob(PullRequest pullRequest) {
        this.pullRequest = pullRequest;
    }

    @Override
    public void run() {

        System.out.println("Magda says: Starting my code review...");

        boolean happyWithTheCode = false;

        while (!happyWithTheCode) {
            happyWithTheCode = checkCode(pullRequest.getCode());

            if (!happyWithTheCode) {
                try {
                    System.out.println("Magda says: Not happy with the code, " +
                            "I did my changes and will wait for your review.");
                    synchronized (pullRequest) {
                        pullRequest.notifyAll();
                        pullRequest.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Magda says: Now I'm happy... what a wonderful day!!");

    }

    private boolean checkCode(String code) {
        if (code.contains("RuntimeException")) {
            pullRequest.setCode(code.replace("RuntimeException", "Exception"));
            return false;
        } else {
            return true;
        }
    }


}
