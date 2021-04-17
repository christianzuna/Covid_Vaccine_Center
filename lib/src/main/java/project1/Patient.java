package project1;

public class Patient {
    private int id; 
    private String fname; 
    private String lname; 
    private int age; 
    private String email; 
    private String pass;

    public Patient(int id, String fname, String lname, int age, String email, String pass) {
        this.id = id; 
        this.fname = fname; 
        this.lname = lname; 
        this.age = age; 
        this.email = email; 
        this.pass = pass; 
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    @Override
    public String toString() {
        return "Patient [age=" + age + ", email=" + email + ", fname=" + fname + ", id=" + id + ", lname=" + lname
                + ", pass=" + pass + "]";
    } 

}
