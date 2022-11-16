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

        if(request.getParameter("studentid")!=null){
            person.setPersonalID(Integer.parseInt(request.getParameter("studentid")));
        }
        else if ((request.getParameter("employeeid")!=null)) {
            person.setPersonalID(Integer.parseInt(request.getParameter("employeeid")));
        }

        HttpSession session = request.getSession();
        session.setAttribute("id",person.getPersonalID());
        PersonMapper pm = new PersonMapper();
        try {

            ResultSet rs =pm.findById(person);
            while(rs.next()){
                String id=Integer.toString(rs.getInt("personalId"));
                if(0==Character.compare('1',id.charAt(0))) {
                    person.setIsStudent(true);
                } else {
                    person.setIsStudent(false);
                }
            }
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        if (person.getIsStudent()){
            response.sendRedirect(request.getContextPath()+"/registrationform.jsp");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/adminsite.jsp");
        }



    }
}
