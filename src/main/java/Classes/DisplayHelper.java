package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayHelper {

    private int id;
    public DisplayHelper(int id) {
        this.id=id;
    }

    public String displayAvailableCoursesDropdown() throws SQLException {
        String courseDropdown ="";
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getAvailableCourses(this.id);

        while(rs.next()){
            String course=rs.getString("courseIdentifier");
            courseDropdown+="<option value='"+course+"'>"+course+"</option>";
        }
        return courseDropdown;
    }

    public String displayDropableCourses() throws SQLException {
        String dropableCourses = "";
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getDropableCourses(this.id);
        while(rs.next()){
            String course=rs.getString("identifier");
            dropableCourses+="<option value='"+course+"'>"+course+"</option>";
        }

        return dropableCourses;
    }

    public String displayActiveEnrolledCourses() throws SQLException {

        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getEnrolledCourses(this.id);
        //check if empty
        if(!rs.next()){
            return "";
        }
        rs.beforeFirst();
        String courses="<table><tr><th>Courses</th></tr>";
        while(rs.next()){
        courses+="<tr><td>"+rs.getString("identifier")+"</td><tr>";
        }
        courses+="</table>";
        return courses;
    }
    public String displayReportCourses() throws SQLException {
        String courseReport = "";
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getStudentsDropdown();
        while(rs.next()){
            String stuId = rs.getString("ID_student");
            String stuIdentifier =rs.getString("studentIdentifier");
            courseReport+="<option value='"+stuId+"'>"+stuId+" "+stuIdentifier+"</option>";
        }

        return courseReport;
    }


    // TODO: 2022-11-19 create methods for reports
}