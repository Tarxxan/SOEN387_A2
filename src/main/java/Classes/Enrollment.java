package Classes;

public class Enrollment {

    private int studentID;
    private int enrollID;
    private String courseCode;

    public Enrollment(){}
    public Enrollment(int studentID, int enrollID, String courseCode) {
        this.studentID = studentID;
        this.enrollID = enrollID;
        this.courseCode = courseCode;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getEnrollID() {
        return enrollID;
    }

    public void setEnrollID(int enrollID) {
        this.enrollID = enrollID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
