package  ExceptionHandler;

public class BadFIOException extends Exception {

    String inputString;

    public BadFIOException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка при вводе ФИО: '" + inputString + "'. (Должны содержаться только буквы.)\n";
    }
}