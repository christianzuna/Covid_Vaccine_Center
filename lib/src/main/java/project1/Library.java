package project1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//this is like servlet-mapping on my web.xml file that I was suppossed to setup :(, this must match with my html-form where the attribute "action ="
@WebServlet("/Login")
public class Library extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter(); 

        String n = req.getParameter("userName"); 
        String p = req.getParameter("userPass");
        

        if (n.equals("employee") && p.equals("bro")) {
            RequestDispatcher rd = req.getRequestDispatcher("/ProfileE");
            rd.forward(req, resp);
        } else if (n.equals("patient") && p.equals("bro")) {
            RequestDispatcher rd = req.getRequestDispatcher("/ProfileP");
            rd.forward(req, resp);
        }
        else {
            out.println("Sorry UserName or Password Error!");
            out.println("<hr>");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html"); 
            rd.include(req, resp);
        }
        out.close();
    }
}
