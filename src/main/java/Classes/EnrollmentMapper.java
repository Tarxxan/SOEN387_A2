package Classes;// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.*;

public class EnrollmentMapper {
    private final String  enroll= " INSERT ignore into enrollment(student, identifier, course)" + "select ID_student," +
            "courseIdentifier," + " ID_courses FROM  student s inner join courses c on  s.ID_student = ? where c.courseIdentifier = ?;";
    private final String findId="Select identifier FROM enrollment where student=?";
    private final String findCourse="Select studentIdentifier, ID_student FROM enrollment left join student s on enrollment.student = s.ID_student where identifier=? ";
    private final String drop = "DELETE from enrollment e  WHERE e.student = ? and e.identifier =?";
    public EnrollmentMapper() {
    }
    public ResultSet getCourseReportDropdown() throws SQLException {
        String sql = "{call courseReportDropdown()}";
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall(sql);
        return stmt.executeQuery();
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
        int count=0;
        Connection conn = DBConnection.getConnection();
        CallableStatement cstmt = conn.prepareCall("{Call getEnrolledCourses(?)}");
        cstmt.setInt(1,enrollment.getStudentID());
        ResultSet r= cstmt.executeQuery();

        while(r.next()){
            count++;
        }

        if(count>=4){
            r.close();
            cstmt.close();

        }
        else{
        PreparedStatement stmt = conn.prepareStatement(enroll);
        stmt.setInt(1,enrollment.getStudentID());
        stmt.setString(2, enrollment.getCourseCode());
        stmt.executeUpdate();}
    }

    public ResultSet getStudentsDropdown() throws SQLException {
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall("{Call studentReportDropdown()}");
        return stmt.executeQuery();
    }

    public ResultSet findById(int id) throws SQLException {

        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(findId);
        stmt.setInt(1,id);
        return stmt.executeQuery();
    }

    public ResultSet findbyCourse(String studentCourse) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(findCourse);
        stmt.setString(1,studentCourse);
        return stmt.executeQuery();
    }
}