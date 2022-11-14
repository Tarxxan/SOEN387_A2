package Classes;

import java.sql.ResultSet;

public class CoursesMapper {
    private final String insertSQL = "INSERT INTO railway.courses(courseCode,title,semester,days,time,instructor,classroom,startDate,endDate,createdBy)        VALUES(?,?,?,?,?,?,?,?,?,?)";

    public CoursesMapper() {
    }

    public ResultSet findById(Courses courses) {
        ResultSet rs = null;
        return (ResultSet) rs;
    }

    public int insert() {
        return 1;
    }
}