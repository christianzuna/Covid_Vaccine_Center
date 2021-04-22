package project1.service;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileE")
public class EmployeeService extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter(); 

        // String userName = req.getParameter("userName");
        // String userPass = req.getParameter("userPass");

        // out.println("<h1>This is my session</h1>");
        // out.println("<p>My username is: " + userName + "</p>"); 
        // out.println("<p>My password is " + userPass + "</p>");
        // out.println("<p>My session id is: " + session.getId()); 

        out.println("you got to the doGet method in ProfileE!");
    }
}