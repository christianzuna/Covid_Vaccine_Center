package project1.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.model.Employee;
import project1.repository.EmployeeDao;

@WebServlet("/ProfileP")
public class PatientService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao eDao = new EmployeeDao(); 

        List<Employee> emp = new ArrayList<>(); 
        
        emp = eDao.getAll(); 

        ObjectMapper mapper = new ObjectMapper(); 

        String jsonStringEmp = mapper.writeValueAsString(emp);

        resp.setContentType("application/json");
        resp.getWriter().println(jsonStringEmp);
    }
}