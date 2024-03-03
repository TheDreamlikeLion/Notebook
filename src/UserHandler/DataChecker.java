package UserHandler;

import ExceptionHandler.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataChecker {
    public static int fieldsCount = 6;

    private String firstName;
    private String lastName;
    private String patronymicName;
    private LocalDate birthDate;
    private Long phoneNumber;
    private Gender gender;

    public DataChecker() {
    }

    public void checkUserData(String[] stringToCheck) throws ParsingDataStringException {
        if (stringToCheck == null) {
            throw new NullPointerException("Пустой ввод.");
        }

        StringBuilder errorInfo = new StringBuilder();
        for (String string : stringToCheck) {
            if (Character.isLetter(string.charAt(0))) {
                if (string.length() == 1) {
                    if (this.gender == null) {
                        try {
                            this.gender = checkGender(string);
                        } catch (BadGenderException e) {
                            errorInfo.append(e.getMessage());
                        }
                    }
                } else {
                    if (this.lastName == null) {
                        try {
                            this.lastName = checkFIO(string);
                        } catch (BadFIOException e) {
                            errorInfo.append(e.getMessage());
                        }
                    } else if (this.firstName == null) {
                        try {
                            this.firstName = checkFIO(string);
                        } catch (BadFIOException e) {
                            errorInfo.append(e.getMessage());
                        }
                    } else if (this.patronymicName == null) {
                        try {
                            this.patronymicName = checkFIO(string);
                        } catch (BadFIOException e) {
                            errorInfo.append(e.getMessage());
                        }
                    }
                }
            } else {
                if (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.birthDate == null) {
                        try {
                            this.birthDate = checkBirthDate(string);
                        } catch (BadBirthDateException e) {
                            errorInfo.append(e.getMessage());
                        }
                    }
                } else {
                    if (this.phoneNumber == null) {
                        try {
                            this.phoneNumber = checkPhoneNumber(string);
                        } catch (BadPhoneNumberException e) {
                            errorInfo.append(e.getMessage());
                        }
                    }
                }

            }
        }
        if (!errorInfo.isEmpty()) {
            throw new ParsingDataStringException(errorInfo.toString());
        }
    }

    public String getLastName() {
        return lastName;
    }

    private String checkFIO(String stringToCheck) throws BadFIOException {
        if (stringToCheck.toLowerCase().matches("^[a-zа-яё]*$")) {
            return stringToCheck;
        } else {
            throw new BadFIOException(stringToCheck);
        }
    }

    private long checkPhoneNumber(String stringToCheck) throws BadPhoneNumberException {
        if (stringToCheck.length() == 11) {
            try {
                return Long.parseLong(stringToCheck);
            } catch (NumberFormatException e) {
                throw new BadPhoneNumberException(stringToCheck);
            }
        } else {
            throw new BadPhoneNumberException(stringToCheck);
        }
    }

    private Gender checkGender(String stringToCheck) throws BadGenderException {
        try {
            return Gender.valueOf(stringToCheck);
        } catch (IllegalArgumentException e) {
            throw new BadGenderException(stringToCheck);
        }
    }

    private LocalDate checkBirthDate(String stringToCheck) throws BadBirthDateException {
        try {
            return LocalDate.parse(stringToCheck,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new BadBirthDateException(stringToCheck);
        }
    }

//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        str.append("<").append(lastName).append(">")
//                .append("<").append(firstName).append(">")
//                .append("<").append(patronymicName).append(">")
//                .append("<").append(birthDate.toString()).append(">")
//                .append("<").append(phoneNumber).append(">")
//                .append("<").append(gender).append(">");
//        return str.toString();
//    }

}
