package project1.model;

public class Appointment {
    private int appt_id; 
    private int patient_id; 
    private int employee_id;

    public Appointment(int appt_id, int patient_id, int employee_id) {
        this.appt_id = appt_id;
        this.patient_id = patient_id;
        this.employee_id = employee_id;
    }


    public int getAppt_id() {
        return appt_id;
    }



    public void setAppt_id(int appt_id) {
        this.appt_id = appt_id;
    }



    public int getPatient_id() {
        return patient_id;
    }



    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }



    public int getEmployee_id() {
        return employee_id;
    }



    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }



    @Override
    public String toString() {
        return "Appointment [appt_id=" + appt_id + ", employee_id=" + employee_id + ", patient_id=" + patient_id + "]";
    } 


    
}
