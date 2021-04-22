package project1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project1.model.Patient;

public class PatientDao {

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "password";

    public boolean insert(Patient e) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO patients (fname, lname, age, email, pass) VALUES (?,?,?,?,?)",
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

    public List<Patient> getAll() {
        List<Patient> list = new ArrayList<>();
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM patients");

            ResultSet rSet = preparedStatement.executeQuery();
            while (rSet.next()) {
                Patient temp = new Patient(rSet.getInt("pat_id"), rSet.getString("fname"), rSet.getString("lname"),
                        rSet.getInt("age"), rSet.getString("email"), rSet.getString("pass"));
                list.add(temp);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    public boolean update(Patient e) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE patients SET fname=?, lname=?, age=?, email=?, pass=? WHERE pat_id=?");

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

    public boolean Delete(Patient e) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM patients WHERE email=? and pass=?");

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

    public List<Patient> validate(String userName, String userPass) {
        Connection connection;
        List<Patient> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT pat_id, fname, lname, age, email, pass FROM patients WHERE email=? AND pass=?");

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPass);

            ResultSet rSet = preparedStatement.executeQuery();
            while (rSet.next()) {
                Patient temp = new Patient(rSet.getInt("pat_id"), rSet.getString("fname"), rSet.getString("lname"),
                        rSet.getInt("age"), rSet.getString("email"), rSet.getString("pass"));
                list.add(temp);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list; 
    }
}
