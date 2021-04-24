package project1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project1.model.Appointment;

public class AppointmentDao {

    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String user = "postgres";
    public String password = "password";

//it gets appointment id's associated to patients
    public List<Appointment> getAllAppts() {
        List<Appointment> list = new ArrayList<>();
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM appointment;");

            ResultSet rSet = preparedStatement.executeQuery();
            while (rSet.next()) {
                Appointment temp = new Appointment(rSet.getInt("appt_id"), rSet.getInt("patient_id"), rSet.getInt("employee_id"));
                list.add(temp);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    //searching by patient_id
    public List<Appointment> searchApptByPat(int patient_id) {
        List<Appointment> list = new ArrayList<>();
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM appointment WHERE patient_id=?;",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, patient_id);

            ResultSet rSet = preparedStatement.executeQuery();

            while (rSet.next()) {
                Appointment temp = new Appointment(rSet.getInt("appt_id"), rSet.getInt("patient_id"), rSet.getInt("employee_id"));
                list.add(temp);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

// search appointment by employee_id
    public List<Appointment> searchApptbyEmp(int employee_id) {
        List<Appointment> list = new ArrayList<>();
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM appointment WHERE employee_id=?",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, employee_id);

            ResultSet rSet = preparedStatement.executeQuery();

            while (rSet.next()) {
                Appointment temp = new Appointment(rSet.getInt("appt_id"), rSet.getInt("patient_id"), rSet.getInt("employee_id"));
                list.add(temp);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

}