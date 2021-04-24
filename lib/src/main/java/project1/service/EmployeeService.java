package project1.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.model.Appointment;
import project1.model.Employee;
import project1.model.Patient;
import project1.repository.AppointmentDao;
import project1.repository.EmployeeDao;
import project1.repository.PatientDao;

@WebServlet("/ProfileE")
public class EmployeeService extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // AppointmentDao apptDao = new AppointmentDao();
        // EmployeeDao eDao = new EmployeeDao(); 
        PatientDao pDao = new PatientDao();

        List<Appointment> appt = new ArrayList<>();
        List<Employee> emp = new ArrayList<>(); 
        List<Patient> pat = new ArrayList<>();
        
        // appt = apptDao.getAllAppts(); 
        // emp = eDao.getAll();
        pat = pDao.getAll();

        ObjectMapper mapper = new ObjectMapper();
        // String jsonStringAppt = mapper.writeValueAsString(appt);
        // String jsonStringEmp = mapper.writeValueAsString(emp);
        String jsonStringPat = mapper.writeValueAsString(pat);
        
        resp.setContentType("application/json");
        resp.getWriter().println(jsonStringPat);
        // resp.getWriter().println(jsonStringEmp);
        // resp.getWriter().println(jsonStringAppt);
    }
}