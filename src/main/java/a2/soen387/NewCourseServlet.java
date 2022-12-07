package a2.soen387;

import Classes.Courses;
import Classes.CoursesMapper;
import Classes.InheritanceMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/NewCourseServlet")
public class NewCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int strComp = request.getParameter("startDate").compareTo(request.getParameter("endDate"));
            if (strComp == 0 || strComp > 0) {
            response.getOutputStream().println("<script type=text/javascript>"+" window.alert('Start and End dates are incorrect, please verify before re-submitting')"+
            "window.location.href='newcourse.jsp'</script>");
            response.sendRedirect(request.getContextPath()+"/newcourse.jsp");
        }
        HttpSession session = request.getSession();
        String courseCode = request.getParameter("courseCode");
        String title =request.getParameter("courseTitle");
        String semester=request.getParameter("semester");
        String days = request.getParameter("days");
        String instructor=request.getParameter("instructor");
        String time = request.getParameter("time");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        String classroom= request.getParameter("room");
//        int createdBy= (int) session.getAttribute("id");

        Courses course = new Courses(courseCode,title,semester,days,classroom,instructor,time,startDate,endDate);
        CoursesMapper cm = new CoursesMapper();
        InheritanceMapper im = (InheritanceMapper) session.getAttribute("Inheritance Mapper");


        try {
            cm.addClass(course);
            im.memoryObjects.add(course);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            session.setAttribute("Inheritance Mapper",im);
            response.sendRedirect(request.getContextPath()+"/adminsite.jsp");
        }
    }
}