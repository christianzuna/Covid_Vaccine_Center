package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.model.Patient;
import project1.repository.PatientDao;

@WebServlet("/CreatePatient")
public class CreateUser extends HttpServlet {

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "password";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PatientDao pDao = new PatientDao();
        
        String userFname = req.getParameter("userFname");
        String userLname = req.getParameter("userLname");
        int userAge = Integer.parseInt(req.getParameter("userAge"));
        String userName = req.getParameter("userName");
        String userPass = req.getParameter("userPass");

        pDao.insert(new Patient(userFname, userLname, userAge, userName, userPass));

        resp.setContentType("text/html");
        resp.getWriter().println("hey there! this is the CreateEmployee Servlet!!");

        RequestDispatcher rq = req.getRequestDispatcher("/index.html");
        rq.include(req, resp);
    }
}
