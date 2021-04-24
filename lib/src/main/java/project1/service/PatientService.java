package project1.service;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileP")
public class PatientService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPass = req.getParameter("userPass");

        resp.getWriter().println("Username is: " + userName);
        resp.getWriter().println("Password is: " + userPass);
    }
}