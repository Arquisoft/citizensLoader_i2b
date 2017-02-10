package main.asw.user;

import java.util.Date;

/**
 * Created by nicolas on 3/02/17.
 */
public class User {

    String name, surname, email, address, nationality, dni;
    Date date;

    public User(String name, String surname, String email, Date date, String address, String nationality, String dni) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.date = date;
        this.address = address;
        this.nationality = nationality;
        this.dni = dni;
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
}
