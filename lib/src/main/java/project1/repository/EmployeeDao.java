package project1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project1.model.Employee;

public class EmployeeDao implements Dao<Employee>{

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "password";

    @Override
    public void insert(Employee e) {
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees (fname, lname, age, email, pass) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, e.getFname());
            preparedStatement.setString(2, e.getLname());
            preparedStatement.setInt(3, e.getAge());
            preparedStatement.setString(4, e.getEmail());
            preparedStatement.setString(5, e.getPass());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

//get by id
    public Employee get(int id) {
         Employee emp = null; 
         try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT emp_id,fname,lname,age,email from employees where emp_id = ? ");
            preparedStatement.setInt(1, id);
            ResultSet rSet = preparedStatement.executeQuery(); 

            while(rSet.next()){
                int emp_id = rSet.getInt("emp_id");
                String fname = rSet.getString("fname"); 
                String lname = rSet.getString("lname");
                int age = rSet.getInt("age");
                String email = rSet.getString("email"); 

                emp = new Employee(emp_id, fname, lname, age, email);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        System.out.println(emp);
        return emp;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>(); 
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");

            ResultSet rSet = preparedStatement.executeQuery();
            while (rSet.next()) {
                Employee temp = new Employee(rSet.getInt("emp_id"), rSet.getString("fname"), rSet.getString("lname"), rSet.getInt("age"), rSet.getString("email"), rSet.getString("pass"));
                list.add(temp);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } 
        return list;
    }

    @Override
    public void update(Employee e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Delete(Employee e) {
        // TODO Auto-generated method stub
        
    }

    
  
    
}
