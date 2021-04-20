package project1;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Logout")
public class Logout extends HttpServlet{
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession(); 

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter(); 

        session.invalidate();
        out.println("You are successfully logged out!");
        out.println("<hr>");


        RequestDispatcher rd = req.getRequestDispatcher("/index.html"); 
        rd.include(req, resp);

        out.close();
    }
}