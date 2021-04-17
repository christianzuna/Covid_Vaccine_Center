package project1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import project1.Dao;
import project1.Employee;

public class EmployeeDao implements Dao<Employee>{

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String username = "postgres";
    public String password = "password";

    @Override
    public void insert() {
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees (fname, lname, age, email, pass) VALUES ('Christian','Zuna',28,'chris@bla.com','pass')", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void get(Employee e) {
        // TODO Auto-generated method stub
        
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
