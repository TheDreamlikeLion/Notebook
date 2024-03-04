package ExceptionHandler;

public class GeneralException extends Exception {
    String inputString;

    public GeneralException (String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return ("Ошибка ввода: дынные должны вводиться в следующем формате:\n" + "<Фамилия Имя Отчество дата_рождения номер_телефона пол>\nВы ввели:\n" + inputString);
    }
}
