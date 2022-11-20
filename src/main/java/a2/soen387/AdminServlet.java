package a2.soen387;

import Classes.EnrollmentMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter output = response.getWriter();
        output.println("");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter output = response.getWriter();
        EnrollmentMapper em = new EnrollmentMapper();

        if (request.getParameter("rcsubmit") != null) {
            try {
                ResultSet rs = em.findById(Integer.parseInt(request.getParameter("courseToDisplay")));
                output.println("<table><tr><th>Course</th>");
                while (rs.next()) {
                    output.println("<tr><td>");
                    output.print(rs.getString("identifier"));
                    output.println("</td></tr>");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                output.println("</table>");
            }
        }
        else{
            try {
                ResultSet rs = em.findbyCourse((request.getParameter("studentCourse")));
                output.println("<table><tr><th>Student ID</th><th>Student Name</th>");
                while (rs.next()) {
                    output.println("<tr><td>");
                    output.print(rs.getString("ID_student"));
                    output.print("<td>"+rs.getString("studentIdentifier"));
                    output.println("</td></tr>");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                output.println("</table>");
            }
        }
    }
}



