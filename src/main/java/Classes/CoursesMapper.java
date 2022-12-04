package Classes;

import java.sql.*;

public class CoursesMapper {
    private static Connection conn;
    private final String insertSQL = "call createNewCourse(?,?,?,?,?,?,?,?,?);";
    private final String updateSQL = "";

    private final String deleteSQL = "DELETE FROM courses WHERE courseIdentifier = ?;";
    public CoursesMapper() {
        if(this.conn==null)
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
        stmt.setString(7,c.getInstructor());
        stmt.setString(6,c.getClassroom());
        stmt.setDate(8,c.getStartDate());
        stmt.setDate(9,c.getEndDate());
        return stmt;
    }

    public void delete(Courses course) throws SQLException {
        CallableStatement stmt = conn.prepareCall(deleteSQL);
        this.setStmt(stmt,course);
        stmt.executeUpdate();
    }

    public ResultSet getAllCourses() throws SQLException {
        String Courses="select distinct ID_courses, courseIdentifier from courses;";
        System.out.println("In getAllCourses");
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(Courses);
    }

    public void updateCourse(Courses course) throws SQLException {

        CallableStatement stmt = conn.prepareCall(updateSQL);
        this.setStmt(stmt,course);
        stmt.executeUpdate();
    }
}