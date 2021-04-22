package project1;

import java.sql.Connection;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.model.Patient;
import project1.repository.PatientDao;

@WebServlet("/CreatePatient")
public class CreateUser extends HttpServlet {
    public Connection connection; 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PatientDao pDao = new PatientDao(); 

        resp.getWriter().println("hey there! this is the CreateEmployee Servlet!!");
        String userFname = req.getParameter("userFname");
        String userLname = req.getParameter("userLname");
        int userAge = Integer.parseInt(req.getParameter("userAge"));
        String userName = req.getParameter("userName"); 
        String userPass = req.getParameter("userPass"); 
        

        pDao.insert(new Patient(userFname, userLname, userAge, userName, userPass)); 
    
    }
    
}
