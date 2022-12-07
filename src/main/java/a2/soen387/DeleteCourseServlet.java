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
import java.sql.SQLException;

@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        InheritanceMapper im = (InheritanceMapper) session.getAttribute("Inheritance Mapper");
        int id = Integer.parseInt(request.getParameter("dcdropdown"));
       // HashMap hash = (HashMap) session.getAttribute("Hashmap") ;

        Courses course = new Courses();
        course.setPkid(id);
      //  course.setPkid((int) hash.get(courseCode));
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