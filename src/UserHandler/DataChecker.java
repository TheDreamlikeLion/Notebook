package UserHandler;

import ExceptionHandler.*;

public class DataChecker {
    public static int fieldsCount = 6;

    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private Long phoneNumber;
    private Gender gender;

    public DataChecker() {
    }

    public void checkUserData(String[] stringToCheck) throws OverallListOfException, GeneralException {
//        if (stringToCheck == null) {
//            System.out.println(stringToCheck.toString());
//            throw new GeneralException(stringToCheck.toString());
//        }

        StringBuilder errorList = new StringBuilder();

        if (this.lastName == null) {
            try {
                this.lastName = checkFIO(stringToCheck[0]);
            } catch (BadFIOException e) {
                errorList.append(e.getMessage());
            }
        }

        if (this.firstName == null) {
            try {
                this.firstName = checkFIO(stringToCheck[1]);
            } catch (BadFIOException e) {
                errorList.append(e.getMessage());
            }
        }

        if (this.middleName == null) {
            try {
                this.middleName = checkFIO(stringToCheck[2]);
            } catch (BadFIOException e) {
                errorList.append(e.getMessage());
            }
        }

        if (this.birthDate == null) {
            try {
                this.birthDate = checkBirthDate(stringToCheck[3]);
            } catch (BadBirthDateException e) {
                errorList.append(e.getMessage());
            }
        }

        if (this.phoneNumber == null) {
            try {
                this.phoneNumber = checkPhoneNumber(stringToCheck[4]);
            } catch (BadPhoneNumberException e) {
                errorList.append(e.getMessage());
            }
        }

        if (this.gender == null) {
            try {
                this.gender = checkGender(stringToCheck[5]);
            } catch (BadGenderException e) {
                errorList.append(e.getMessage());
            }
        }

        if (!errorList.isEmpty()) {
            throw new OverallListOfException(errorList.toString());
        }
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

    private String checkBirthDate(String stringToCheck) throws BadBirthDateException {
        if (stringToCheck.matches("(0[1-9]|[1-2][0-9]|3[01])\\.(0[1-9]|1[1-2])\\.(19[0-9][0-9]|20[0-2][0-4])")) {
            return stringToCheck;
        } else {
            throw new BadBirthDateException(stringToCheck);
        }
    }
}
