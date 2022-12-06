package Classes;

import java.sql.Date;

public class Employee extends Person {
    public Employee() {
        super();
    }


    public Employee(String setPassword, String firstName, String setLastName, String setEmail, String setPhoneNumber, Date setDateOfBirth, String setStreetName, String setAptNumber, String setCountry, String setPostalCode, String setCity, String setStreetNumber, boolean b) {
        super(setPassword,firstName,setLastName,setEmail,setPhoneNumber,setDateOfBirth,setStreetName,setAptNumber,setCountry,setPostalCode,setCity,setStreetNumber,false);
    }
}
