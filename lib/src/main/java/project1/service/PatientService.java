package project1.service;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileP")
public class PatientService extends HttpServlet{
    
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
}