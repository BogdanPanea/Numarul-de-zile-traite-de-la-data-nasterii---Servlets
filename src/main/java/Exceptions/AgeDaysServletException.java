package Exceptions;

public class AgeDaysServletException extends Exception {

    private String errCode;

    public AgeDaysServletException(String message, String errCode) {

        super(message);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }
}
