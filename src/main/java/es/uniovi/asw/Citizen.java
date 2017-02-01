package es.uniovi.asw;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by jorge on 01/02/2017.
 */
public class Citizen {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String email;
    public Date dateOfBirth;
    public String address;
    public String nationality;
    public String idNumber;

    public Citizen() {

    }

    public Citizen(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
