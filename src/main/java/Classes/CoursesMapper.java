package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoursesMapper {
    private static Connection conn;
    private final String insertSQL = "call createNewCourse(?,?,?,?,?,?,?,?,?,?);";

    public CoursesMapper() {
        if(this.conn==null)
            conn=DBConnection.getConnection();
    }

    public ResultSet findById(Courses courses) {
        ResultSet rs = null;
        return (ResultSet) rs;
    }

    public int insert() {
        return 1;
    }

    public void addClass(Courses c) throws SQLException {
     //will ignore if already exist
        PreparedStatement stmt = conn.prepareStatement(insertSQL);
        this.setStmt(stmt,c);
        stmt.executeUpdate();

    }

    private PreparedStatement setStmt(PreparedStatement stmt, Courses c) throws SQLException {

        stmt.setString(1,c.getCourseCode());
        stmt.setString(2,c.getTitle());
        stmt.setString(3,c.getSemester());
        stmt.setString(4,c.getDays());
        stmt.setTime(5,c.getTime());
        stmt.setString(7,c.getInstructor());
        stmt.setString(6,c.getClassroom());
        stmt.setDate(8,c.getStartDate());
        stmt.setDate(9,c.getEndDate());
              return stmt;
    }
}