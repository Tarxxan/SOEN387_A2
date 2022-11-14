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
        Person person = new Person(); person.setPersonalID(12345678);
        System.out.println("worked");
        PersonMapper pm = new PersonMapper();
        try {
            ResultSet rs =pm.findById(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
