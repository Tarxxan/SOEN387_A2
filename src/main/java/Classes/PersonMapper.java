package Classes;

import java.sql.*;

public class PersonMapper {


    public ResultSet validateStudentLogin(Person person) throws SQLException {
        String query="{CALL validateStudentLogin(?,?)}";
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall(query);
        stmt.setInt(1,person.getPersonalID());
        stmt.setString(2, person.getPassword());

        return stmt.executeQuery();
    }

    public ResultSet validateEmployeeLogin(Person person) throws SQLException {
        String query="{CALL validateEmployeeLogin(?,?)}";
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall(query);
        stmt.setInt(1,person.getPersonalID());
        stmt.setString(2, person.getPassword());

        return stmt.executeQuery();
    }



    public void createNewStudent(Person p) throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st= conn.createStatement();
        ResultSet nextID_student= st.executeQuery("SELECT AUTOINC FROM information_schema.INNODB_TABLESTATS where NAME = 'railway/student';");
        p.setPersonalID(nextID_student.getInt("AUTOINC"));
        st.close();
        nextID_student.close();

        PreparedStatement stmt = conn.prepareStatement("{CALL createNewStudent(?,?,?,?,?,?,?,?,?,?,?,?)}");
        stmt=this.setStmt(stmt,p);
        stmt.executeUpdate();
        stmt.close();

        }

    public void createNewEmployee(Person p) throws SQLException {
            Connection conn = DBConnection.getConnection();
        Statement st= conn.createStatement();
        ResultSet nextID_employee= st.executeQuery("SELECT AUTOINC FROM information_schema.INNODB_TABLESTATS where NAME = 'railway/employee';");
        p.setPersonalID(nextID_employee.getInt("AUTOINC"));
        st.close();
        nextID_employee.close();

            PreparedStatement stmt = conn.prepareStatement("{CALL createNewEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}");
            stmt=this.setStmt(stmt,p);
            stmt.executeUpdate();
        stmt.close();
        }

    private PreparedStatement setStmt(PreparedStatement stmt, Person p) throws SQLException {
        stmt.setString(1,p.getFirstName());
        stmt.setString(2,p.getLastName());
         stmt.setDate(3,p.getDateOfBirth());
        stmt.setString(4,p.getEmail());
        stmt.setString(5,p.getPhoneNumber());
        stmt.setString(6,p.getStreetNumber());
        stmt.setString(7,p.getAppartmentNumber());
        stmt.setString(8,p.getStreetName());
        stmt.setString(9,p.getCity());
        stmt.setString(10,p.getCountry());
        stmt.setString(11,p.getPostalCode());
        stmt.setString(12,p.getPassword() );

        return stmt;
    }
}