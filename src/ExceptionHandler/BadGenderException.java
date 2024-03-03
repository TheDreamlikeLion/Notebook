package  ExceptionHandler;

public class BadGenderException extends Exception {
    String inputString;

    public BadGenderException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка при вводе пола: '" + inputString + "' (Формат ввода: латинские буквы f или m.)\n";
    }
}

