package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.model.Employee;
import project1.repository.EmployeeDao;

@WebServlet("/CreateEmployee")
public class CreateAdmin extends HttpServlet {

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "password";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao eDao = new EmployeeDao();

        resp.getWriter().println("hi there, this is the CreateEmployee Servlet doing a doPost!");

        String userFname = req.getParameter("userFname");
        String userLname = req.getParameter("userLname");
        int userAge = Integer.parseInt(req.getParameter("userAge"));
        String userName = req.getParameter("userName");
        String userPass = req.getParameter("userPass");

        eDao.insert(new Employee(userFname, userLname, userAge, userName, userPass));
    }
}