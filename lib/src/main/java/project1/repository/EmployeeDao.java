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

public class EmployeeDao /*implements Dao<Employee>*/ {

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "password";

    // @Override
    public boolean insert(Employee e) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO employees (fname, lname, age, email, pass) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, e.getFname());
            preparedStatement.setString(2, e.getLname());
            preparedStatement.setInt(3, e.getAge());
            preparedStatement.setString(4, e.getEmail());
            preparedStatement.setString(5, e.getPass());

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    // @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");

            ResultSet rSet = preparedStatement.executeQuery();
            while (rSet.next()) {
                Employee temp = new Employee(rSet.getInt("emp_id"), rSet.getString("fname"), rSet.getString("lname"),
                        rSet.getInt("age"), rSet.getString("email"), rSet.getString("pass"));
                list.add(temp);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    // @Override
    public boolean update(Employee e) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE employees SET fname=?, lname=?, age=?, email=?, pass=? WHERE emp_id=?");

            preparedStatement.setString(1, e.getFname());
            preparedStatement.setString(2, e.getLname());
            preparedStatement.setInt(3, e.getAge());
            preparedStatement.setString(4, e.getEmail());
            preparedStatement.setString(5, e.getPass());
            preparedStatement.setInt(6, e.getId());

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    // @Override
    public boolean Delete(Employee e) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM employees WHERE email=? and pass=?");

            preparedStatement.setString(1, e.getEmail());
            preparedStatement.setString(2, e.getPass());

            if (preparedStatement.executeUpdate() > 0) {
                return true;

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    public List<Employee> validate(String userName, String userPass) {
        Connection connection;
        List<Employee> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT emp_id, fname, lname, age, email, pass FROM employees WHERE email=? AND pass=?");

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPass);

            ResultSet rSet = preparedStatement.executeQuery();
            while (rSet.next()) {
                Employee temp = new Employee(rSet.getInt("emp_id"), rSet.getString("fname"), rSet.getString("lname"),
                        rSet.getInt("age"), rSet.getString("email"), rSet.getString("pass"));
                list.add(temp);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list; 
    }
}
