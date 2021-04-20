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
        PrintWriter out = resp.getWriter(); 
        HttpSession session = req.getSession(false);

        req.getRequestDispatcher("logout.html").include(req, resp);

        String myName = (String)session.getAttribute("uName");
        String myPass = (String)session.getAttribute("uPass"); 

        out.println("<h1>This is my session</h1>");
        out.println("<p>My username is: " + myName + "</p>"); 
        out.println("<p>My password is " + myPass + "</p>");
        out.println("<p>My session id is: " + session.getId()); 
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String fn = req.getParameter("userFname");
        String ln = req.getParameter("userLname");
        String ua = req.getParameter("userAge");
        String ue = req.getParameter("userName");
        String up = req.getParameter("userPass");

        out.println("My first name is: " + fn);
        out.println("<br>");
        out.println("My last name is " + ln);
        out.println("<br>");
        out.println("My age is: " + ua);
        out.println("<br>");
        out.println("My username is: " + ue);
        out.println("<br>");
        out.println("My password is: " + up);

        out.println("Successfully created!");
        out.println("Please Login");

        req.getRequestDispatcher("/index.html").forward(req, resp); 

    }
}