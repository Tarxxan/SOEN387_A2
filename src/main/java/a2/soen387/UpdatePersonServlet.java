package a2.soen387;

import Classes.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/UpdatePersonServlet")
public class UpdatePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        InheritanceMapper im = (InheritanceMapper) session.getAttribute("Inheritance Mapper");

        Date setDateOfBirth = null;
        String firstName = request.getParameter("npname");
        String setLastName = request.getParameter("nplastname");
        String setPhoneNumber = request.getParameter("npphone");
        String setEmail = request.getParameter("npemail");
        if (request.getParameter("npdateofbirth").equals("")) {
        } else {
            setDateOfBirth = Date.valueOf(request.getParameter("npdateofbirth"));
        }

        String setStreetName = request.getParameter("npstreetname");
        String setStreetNumber = request.getParameter("npestreetnumber");
        String setCity = request.getParameter("npcity");
        String setCountry = request.getParameter("npcountry");
        String setAptNumber = request.getParameter("npappartmentnumber");
        String setPostalCode = request.getParameter("nppostalcode");
        String setPassword = request.getParameter("nppassword");
        int id = Integer.parseInt(request.getParameter("updropdown"));
        Employee e = null;
        Student s = null;

        System.out.println(setAptNumber);
        System.out.println(setPhoneNumber);
        System.out.println(setStreetName);
        if (id > 89999999) {
            e= new Employee(setPassword,firstName,setLastName,setEmail,setPhoneNumber,setDateOfBirth,setStreetName,setAptNumber,setCountry,setPostalCode,setCity,setStreetNumber,false);
            e.setPersonalID(id);
        } else {
            s = new Student(setPassword,firstName,setLastName,setEmail,setPhoneNumber,setDateOfBirth,setStreetName,setAptNumber,setCountry,setPostalCode,setCity,setStreetNumber);
            s.setPersonalID(id);
        }

        try {
            if (s == null) {
                if (im.inMapperPerson(e)) {
                    e = (Employee) im.updateMemPerson(e);
                    System.out.println("Mapper");
                    im.updatePerson(e);
                } else {
                    // check course for logic on why we do this
                    im.memoryObjects.add(e);
                    im.updatePerson(e);
                    im.findObject(e);
                }
            } else {
                if (im.inMapperPerson(s)) {
                    s = (Student) im.updateMemPerson(s);
                    System.out.println("Mapper");
                    im.updatePerson(s);

                } else {
                    // check course for logic on why we do this
                    im.memoryObjects.add(s);
                    im.updatePerson(s);
                    im.findObject(s);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            session.setAttribute("Inheritance Mapper", im);
            response.sendRedirect(request.getContextPath() + "/updatePerson.jsp");
        }
    }
}
