package project1;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//this is like servlet-mapping on my web.xml file that I was suppossed to setup :(, this must match with my html-form where the attribute "action ="
@WebServlet("/Login")
public class Library extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter(); 

        HttpSession session = req.getSession();

        String n = req.getParameter("userName"); 
        String p = req.getParameter("userPass");
        
        do {
            if (n.equals("employee@gmail.com") && p.equals("bro")) {
                session.setAttribute("uName", n);
                session.setAttribute("uPass", p);
                
                RequestDispatcher rd = req.getRequestDispatcher("/ProfileE");
                rd.forward(req, resp);
            } else if (n.equals("patient@gmail.com") && p.equals("bro")) {
                session.setAttribute("uName", n);
                session.setAttribute("uPass", p);
    
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

        } while (n!=null & p!=null);

        
    }

    // @Override
    // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     resp.setContentType("text/html");
    //     PrintWriter out = resp.getWriter(); 

    //     String n = req.getParameter("userName"); 
    //     String p = req.getParameter("userPass");

    //     if(n == null && p == null) {
    //         RequestDispatcher rd = req.getRequestDispatcher("/index.html"); 
    //         rd.include(req, resp);
    //     } else {
    //         out.println("User Created!");
    //         out.println("<hr>");
    //         RequestDispatcher rd = req.getRequestDispatcher("/index.html"); 
    //         rd.include(req, resp);
    //     }
    //     out.close();
    // }
}
