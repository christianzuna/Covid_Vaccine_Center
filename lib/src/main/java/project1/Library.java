package project1;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.model.Employee;
import project1.model.Patient;
import project1.repository.EmployeeDao;
import project1.repository.PatientDao;

//this is like servlet-mapping on my web.xml file that I was suppossed to setup :(, this must match with my html-form where the attribute "action ="
@WebServlet("/Login")
public class Library extends HttpServlet {

    public Connection connection;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Library obj = new Library();
        PatientDao pDao = new PatientDao();
        EmployeeDao eDao = new EmployeeDao();

        String userName = req.getParameter("userName");
        String userPass = req.getParameter("userPass");

        if (obj.isPat(userName)) {
            List<Patient> pat = new ArrayList<>();
            pat = pDao.validate(userName, userPass);

            if (!pat.isEmpty()) {
                // RequestDispatcher rq = req.getRequestDispatcher("/ProfileP");
                // rq.forward(req, resp);
                resp.sendRedirect("/lib/userHomePage.html");
            } else {
                resp.setContentType("text/html");
                resp.getWriter().println("Sorry wrong username or password...");
                RequestDispatcher rq = req.getRequestDispatcher("/index.html");
                rq.include(req, resp);
            }
        } else if (obj.isEmp(userName)) {
            List<Employee> emp = new ArrayList<>();
            emp = eDao.validate(userName, userPass);

            if (!emp.isEmpty()) {
                // RequestDispatcher rq = req.getRequestDispatcher("/ProfileE");
                // rq.forward(req, resp);
                resp.sendRedirect("/lib/adminHomePage.html");
            } else {
                resp.setContentType("text/html");
                resp.getWriter().println("Sorry wrong username or password...");
                RequestDispatcher rq = req.getRequestDispatcher("/index.html");
                rq.include(req, resp);
            }
        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("Sorry wrong username or password...");
            RequestDispatcher rq = req.getRequestDispatcher("/index.html");
            rq.include(req, resp);
        }

    }

    // it checks if it is a patient
    public boolean isPat(String userName) {
        String temp = userName.substring(userName.length() - 7, userName.length());

        if (temp.equals("patient")) {
            return true;
        } else
            return false;
    }

    // it checks if it is an employee
    public boolean isEmp(String userName) {
        String temp = userName.substring(userName.length() - 8, userName.length());

        if (temp.equals("employee")) {
            return true;
        }
        return false;
    }
}
