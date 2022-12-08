package a2.soen387;

import Classes.Enrollment;
import Classes.EnrollmentMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddDropCourseServlet")
public class AddDropCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enrollment enrollment = new Enrollment();
        HttpSession session = request.getSession();
        enrollment.setStudentID((Integer) session.getAttribute("id"));
        EnrollmentMapper em= new EnrollmentMapper();


        if(request.getParameter("sdsubmit")!=null){
            try {
                enrollment.setCourseID(Integer.parseInt(request.getParameter("dropCourse")));
                em.dropCourses(enrollment);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                response.sendRedirect(request.getContextPath()+"/registrationform.jsp");
            }
        }
        else {
            try {
                enrollment.setCourseID(Integer.parseInt(request.getParameter("addCourse")));
                em.addCourses(enrollment);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                response.sendRedirect(request.getContextPath()+"/registrationform.jsp");
            }
        }



    }
}