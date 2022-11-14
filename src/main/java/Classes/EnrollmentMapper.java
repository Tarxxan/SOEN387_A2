package Classes;// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.ResultSet;

public class EnrollmentMapper {
    private final String insertSQL = "INSERT INTO railway.courses(courseCode,title,semester,days,time,instructor,classroom,startDate,endDate,createdBy)        VALUES(?,?,?,?,?,?,?,?,?,?)";
    private final String deleteSQL = "DELETE FROM railway.enrollment WHERE courseCode=? AND studentID=?";

    public EnrollmentMapper() {
    }

    public ResultSet findById(Person person) {
        ResultSet rs = null;
        return (ResultSet)rs;
    }

    public int insert() {
        return 1;
    }
}
