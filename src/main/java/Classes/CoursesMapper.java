package Classes;

import java.sql.*;

public class CoursesMapper {
    private static Connection conn;
    private final String insertSQL = "call createNewCourse(?,?,?,?,?,?,?,?,?,?);";

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
}