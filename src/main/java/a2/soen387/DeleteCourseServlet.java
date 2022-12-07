package a2.soen387;

import Classes.Courses;
import Classes.InheritanceMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        InheritanceMapper im = (InheritanceMapper) session.getAttribute("Inheritance Mapper");
        String courseCode = request.getParameter("dcdropdown");
        HashMap hash = (HashMap) session.getAttribute("Hashmap") ;

        Courses course = new Courses();
        course.setCourseCode(courseCode);
        course.setPkid((int) hash.get(courseCode));
        try {
            if (im.inMapperCourse(course)) {
                im.deleteCourse(course);

            } else {
                im.findObject(course);
                im.deleteCourse(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            session.setAttribute("Inheritance Mapper",im);
            response.sendRedirect(request.getContextPath()+"/altercourse.jsp");
        }

        // add a redirect to the page they were currently on probably the Change/Delete Course page

    }
}
