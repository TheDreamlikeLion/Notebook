package util;

import ExceptionHandler.BadGenderException;
import UserHandler.Gender;
import UserHandler.UserData;

import java.time.LocalDate;

import static UserHandler.Gender.FEMALE;
import static UserHandler.Gender.MALE;

public class UserInputParser {
    public UserData parseUserData(String[] data) {
        UserData userData = new UserData();
        userData.setLastName(data[0]);
        userData.setFirstName(data[1]);
        userData.setMiddleName(data[2]);
        userData.setDateOfBirth(LocalDate.parse(data[3]));
        userData.setPhoneNumber(Long.parseLong(data[4]));
        if (data[5].equalsIgnoreCase("m")) {
            userData.setGender(MALE);
        } else if (data[5].equalsIgnoreCase("f")) {
            userData.setGender(FEMALE);
        }
        return userData;
    }
}
