package a2.soen387;

import Classes.Person;
import Classes.PersonMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/NewEmployeeServlet")
public class NewEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = new Person();
        person.setFirstName(request.getParameter("nename"));
        person.setLastName(request.getParameter("nelastname"));
        person.setPhoneNumber(request.getParameter("nephone"));
        person.setEmail(request.getParameter("nemail"));
        person.setDateOfBirth(Date.valueOf(request.getParameter("nedateofbirth")));
        person.setStreetName(request.getParameter("nestreetname"));
        person.setStreetNumber(request.getParameter("neestreetnumber"));
        person.setCity(request.getParameter("necity"));
        person.setCountry(request.getParameter("necountry"));
        person.setCountry(request.getParameter("necountry"));
        person.setPostalCode(request.getParameter("nepostalcode"));
        person.setIsStudent(false);

        PersonMapper pm = new PersonMapper();
        try {
            pm.createNewEmployee(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect(request.getContextPath()+"/newemployee.jsp");
    }
}