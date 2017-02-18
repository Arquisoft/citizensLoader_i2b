package main.asw.user;

import main.asw.encryption.EncryptionUtils;

import java.util.Date;

/**
 * Created by nicolas on 3/02/17.
 * @author nicolas
 * @author MIGUEL
 */
public class User {

    String firstName, lastName, email, address, nationality, nif;
    Date dateOfBirth;
    String password;
    private String unencryptedPass;   //For (TODO) letter generation. Not stored on DB.


    public User(String firstName, String lastName, String email, Date dateOfBirth, String address, String nationality, String nif) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.nationality = nationality;
        this.nif = nif;

        this.unencryptedPass = EncryptionUtils.getInstance().generatePassword();
        this.password = EncryptionUtils.getInstance().encryptPassword(unencryptedPass);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nif='" + nif + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public String getUnencryptedPass() {
        return unencryptedPass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNationality() {
        return nationality;
    }

    public String getNif() {
        return nif;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword() {
        return password;
    }
}
