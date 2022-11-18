package Classes;

import java.math.BigDecimal;
import java.sql.Date;

public class Person {

    private String password;
    private boolean isStudent;
    private BigDecimal personalID;
    private String firstName;
    private String lastName;
    private String appartmentNumber;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private String streetName;
    private String country;
    private String postalCode;
    private String city;
    private String streetNumber;

    // add apt number
    public Person(String password, String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth, String streetName, String appartmentNumber, String country, String postalCode, String city, String streetNumber,  boolean isStudent) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.streetName = streetName;
        this.appartmentNumber = appartmentNumber;
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.streetNumber = streetNumber;
        this.isStudent = isStudent;
    }

    public Person() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(String appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public BigDecimal getPersonalID() {
        return personalID;
    }

    public void setPersonalID(BigDecimal personalID) {
        this.personalID = personalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public boolean getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }
}