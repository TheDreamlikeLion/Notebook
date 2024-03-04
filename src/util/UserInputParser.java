package util;

import ExceptionHandler.BadGenderException;
import UserHandler.Gender;
import UserHandler.UserData;
import java.text.ParseException;

import static UserHandler.Gender.f;
import static UserHandler.Gender.m;

public class UserInputParser {
    public UserData parseUserData(String[] data) throws ParseException {
        UserData userData = new UserData();
        userData.setLastName(data[0]);
        userData.setFirstName(data[1]);
        userData.setMiddleName(data[2]);
        userData.setDateOfBirth(data[3]);
        userData.setPhoneNumber(Long.parseLong(data[4]));
        if (data[5].equalsIgnoreCase("m")) {
            userData.setGender(m);
        } else if (data[5].equalsIgnoreCase("f")) {
            userData.setGender(f);
        }
        return userData;
    }
}
