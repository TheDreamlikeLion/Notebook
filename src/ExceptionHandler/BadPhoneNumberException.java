package  ExceptionHandler;

public class BadPhoneNumberException extends Exception {
    String inputString;

    public BadPhoneNumberException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка ввода телефонного номера: " + inputString + ". (Формат ввода - 11 цифр без разделителей. Например, 89991112233.)\n";
    }
}
