package project1;

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
        
        String userFname = req.getParameter("fname");
        String userLname = req.getParameter("lname");
        int userAge = Integer.parseInt(req.getParameter("age"));
        String userName = req.getParameter("username");
        String userPass = req.getParameter("password");

        pDao.insert(new Patient(userFname, userLname, userAge, userName, userPass));

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Information Successfully Submitted!</h2>");

        //this will redirect me to the main webpage
        RequestDispatcher rq = req.getRequestDispatcher("/index.html");
        rq.include(req, resp);
    }
}
