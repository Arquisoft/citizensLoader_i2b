package main.asw.user;

import main.asw.encryption.EncryptionUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * Created by nicolas on 3/02/17.
 * @author nicolas
 * @author MIGUEL
 */
public class User {

    @Id String id;
    String name, surname, email, address, nationality, dni;
    Date date;
    String password;
    @Transient private String unencryptedPass;   //For (TODO) letter generation. Not stored on DB.


    public User(String name, String surname, String email, Date date, String address, String nationality, String dni) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.date = date;
        this.address = address;
        this.nationality = nationality;
        this.dni = dni;

        this.unencryptedPass = EncryptionUtils.getInstance().generatePassword();
        this.password = EncryptionUtils.getInstance().encryptPassword(unencryptedPass);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    public String getDni() {
        return dni;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dni='" + dni + '\'' +
                ", date=" + date +
                '}';
    }

    public String getUnencryptedPass(){
        return unencryptedPass;
    }
}
