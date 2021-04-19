package project1;

import java.io.IOException;
import java.io.PrintWriter;

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
        
        PrintWriter pw = resp.getWriter(); 

        resp.setContentType("text/html");
        String user = req.getParameter("userName"); 
        String pass = req.getParameter("userPass"); 
                
        if(user.equals("christian") && pass.equals("tumacho")) {
            pw.println("Login Success...!");
        } else {
            pw.println("Login Failed...!"); 
        }
        pw.close();
    }
}
