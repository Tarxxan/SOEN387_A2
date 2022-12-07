package a2.soen387;

import Classes.Employee;
import Classes.InheritanceMapper;
import Classes.PersonMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
        Employee person = new Employee();
        person.setFirstName(request.getParameter("nename"));
        person.setLastName(request.getParameter("nelastname"));
        person.setPhoneNumber(request.getParameter("nephone"));
        person.setEmail(request.getParameter("neemail"));
        person.setDateOfBirth(Date.valueOf(request.getParameter("nedateofbirth")));
        person.setStreetName(request.getParameter("nestreetname"));
        person.setStreetNumber(request.getParameter("neestreetnumber"));
        person.setCity(request.getParameter("necity"));
        person.setCountry(request.getParameter("necountry"));
        person.setCountry(request.getParameter("necountry"));
        person.setPostalCode(request.getParameter("nepostalcode"));
        person.setPassword((request.getParameter("nepassword")));
        person.setIsStudent(false);

        InheritanceMapper im = (InheritanceMapper) session.getAttribute("Inheritance Mapper");
        PersonMapper pm = new PersonMapper();
        try {
            pm.createNewEmployee(person);
            im.memoryObjects.add(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            session.setAttribute("Inheritance Mapper",im);
            response.sendRedirect(request.getContextPath()+"/newemployee.jsp");

        }

    }
}