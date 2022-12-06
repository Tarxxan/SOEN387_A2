package a2.soen387;

import Classes.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/DeletePersonServlet")
public class DeletePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        InheritanceMapper im = (InheritanceMapper) session.getAttribute("Inheritance Mapper");
        int id = Integer.parseInt(request.getParameter("dpdropdown"));
        try {
            if(id>89999999){
                Employee e = new Employee();
                e.setPersonalID(id);
                if (im.inMapperPerson(e)) {
                im.deletePerson(e);

            } else {
                im.findObject(e);
                System.out.println(e);
                im.deletePerson(e);
            }
        }else {
             Student s = new Student();
             s.setPersonalID(id);
                if (im.inMapperPerson(s)) {
                    im.deletePerson(s);

                } else {
                    im.findObject(s);
                    System.out.println(s);
                    im.deletePerson(s);
                }

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            session.setAttribute("Inheritance Mapper",im);

        }
    }
}
