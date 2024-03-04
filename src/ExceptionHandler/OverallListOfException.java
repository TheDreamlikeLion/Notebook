package  ExceptionHandler;

public class OverallListOfException extends Exception {
    String message;

    public OverallListOfException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
