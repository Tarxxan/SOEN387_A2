package a2.soen387;

import Classes.Person;
import Classes.PersonMapper;
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
        Person person = new Person();

        person.setPassword((request.getParameter("nspassword")));
        person.setFirstName(request.getParameter("nsname"));
        person.setLastName(request.getParameter("nslastname"));
        person.setEmail(request.getParameter("nsemail"));
        person.setPhoneNumber(request.getParameter("nsphone"));
        person.setPostalCode(request.getParameter("nsdateofbirth"));
        person.setStreetName(request.getParameter("nsstreetname"));
        person.setAppartmentNumber(request.getParameter("nsappartmentnumber"));
        person.setCountry(request.getParameter("nscountry"));
        person.setPostalCode(request.getParameter("nspostalcode"));
        person.setCity(request.getParameter("nscity"));
        person.setStreetNumber(request.getParameter("nsestreetnumber"));
        person.setIsStudent(true);

        PersonMapper pm = new PersonMapper();
        try {
            pm.createNewStudent(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect(request.getContextPath() + "/newstudent.jsp");
        //check success
    }
}