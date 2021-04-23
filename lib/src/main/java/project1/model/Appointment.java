package project1.model;

public class Appointment {
    private int appt_id; 
    private String fname; 
    private String lname; 
    private int age; 
    private String email;


    
    public Appointment(int appt_id, String fname, String lname, int age, String email) {
        this.appt_id = appt_id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.email = email;
    }



    public int getAppt_id() {
        return appt_id;
    }



    public void setAppt_id(int appt_id) {
        this.appt_id = appt_id;
    }



    public String getFname() {
        return fname;
    }



    public void setFname(String fname) {
        this.fname = fname;
    }



    public String getLname() {
        return lname;
    }



    public void setLname(String lname) {
        this.lname = lname;
    }



    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        this.age = age;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Appointment: " + appt_id + ", " + fname + ", " + lname + ", " + age + ", " + email;
    } 

    
}
