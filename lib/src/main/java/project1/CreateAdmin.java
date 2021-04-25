package project1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project1.model.Employee;
import project1.repository.EmployeeDao;

@WebServlet("/CreateEmployee")
public class CreateAdmin extends HttpServlet {

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "password";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao eDao = new EmployeeDao();

        String userFname = req.getParameter("fname");
        String userLname = req.getParameter("lname");
        int userAge = Integer.parseInt(req.getParameter("age"));
        String userName = req.getParameter("username");
        String userPass = req.getParameter("password");

        eDao.insert(new Employee(userFname, userLname, userAge, userName, userPass));

        resp.setContentType("text/html");
        // resp.getWriter().println("hi there, this is the CreateEmployee Servlet doing a doPost!");
        resp.getWriter().println("<h2>Information Successfully Submitted!</h2>");

        RequestDispatcher rq = req.getRequestDispatcher("/index.html");
        rq.include(req, resp);
    }
}