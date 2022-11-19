package a2.soen387;

import Classes.Enrollment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/AddDropCourseServlet")
public class AddDropCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enrollment enrollment = new Enrollment();
enrollment.setStudentID( Integer.parseInt(request.getRequestedSessionId()));
        enrollment.courseIdentifier(request.getParameter("selection"));


    }
}