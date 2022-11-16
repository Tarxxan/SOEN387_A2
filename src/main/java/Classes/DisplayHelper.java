package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayHelper {

    private int id;
    public DisplayHelper(int id) {
        this.id=id;
    }

    public String displayCoursesDropdown() throws SQLException {
        String courseDropdown = null;
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getAvailableCourses(this.id);
        while(rs.next()){
            courseDropdown+="<option value='"+rs.getString("courseCode")+"'>"+rs.getString("courseCode")+"</option>";
        }
        return courseDropdown;
    }

    public String displayDropableCourses() throws SQLException {
        String dropableCourses = null;
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getDropableCourses(this.id);
        while(rs.next()){
            dropableCourses+="<option value='"+rs.getString("courseCode")+"'>"+rs.getString("courseCode")+"</option>";
        }

        return dropableCourses;
    }

    public String displayCourses() throws SQLException {

        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getEnrolledCourses(this.id);
        //check if enmpty
        if(!rs.next()){
            return "";
        }
        rs.beforeFirst();
        String courses="<table><tr><th>Course Code</th><th>Title</th><th>Instructor</th><th>Start Date</th><th>End Date</th></tr>";
        while(rs.next()){
        courses+="<tr><td>"+rs.getString("courseCode")+"</td><td>"+rs.getString("title")+"</td><td>"+rs.getString("instructor")+
                "</td><td>"+rs.getDate("startDate").toString()+"</td><td>"+rs.getDate("endDate").toString()+"</td><tr>";
        }
        courses+="</table>";
        System.out.println(courses);
        return courses;
    }
}
