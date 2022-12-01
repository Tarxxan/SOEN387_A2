package a2.soen387;

import Classes.Courses;
import Classes.EnrollmentMapper;
import Classes.InheritanceMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/UpdateCoursesServlet")
public class UpdateCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        InheritanceMapper im = (InheritanceMapper) session.getAttribute("Inheritance Mapper");

        //Dropdown select for courses on the page
        String courseCode = request.getParameter("courseCode");
        String title =request.getParameter("courseTitle");
        String semester=request.getParameter("semester");
        String days = request.getParameter("days");
        String instructor=request.getParameter("instructor");
        String time = request.getParameter("time");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        String classroom= request.getParameter("room");
        int createdBy= (int) session.getAttribute("id");

        Courses course = new Courses(courseCode,title,semester,days,classroom,instructor,time,startDate,endDate,createdBy);
        try {
            if (im.inMapperCourse(course)) {
                im.updateCourse(course);
            } else {
                im.findObject(course);
                im.updateCourse(course);
            }
        } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        finally {
            session.setAttribute("Inheritance Mapper",im);
        }
    }
}
