package Classes;

import java.sql.*;

public class CoursesMapper {
    private static Connection conn;
    private final String insertSQL = "call createNewCourse(?,?,?,?,?,?,?,?,?);";
    //ignores empty and null parameters, requires course id
    private final String updateSQL = "call updateCourse(?,?,?,?,?,?,?,?,?,?);";
    private final String deleteSQL = "call deleteCourse(?);";
    public CoursesMapper() {
        if(conn==null)
            conn=DBConnection.getConnection();
    }

    public void addClass(Courses c) throws SQLException {
     //will ignore if already exist
        CallableStatement stmt = conn.prepareCall(insertSQL);
        this.setStmt(stmt,c);
        stmt.executeUpdate();

    }

    private PreparedStatement setStmt(CallableStatement stmt, Courses c) throws SQLException {

        stmt.setString(1,c.getCourseCode());
        stmt.setString(2,c.getTitle());
        stmt.setString(3,c.getSemester());
        stmt.setString(4,c.getDays());
        stmt.setString(5,c.getTime());
        stmt.setString(6,c.getInstructor());
        stmt.setString(7,c.getClassroom());
        stmt.setDate(8,c.getStartDate());
        stmt.setDate(9,c.getEndDate());

        return stmt;
    }

    public void delete(Courses course) throws SQLException {
        CallableStatement stmt = conn.prepareCall(deleteSQL);
        stmt.setInt(1,course.getPkid());
        //this.setStmt(stmt,course);
        // Should Work
        System.out.println("Should Work");
        stmt.executeUpdate();
        }
        

    public ResultSet getAllCourses() throws SQLException {
        String Courses="select * from courses;";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(Courses);
    }

    public void updateCourse(Courses c) throws SQLException {

        CallableStatement stmt = conn.prepareCall(updateSQL);
        this.setStmtUpdate(stmt,c);
        stmt.executeUpdate();
    }

    public PreparedStatement setStmtUpdate(CallableStatement stmt,Courses c) throws SQLException {
        stmt.setInt(1,c.getPkid());
        stmt.setString(2,c.getCourseCode());
        stmt.setString(3,c.getTitle());
        stmt.setString(4,c.getSemester());
        stmt.setString(5,c.getDays());
        stmt.setString(6,c.getTime());
        stmt.setString(7,c.getInstructor());
        stmt.setString(8,c.getClassroom());
        stmt.setDate(9,c.getStartDate());
        stmt.setDate(10,c.getEndDate());
        return stmt;
    }

}