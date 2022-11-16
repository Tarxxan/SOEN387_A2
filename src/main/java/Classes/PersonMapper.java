package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper {


    // ADD extra when we know what db looks like/ View
private final String insertSQL ="INSERT INTO railway.person(personalID,firstName,lastName,email,phoneNumber,dateOfBirth,streetName,streetNumber,city,country,postalCode)" +
        "        VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    // Update and delete could be implemented but dont need to be done right now


    public ResultSet findById(Person person) throws SQLException {
        String query;
        Connection conn = DBConnection.getConnection();
        // Change to the student view
        if (person.getIsStudent()){
            query="SELECT * FROM railway.person where personalID=?";
        }
        //change to the admin view
        else
        {
            query="SELECT * FROM railway.person where personalID=?";
        }

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,person.getPersonalID());

        ResultSet rs= stmt.executeQuery();

        return rs;}

    public void createNewStudent(Person p) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(insertSQL);
        stmt=this.setStmt(stmt,p);
        stmt.executeUpdate();

        }

    public void createNewEmployee(Person p) throws SQLException {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt=this.setStmt(stmt,p);
            stmt.executeUpdate();
        }

    private PreparedStatement setStmt(PreparedStatement stmt, Person p) throws SQLException {
        stmt.setInt(1,p.getPersonalID());
        stmt.setString(2,p.getFirstName());
        stmt.setString(3,p.getLastName());
        stmt.setString(4,p.getEmail());
        stmt.setString(5,p.getPhoneNumber());
        stmt.setDate(6,p.getDateOfBirth());
        stmt.setString(7,p.getStreetName());
        stmt.setInt(8,p.getStreetNumber());
        stmt.setString(9,p.getCity());
        stmt.setString(10,p.getCountry());
        stmt.setString(11,p.getPostalCode());

        return stmt;
    }
}
