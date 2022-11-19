package a2.soen387;

import Classes.Person;
import Classes.PersonMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Person person = new Person();
       PersonMapper pm = new PersonMapper();

        if (request.getParameter("studentid") != null && request.getParameter("spassword") != null) {

            person.setPersonalID(Integer.parseInt(request.getParameter("studentid")));
            person.setPassword(request.getParameter("spassword"));

            String studentIdentifier="";
            try {
                ResultSet rs = pm.validateStudentLogin(person);
               if(rs.next()){
                    studentIdentifier=rs.getString("studentIdentifier");
                }
                if (studentIdentifier != null ) {
                    // cant grab from the rs again unless you make it that you can go back and forth and then reset pointer to beginning
                    // person.setFullName(rs.getString("studentIdentifier"));
                    person.setFullName(studentIdentifier);
                    person.setIsStudent(true);
                } else
                    person.setIsStudent(false);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        else if (request.getParameter("employeeid") != null && request.getParameter("epassword") != null) {
            person.setPersonalID(Integer.parseInt(request.getParameter("employeeid")));
            person.setPassword(request.getParameter("epassword"));
            String employeeIdentifier="";
            try {
                ResultSet rs = pm.validateEmployeeLogin(person);
                if(rs.next()){
                    employeeIdentifier = rs.getString("employeeIdentifier");
                }
                if (employeeIdentifier != null) {
                    person.setFullName(employeeIdentifier);
                    person.setIsStudent(false);
                } else
                    person.setIsStudent(true);}
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("id", person.getPersonalID());
        session.setAttribute("name", person.getFullName());
        person.setPassword("");

        if(person.getFullName() ==""){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
            // NOR WORKING FOR SOME REASON
            response.getOutputStream().println("<script type=text/javascript>"+" window.alert('Id or password is incorrect')"+
                    "window.location.href='index.jsp'</script>");
        }
        else {
            if (person.getIsStudent()) {
                response.sendRedirect(request.getContextPath() + "/registrationform.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/adminsite.jsp");
            }
        }
    }
}