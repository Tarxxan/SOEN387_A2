package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DisplayHelper {

    public static HashMap<String, Integer> idMap = new HashMap();
    private final int id;

    public DisplayHelper(int id) {
        this.id = id;
    }

    public static String displayAllPerson() throws SQLException {
        String personDropdown = "";
        PersonMapper pm = new PersonMapper();
        ResultSet rs = pm.getAllPerson();
        while (rs.next()) {
            int id = rs.getInt("id");
            String identifier = rs.getString("identifier");
            personDropdown += "<option value='" + id + "'>" + identifier + " " + id + "</option>";
        }
        return personDropdown;
    }

    public String displayCoursesList() throws SQLException {
        String courseDropdown = "";
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getCourseListOptions();

        while (rs.next()) {
            int id = rs.getInt("ID_courses");
            String course = rs.getString("courseIdentifier");
//            idMap.put(course,id);
            courseDropdown += "<option value='" + id + "'>" + course + "</option>";
        }
        return courseDropdown;
    }

    public String displayStudentsList() throws SQLException {
        String courseReport = "";
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getStudentsListOptions();
        while (rs.next()) {
            int stuId = rs.getInt("ID_student");
            String stuIdentifier = rs.getString("studentIdentifier");
            courseReport += "<option value='" + stuId + "'>" + stuId + " " + stuIdentifier + "</option>";
        }

        return courseReport;
    }

    public String displayDropableCourses() throws SQLException {
        String dropableCourses = "";
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getDropableCourses(this.id);
        while (rs.next()) {
            String course = rs.getString("identifier");
            int id = rs.getInt("ID_courses");
            dropableCourses += "<option value='" + id + "'>" + course + "</option>";
        }

        return dropableCourses;
    }

    public String displayActiveEnrolledCourses() throws SQLException {

        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getEnrolledCourses(this.id);
        //check if empty
        if (!rs.next()) {
            return "";
        }
        rs.beforeFirst();
        String courses = "<table><tr><th>Courses</th></tr>";
        while (rs.next()) {
            courses += "<tr><td>" + rs.getString("identifier") + "</td><tr>";
        }
        courses += "</table>";
        return courses;
    }

    public static String displayAllCourses() throws SQLException {
        String courseDropdown = "";
        CoursesMapper c = new CoursesMapper();
        ResultSet rs = c.getAllCourses();

        while (rs.next()) {
            String courseIdentifier = rs.getString("courseIdentifier");
            int id = rs.getInt("ID_courses");
          //idMap.put(courseIdentifier, id);
            courseDropdown += "<option value='" + id + "'>" + courseIdentifier + "</option>";
        }
        return courseDropdown;
    }

    public String coursesAvailableToEnroll() throws SQLException {
        String enrollableCourses = "";
        EnrollmentMapper em = new EnrollmentMapper();
        ResultSet rs = em.getAvailableCourses(this.id);
        while (rs.next()) {
            String course = rs.getString("identifier");
            int id = rs.getInt("ID_courses");
            enrollableCourses += "<option value='" + id + "'>" + course + "</option>";
        }

        return enrollableCourses;
    }
}