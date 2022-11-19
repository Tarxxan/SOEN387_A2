package Classes;

public class Enrollment {

    private int studentID;
     private String courseIdentifier;

    public Enrollment(){}
    public Enrollment(int studentID, String courseIdentifier) {
        this.studentID = studentID;
        this.courseIdentifier = courseIdentifier;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourseCode() {
        return this.courseIdentifier;
    }

    public void courseIdentifier(String courseIdentifier) {
        this.courseIdentifier = courseIdentifier;
    }
}