package project1.service;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileP")
public class PatientService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("Welcome to the ProfileP, this is the PatientService servlet doing a doPost!");
        String userName = req.getParameter("userName");
        String userPass = req.getParameter("userPass");

    }
}