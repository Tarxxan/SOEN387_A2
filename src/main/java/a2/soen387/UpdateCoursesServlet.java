package a2.soen387;

import Classes.Courses;
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

@WebServlet("/UpdateCoursesServlet")
public class UpdateCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        InheritanceMapper im = ( InheritanceMapper ) session.getAttribute("Inheritance Mapper");
        // HashMap hash = (HashMap) session.getAttribute("Hashmap") ;
        //Dropdown select for courses on the page
        int id = Integer.parseInt(request.getParameter("ucdropdown"));
        String courseCode = request.getParameter("courseCode");
        String title = request.getParameter("courseTitle");
        String semester = request.getParameter("semester");
        String days = request.getParameter("days");
        String time = request.getParameter("time");
        String classroom = request.getParameter("room");
        String instructor = request.getParameter("instructor");
        Date startDate;
        Date endDate;
        if (request.getParameter("startDate").equals("") || request.getParameter("startDate") == null) {
            startDate = new Date(11111111);
//                startDate= (Date) new SimpleDateFormat("yyyyMMdd").parse("20230101");
        } else {
            startDate = Date.valueOf(request.getParameter("startDate"));
        }

        if (request.getParameter("endDate").equals("") || request.getParameter("endDate") == null) {
//                endDate= (Date) new SimpleDateFormat("yyyyMMdd").parse("20231231");
            endDate = new Date(11111112);
        } else {
            endDate = Date.valueOf(request.getParameter("endDate"));
        }

        Courses course = new Courses(courseCode, title, semester, days, classroom, instructor, time, startDate, endDate);
        course.setPkid(id);
        // course.setPkid((Integer) hash.get(course.getCourseCode()));

        System.out.println(course.getPkid());

        try {
            if (im.inMapperCourse(course)) {
                // Update course in memory and then pass this to the datbase to be updated.
                course = im.updateMemCourse(course);
                System.out.println("Mapper");
                im.updateCourse(course);

            } else {
                // Add to the list. Update the course in the database according to the data tht we have. Pull the updated data into memory since it will have missing params if we dont
                im.memoryObjects.add(course);
                im.findObject(course);
                im.updateCourse(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            session.setAttribute("Inheritance Mapper", im);
            response.sendRedirect(request.getContextPath() + "/altercourse.jsp");

        }
    }
}