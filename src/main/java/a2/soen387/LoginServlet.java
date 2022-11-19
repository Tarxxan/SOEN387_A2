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

            try {
                ResultSet rs = pm.validateStudentLogin(person);
                if (rs.getString("studentIdentifier") != null) {
                    person.setFullName(rs.getString("studentIdentifier"));
                    person.setIsStudent(true);
                } else
                    person.setIsStudent(false);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (request.getParameter("employeeid") != null && request.getParameter("epassword") != null)
            person.setPersonalID(Integer.parseInt("employeeid"));
        person.setPassword(request.getParameter("epassword"));


        try {
            ResultSet rs = pm.validateEmployeeLogin(person);
            if (rs.getString("employeeIdentifier") != null) {
                person.setFullName(rs.getString("employeeIdentifier"));
                person.setIsStudent(false);
            } else
                person.setIsStudent(true);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        HttpSession session = request.getSession();
        session.setAttribute("id", person.getPersonalID());
        session.setAttribute("name", person.getFullName());
        person.setPassword("");

        if(person.getFullName() ==""){
            response.getOutputStream().println("<script type=text/javascript>"+" window.alert('Id or password is incorrect')"+
                    "window.location.href='index.jsp'</script>");
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        if (person.getIsStudent()) {
            response.sendRedirect(request.getContextPath() + "/registrationform.jsp");
        } else  {
            response.sendRedirect(request.getContextPath() + "/adminsite.jsp");
        }


    }
}