package UserHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class UserData {

    private String lastName;
    private String firstName;
    private String middleName;
    private DateFormat dateOfBirth;
    private long phoneNumber;
    private Gender gender;

    public UserData(String lastName, String firstName, String middleName, DateFormat dateOfBirth,
                    long phoneNumber, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public UserData() {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public DateFormat getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateFormat dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("<").append(lastName).append("> ")
                .append("<").append(firstName).append("> ")
                .append("<").append(middleName).append("> ")
                .append("<").append(dateOfBirth.toString()).append("> ")
                .append("<").append(phoneNumber).append("> ")
                .append("<").append(gender).append(">");
        return str.toString();
    }
}
