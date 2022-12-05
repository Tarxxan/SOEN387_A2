package Classes;

import java.sql.Date;

public class Student extends Person{


    public Student(){
        super();
    }
    public Student(String password, String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth, String streetName, String appartmentNumber, String country, String postalCode, String city, String streetNumber) {
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfBirth(dateOfBirth);
        this.setStreetName(streetName);
        this.setAppartmentNumber(appartmentNumber);
        this.setCountry(country);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setStreetNumber(streetNumber);
        this.isStudent = super.getIsStudent();
    }
}
