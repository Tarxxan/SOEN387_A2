package Classes;

import java.sql.*;

import static Classes.DBConnection.conn;

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
        // move to first row
        nextID_student.next();

        p.setPersonalID(nextID_student.getInt("AUTOINC"));

        st.close();
        nextID_student.close();
        CallableStatement stmt = conn.prepareCall("{CALL createNewStudent(?,?,?,?,?,?,?,?,?,?,?,?)}");
        this.setStmt(stmt,p);
        stmt.executeUpdate();
        stmt.close();

        }

    public void createNewEmployee(Person p) throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st= conn.createStatement();
        ResultSet nextID_employee= st.executeQuery("SELECT AUTOINC FROM information_schema.INNODB_TABLESTATS where NAME = 'railway/employee';");
        // move to first row
        nextID_employee.next();

        p.setPersonalID(nextID_employee.getInt("AUTOINC"));

        st.close();
        nextID_employee.close();

            CallableStatement stmt = conn.prepareCall("{CALL createNewEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}");
            this.setStmt(stmt,p);
            stmt.executeUpdate();
        stmt.close();
        }

    private PreparedStatement setStmt(CallableStatement stmt, Person p) throws SQLException {
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

    public void updatePerson(Person p) throws SQLException {
            // Calls three procs to update
            updateNameProc(p);
            updateContactProc(p);
            updateAddressProc(p);
        }

    private void updateAddressProc(Person p) throws SQLException {
        CallableStatement stmt = conn.prepareCall("Call updateAddress(?,?,?,?,?,?,?)");
        stmt.setInt(1,p.getPersonalID());
        stmt.setString(2,p.getStreetNumber());
        stmt.setString(3,p.getAppartmentNumber());
        stmt.setString(4,p.getStreetName());
        stmt.setString(5,p.getCity());
        stmt.setString(6,p.getCountry());
        stmt.setString(7,p.getPostalCode());
        stmt.setDate(4,p.getDateOfBirth());
        stmt.executeUpdate();
    }

    private void updateContactProc(Person p) throws SQLException {
        CallableStatement stmt = conn.prepareCall("Call updateContact(?,?,?)");
        stmt.setInt(1,p.getPersonalID());
        stmt.setString(2,p.getEmail());
        stmt.setString(3,p.getPhoneNumber());
        stmt.executeUpdate();
    }

    private void updateNameProc(Person p) throws SQLException {
        CallableStatement stmt = conn.prepareCall("Call updateName(?,?,?,?)");
        stmt.setInt(1,p.getPersonalID());
        stmt.setString(2,p.getFirstName());
        stmt.setString(3,p.getLastName());
        System.out.println(p.getDateOfBirth());
        stmt.setDate(4,p.getDateOfBirth());
        stmt.executeUpdate();
        stmt.close();
    }


    public ResultSet getAllPerson() throws SQLException {
        CallableStatement stmt = conn.prepareCall("Call personPersonalInfo()");
        return stmt.executeQuery();



    }

    public void delete(Person p) throws SQLException {

        CallableStatement stmt;
        System.out.println(p.getPersonalID());
        if(p.getPersonalID()>89999999){
            stmt = conn.prepareCall("Call deleteEmployee(?)");
        }
        else{
            stmt = conn.prepareCall("Call deleteStudent(?)");
        }
        stmt.setInt(1,p.getPersonalID());
        System.out.println(p.getPersonalID());
        stmt.executeQuery();

    }
}

//    public void deleteEmp(Employee e1) throws SQLException {
//        int id= e1.getPersonalID();
//        Connection conn = DBConnection.getConnection();
//        Statement st= conn.createStatement();
//        st
//
//
//    }
