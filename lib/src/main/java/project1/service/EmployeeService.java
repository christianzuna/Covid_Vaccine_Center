package project1.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.model.Patient;
import project1.repository.PatientDao;

@WebServlet("/ProfileE")
public class EmployeeService extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PatientDao pDao = new PatientDao();
        List<Patient> pat = new ArrayList<>();
        pat = pDao.getAll();

        //this object mapper will turn text into JSON data
        ObjectMapper mapper = new ObjectMapper();
        String jsonStringPat = mapper.writeValueAsString(pat);
        
        resp.setContentType("application/json");
        resp.getWriter().println(jsonStringPat);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String age = req.getParameter("age"); 
        String username = req.getParameter("username");
        String password = req.getParameter("password"); 

        PatientDao pDao = new PatientDao(); 
        pDao.insert(new Patient(fname, lname, Integer.parseInt(age), username, password));
        resp.sendRedirect("/lib/adminHomePage.html"); 
    }
}