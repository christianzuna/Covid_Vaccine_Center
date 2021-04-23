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
import project1.model.Patient;

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
                "SELECT appointment.appt_id, patients.fname, patients.lname, patients.age, patients.email FROM patients INNER JOIN appointment on appointment.patient_id=patients.pat_id;");

            ResultSet rSet = preparedStatement.executeQuery();
            while (rSet.next()) {
                Appointment temp = new Appointment(rSet.getInt("appt_id"), rSet.getString("fname"), rSet.getString("lname"), rSet.getInt("age"), rSet.getString("email"));
                list.add(temp);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    //searching by patient email
    public List<Appointment> searchApptByPat(String userName) {
        List<Appointment> list = new ArrayList<>();
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT appointment.appt_id, patients.fname, patients.lname, patients.age, patients.email FROM patients INNER JOIN appointment on appointment.patient_id=patients.pat_id where patients.email=?;",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, userName);
            ResultSet rSet = preparedStatement.executeQuery();

            while (rSet.next()) {
                Appointment temp = new Appointment(rSet.getInt("appt_id"), rSet.getString("fname"), rSet.getString("lname"), rSet.getInt("age"), rSet.getString("email"));
                list.add(temp);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    public List<Appointment> searchApptbyEmp(String userName) {
        List<Appointment> list = new ArrayList<>();
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT appointment.appt_id, patients.fname, patients.lname, patients.age, patients.email FROM patients INNER JOIN appointment on appointment.patient_id=patients.pat_id where patients.email=?;",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, userName);
            ResultSet rSet = preparedStatement.executeQuery();

            while (rSet.next()) {
                Appointment temp = new Appointment(rSet.getInt("appt_id"), rSet.getString("fname"), rSet.getString("lname"), rSet.getInt("age"), rSet.getString("email"));
                list.add(temp);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

}