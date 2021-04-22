package project1.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.model.Patient;
import project1.repository.PatientDao;

@WebServlet("/ProfileE")
public class EmployeeService extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("welcome to ProfileE, this is the EmployeeService servlet doing a doPost!");

        // PatientDao pDao = new PatientDao();
        // List<Patient> pat = new ArrayList<>();
        // pat = pDao.getAll();

        // ObjectMapper mapper = new ObjectMapper();
        // String jsonString = mapper.writeValueAsString(pat);

        // resp.setContentType("application/json");
        // resp.getWriter().println(jsonString);
    }
}