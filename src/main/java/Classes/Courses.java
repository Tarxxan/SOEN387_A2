package Classes;

import java.sql.Date;
import java.sql.Time;

public class Courses {

    private int pkid;

    private String classroom;
    private String courseCode;

    private String title;

    private String semester;

    private String days;

    private String time;

    private Date startDate;

    private Date endDate;
    private String instructor;

    private String courseIdentifier;

    private int createdBy;

    public Courses(String courseCode, String title, String semester, String days, String instructor, String classroom, String time, Date startDate, Date endDate) {
        this.courseCode = courseCode;
        this.title = title;
        this.semester = semester;
        this.days = days;
        this.time = time;
        this.instructor=instructor;
        this.startDate = startDate;
        this.classroom=classroom;
        this.endDate = endDate;

    }

    public Courses() {

    }

//    public static boolean delete(Object o1, Object o2) {
//        Courses c1= (Courses) o1;
//        Courses c2= (Courses) o2;
//
//        if(c1.getCourseCode().equals(c2.getCourseCode())){
//            CoursesMapper cm = new CoursesMapper();
//            //cm.delete(c1);
//            return true;
//        }
//        return false;
//    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getCourseIdentifier() {
        return courseIdentifier;
    }
    public void setCourseIdentifier(String courseIdentifier) {
        this.courseIdentifier = courseIdentifier;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
    public String toString(){
        return this.courseIdentifier;
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }
}

