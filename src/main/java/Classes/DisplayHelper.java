package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayHelper {

    private int id;
    public DisplayHelper(int id) {
        this.id=id;
    }

    public String displayAvailableCoursesDropdown() throws SQLException {
        String courseDropdown = null;
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getAvailableCourses(this.id);
        String selection;
        while(rs.next()){
            selection = rs.getString("identifier");
            courseDropdown+="<option value='selection'>"+rs.getString("identifier")+rs.getString("classroom")+rs.getString("startDate")+rs.getString("endDate")+"</option>";
        }
        return courseDropdown;
    }

    public String displayDropableCourses() throws SQLException {
        String dropableCourses = null;
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getDropableCourses(this.id);
        while(rs.next()){
            dropableCourses+="<option value='"+rs.getString("identifier")+"'></option>";
        }

        return dropableCourses;
    }

    public String displayActiveEnrolledCourses() throws SQLException {

        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getEnrolledCourses(this.id);
        //check if enmpty
        if(!rs.next()){
            return "";
        }
        rs.beforeFirst();
        String courses="<table><tr><th>Courses</th></tr>";
        while(rs.next()){
        courses+="<tr><td>"+rs.getString("identifier")+"</td><tr>";
        }
        courses+="</table>";
        System.out.println(courses);
        return courses;
    }



    // TODO: 2022-11-19 create methods for reports
}