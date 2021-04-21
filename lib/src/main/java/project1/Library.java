package project1;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.model.Employee;
import project1.repository.EmployeeDao;

//this is like servlet-mapping on my web.xml file that I was suppossed to setup :(, this must match with my html-form where the attribute "action ="
@WebServlet("/Login")
public class Library extends HttpServlet{

    public Connection connection; 

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeDao eDao = new EmployeeDao(); 
        List<Employee> emp = new ArrayList<>();  
        emp = eDao.getAll(); 

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(emp);


        resp.setContentType("application/json");
        resp.getWriter().println(jsonString);
    }
}
