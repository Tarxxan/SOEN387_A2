package Classes;// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.*;

public class EnrollmentMapper {
    String enroll= " INSERT ignore into enrollment(student, identifier, course)" + "select ID_student," +
            "courseIdentifier," + " ID_courses FROM  student s inner join courses c on  s.ID_student = ? where c.courseIdentifier = ?;";

    String drop = "DELETE from enrollment e  WHERE e.student = ? and e.identifier =?";
    public EnrollmentMapper() {
    }


    public int insert() {
        return 1;
    }

    public ResultSet getAvailableCourses(int id) throws SQLException {
        String sql = "{call courseOfferingForStudent(?)}";
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall(sql);
        stmt.setInt(1,id);
        return stmt.executeQuery();
    }

    public ResultSet getDropableCourses(int id) throws SQLException {
        String sql = "{call getDropableCourses(?)}";
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall(sql);
        stmt.setInt(1,id);
        return stmt.executeQuery();
    }

    public ResultSet getEnrolledCourses(int id) throws SQLException {
        String sql = "{call getEnrolledCourses(?)}";
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        stmt.setInt(1,id);
        return stmt.executeQuery();
    }

    public void dropCourses(Enrollment enrollment) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(drop);
        System.out.println(enrollment.getStudentID());
        System.out.println(enrollment.getCourseCode());
        stmt.setInt(1,enrollment.getStudentID());
        stmt.setString(2, enrollment.getCourseCode());
        stmt.executeUpdate();

    }

    public void addCourses(Enrollment enrollment) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(enroll);
        stmt.setInt(1,enrollment.getStudentID());
        stmt.setString(2, enrollment.getCourseCode());
        stmt.executeUpdate();
    }
}