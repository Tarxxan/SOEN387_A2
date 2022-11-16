package Classes;// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentMapper {
    private final String insertSQL = "INSERT INTO railway.courses(courseCode,title,semester,days,time,instructor,classroom,startDate,endDate,createdBy)        VALUES(?,?,?,?,?,?,?,?,?,?)";
    private final String deleteSQL = "DELETE FROM railway.enrollment WHERE courseCode=? AND studentID=?";

    public EnrollmentMapper() {
    }

    public ResultSet findById(Person person) {
        ResultSet rs = null;
        return (ResultSet)rs;
    }

    public int insert() {
        return 1;
    }

    public ResultSet getAvailableCourses(int id) throws SQLException {
        String sql = " SELECT courses.courseCode, e.studentID " +
                "FROM courses  LEFT JOIN (select * from enrollment where enrollment.studentID = ?) e ON (courses.courseCode = e.courseCode) where e.studentID is null ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);

        return stmt.executeQuery();
    }

    public ResultSet getDropableCourses(int id)throws SQLException {
        String sql = "SELECT courseCode FROM railway.enrollment WHERE studentID=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        return stmt.executeQuery();
    }

    public ResultSet getEnrolledCourses(int id) throws SQLException {
        String sql = "SELECT courses.courseCode,title, instructor ,startDate ,endDate  FROM railway.courses"+
                " INNER JOIN railway.enrollment ON enrollment.courseCode= railway.courses.courseCode WHERE enrollment.studentID=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        stmt.setInt(1,id);
        return stmt.executeQuery();
    }
}
