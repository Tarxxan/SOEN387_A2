package Classes;// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentMapper {
    String enroll= " INSERT ignore into enrollment(student, identifier, course)\n" +
            "select ID_student,\n" +
            "courseIdentifier,\n" +
            " ID_courses FROM  student s inner join courses c on  s.ID_student = ? where c.courseIdentifier = ?;";
    String drop = "DELETE  from enrollment e  WHERE e.student = ? and e.identifier =?";
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
        String sql = "call courseOfferingForStudent(?);";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);

        return stmt.executeQuery();
    }

    public ResultSet getDropableCourses(int id)throws SQLException {
        String sql = "call getDropableCourses(?);";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        return stmt.executeQuery();
    }

    public ResultSet getEnrolledCourses(int id) throws SQLException {
        String sql = "call getEnrolledCourses(?);";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        stmt.setInt(1,id);
        return stmt.executeQuery();
    }


}