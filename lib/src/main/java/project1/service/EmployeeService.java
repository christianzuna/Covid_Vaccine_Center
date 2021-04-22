package project1.service;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileE")
public class EmployeeService extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");    
        resp.getWriter().println("welcome to EmployeeService servlet, you got to the ProfileE!");
    }
}