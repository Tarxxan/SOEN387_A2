package a2.soen387;

import Classes.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/NewStudentServlet")
public class NewStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Student person = new Student();
        person.setPassword((request.getParameter("nspassword")));
        person.setFirstName(request.getParameter("nsname"));
        person.setLastName(request.getParameter("nslastname"));
        person.setEmail(request.getParameter("nsemail"));
        person.setPhoneNumber(request.getParameter("nsphone"));
        person.setDateOfBirth(Date.valueOf(request.getParameter("nsdateofbirth")));
        person.setStreetName(request.getParameter("nsstreetname"));
        person.setAppartmentNumber(request.getParameter("nsappartmentnumber"));
        person.setCountry(request.getParameter("nscountry"));
        person.setPostalCode(request.getParameter("nspostalcode"));
        person.setCity(request.getParameter("nscity"));
        person.setStreetNumber(request.getParameter("nsestreetnumber"));
        person.setIsStudent(true);

        InheritanceMapper im = (InheritanceMapper) session.getAttribute("Inheritance Mapper");
        PersonMapper pm = new PersonMapper();
        try {
            pm.createNewStudent(person);
            im.memoryObjects.add(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            response.sendRedirect(request.getContextPath() + "/newstudent.jsp");
        }
        //check success
    }
}