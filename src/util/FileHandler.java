package util;

import UserHandler.UserData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    public static void writeUserData(UserData userData) {
        String fileName = userData.getLastName();
        String stringToWrite = userData.toString();
        String textFromFile = "";
        if (Files.exists(Path.of(fileName + ".txt"))) {
            textFromFile = readFile(fileName);

            if (!textFromFile.contains(stringToWrite)) {
                StringBuilder str = new StringBuilder();
                str.append(textFromFile + "\n");
                str.append(stringToWrite);
                writeFile(fileName, str.toString());
            } else {
                System.out.println("Файл уже содержит эти данные.");
            }
        } else {
            writeFile(fileName, stringToWrite);
        }
    }

    public static String readFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName + ".txt")) {
            StringBuilder str = new StringBuilder();
            BufferedReader stringReader = new BufferedReader(fileReader);
            String line = stringReader.readLine();
            while (line != null) {
                str.append(line);
                str.append("");
                line = stringReader.readLine();
            }
            fileReader.close();
            return str.toString();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла " + e);
        }
    }

    public static void writeFile(String fileName, String stringToWrite) {
        try (FileWriter writer = new FileWriter(fileName + ".txt")) {
            writer.write(stringToWrite + "\n");
            System.out.println("Данные добавлены в файл с именем " + fileName + ".txt");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла" + e);
        }
    }
}