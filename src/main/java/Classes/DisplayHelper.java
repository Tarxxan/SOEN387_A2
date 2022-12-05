package Classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DisplayHelper {

    public static HashMap<String,Integer> idMap= new HashMap();
    private int id;
    public DisplayHelper(int id) {
        this.id=id;
    }

    public String displayAvailableCoursesDropdown() throws SQLException {
        String courseDropdown ="";
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getAvailableCourses(this.id);

        while(rs.next()){
//            int id= rs.getInt("ID_courses");
            String course=rs.getString("courseIdentifier");
//            idMap.put(course,id);
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

    public static String displayAllCourses() throws SQLException {
        String courseDropdown="";
        CoursesMapper c = new CoursesMapper();
        ResultSet rs = c.getAllCourses();

        while(rs.next()){
            String courseIdentifier=rs.getString("courseIdentifier");
            int id=rs.getInt("ID_courses");
            String course=rs.getString("courseCode");
            idMap.put(course,id);
            courseDropdown+="<option value='"+course+"'>"+course+"</option>";
        }
        return courseDropdown;
    }

}