package es.josocas;

/**
 * Created by jsoler on 18.05.15.
 */
public class BestJavaClassEver {

    private String code = "";
    private Integer lineNumber = 0;

    public  String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer giveMeNewLine(){
        return ++lineNumber;
    }

    @Override
    public String toString() {
        return "BestJavaClassEver{" +
                "code='" + code + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
