package a2.soen387;

import Classes.EnrollmentMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter output = response.getWriter();
        output.println("");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        EnrollmentMapper em = new EnrollmentMapper();

        if (request.getParameter("rcsubmit") != null) {
            try {
              output.println("<html><body>");
                output.println("<h3 class=\"center-box\"> Courses Taken</h3>");
              output.println("<table>");
int id = Integer.parseInt(request.getParameter("studentSelected"));

                ResultSet rs = em.getStudentCourseHistory(id);

                while (rs.next()) {
                    output.println("<tr><td>");
                    output.print(rs.getString("identifier"));
                    output.println("</td></tr>");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                output.println("</table>");
                output.print("</body></html>");
            }
        }
        else{
            try {
                output.println("<html><body>");
                output.println("<h3 class=\"center-box\"> Student ID    |   Student name</h3>");
                int id = Integer.parseInt(request.getParameter("courseSelected"));

                ResultSet rs = em.findbyCourse(id);

                output.println("<table>");
                while (rs.next()) {
                    output.println("<tr><td>");
                    output.print(rs.getString("ID_student"));
                    output.print("<td>"+rs.getString("studentIdentifier")+" | "+rs.getString("semester"));
                    output.println("</td></tr>");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                output.println("</table>");
                output.print("</body></html>");
            }
        }
    }
}