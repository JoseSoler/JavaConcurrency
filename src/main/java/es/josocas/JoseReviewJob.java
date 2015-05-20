package es.josocas;

/**
 * Created by jsoler on 20.05.15.
 */
public class JoseReviewJob implements Runnable {

    private final PullRequest pullRequest;

    public JoseReviewJob(PullRequest pullRequest) {
        this.pullRequest = pullRequest;
    }

    @Override
    public void run() {

        System.out.println("Jose says: Starting my code review...");

        boolean happyWithTheCode = false;

        while (!happyWithTheCode) {
            happyWithTheCode = checkCode(pullRequest.getCode());

            if (!happyWithTheCode) {
                try {
                    System.out.println("Jose says: Not happy with the code, " +
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

        System.out.println("Jose says: Now I'm happy... what a shitty day!!");

    }

    private boolean checkCode(String code) {
        if (code.contains("Exception")) {
            pullRequest.setCode(code.replace("Exception", "RuntimeException"));
            return false;
        } else {
            return true;
        }
    }

}
