package util;

import ExceptionHandler.OverallListOfException;
import UserHandler.DataChecker;

import java.util.Scanner;

public class Program {
    public static int fieldsCount = 6;
    public static void run() {
        FileHandler fileEditor = new FileHandler();
        UserInputParser userInputParser = new UserInputParser();
        DataChecker validator = new DataChecker();

        Scanner userInput = new Scanner(System.in);

        System.out.println("Данная программа считает и запишет в файл введенные пользователем данные через пробел в следующем формате:");
        System.out.println("<Фамилия Имя Отчество дата_рождения номер_телефона пол>");
        System.out.println("(дата_рождения - строка формата dd.MM.yyyy,");
        System.out.println("номер_телефона - в формате 79999999999,");
        System.out.println("пол - символ латиницей f или m.)\n");
        System.out.println("Введите exit, чтобы выйти из программы.");

        while (true) {
            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
            System.out.println("Введите данные пользователя через пробел в следующем формате:");
            System.out.println("Фамилия  Имя  Отчество  дата_рождения  номер_телефона  пол");
            String[] stringToCheck = userInput.nextLine().split(" ");
            if (stringToCheck[0].equalsIgnoreCase("exit")) {
                break;
            }
            try {
                if (stringToCheck.length > fieldsCount) {
                    System.out.println("Ошибка ввода: дынных слишком много. (Возможно, лишний пробел.)");
                } else if (stringToCheck.length < fieldsCount) {
                    System.out.println("Ошибка ввода: дынных слишком мало. (Возможно, пропущен пробел.)");
                } else {
                    try {
                        validator.checkUserData(stringToCheck);
                        fileEditor.writeUserData(userInputParser.parseUserData(stringToCheck));
                    } catch (OverallListOfException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
