package es.josocas;

/**
 * Created by jsoler on 20.05.15.
 */
public class PullRequest {

    private String code = "";

    public PullRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
