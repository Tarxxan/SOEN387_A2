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

        Date setDateOfBirth=null;
        String firstName = request.getParameter("nsname");
        String setLastName =request.getParameter("nslastname");
        String setPhoneNumber=request.getParameter("nsphone");
        String setEmail=request.getParameter("nsemail");
        if(request.getParameter("nsdateofbirth").equals("")){
          setDateOfBirth = new Date(11111111);
        }
        else{
            setDateOfBirth= Date.valueOf(request.getParameter("nsdateofbirth"));
        }

        String setStreetName=request.getParameter("nsstreetname");
        String  setStreetNumber = request.getParameter("nsestreetnumber");
        String setCity=request.getParameter("nscity");
        String setCountry =request.getParameter("nscountry");
        String setAptNumber = request.getParameter("nsappartmentnumber");
        String setPostalCode=request.getParameter("nspostalcode");
        String setPassword =request.getParameter("nspassword");

        //TODO: Add hidden form var in student change version for if statement below will submit the session var
        // create dropdown with all employees and students for employees to pick for the id they will edit.

        int id;
        if((int)request.getAttribute("id")>89999999){
            id= Integer.parseInt(request.getParameter("id"));
        }
        else{
            id=(int)request.getAttribute("id");
        }


        Person p = new Person(setPassword,firstName,setLastName,setEmail,setPhoneNumber,setDateOfBirth,setStreetName,setAptNumber,setCountry,setPostalCode,setCity,setStreetNumber,false);
        p.setPersonalID(id);

        if(id>89999999){
            p= (Employee) p;
        }
        else{
            p = (Student) p;
        }

        try {
            if (im.inMapperPerson(p)) {

                p = im.updateMemPerson(p);
                System.out.println("Mapper");
                im.updatePerson(p);

            } else {
                // check course for logic on why we do this
                im.memoryObjects.add(p);
                im.updatePerson(p);
                im.findObject(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            session.setAttribute("Inheritance Mapper",im);
            response.sendRedirect(request.getContextPath() + "/updatePerson.jsp");
        }

    }
}
