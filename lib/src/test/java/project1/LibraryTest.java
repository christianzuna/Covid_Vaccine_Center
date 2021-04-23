package project1;

import jdk.jfr.Percentage;
import project1.model.Employee;
import project1.model.Patient;
import project1.repository.AppointmentDao;
import project1.repository.EmployeeDao;
import project1.repository.PatientDao;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    // @Test void testSomeLibraryMethod() {
    //     Library classUnderTest = new Library();
    //     assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    // }

    public static void main(String[] args) {
     
        // Employee e = new Employee("elena", "daniel", 45, "eda@bro", "duh");
        // Employee e2 = new Employee(5, "elena");
        EmployeeDao eDao = new EmployeeDao(); 

        // System.out.println(eDao.getAll());
        // eDao.insert(e);
        // eDao.Delete(e);
        // eDao.update(e2);

        PatientDao pDao = new PatientDao(); 
        // pDao.insert(new Patient("Carlos", "largo", 43, "carlos@pat", "pat")); 
        // System.out.println(pDao.getAll());
        // pDao.insert(new Patient("ana", "garcia", 23, "ana@yahoo", "yahoo"));
        // pDao.Delete(new Patient("Carlos", "largo", 43, "carlos@pat", "pat"));
        // System.out.println(pDao.validate("ana@yahoo", "yahoo"));

        LibraryTest obj = new LibraryTest(); 
        String bro = "bro@patient";

        // obj.isEmpOrPat(bro);

        AppointmentDao aDao = new AppointmentDao(); 
        
        // System.out.println(aDao.getAllAppts());
        
    }

    public void isEmpOrPat (String userName) {
        String temp = userName.substring(userName.length()-7, userName.length()); 
         
        System.out.println(temp.equals("patient")); 
        return; 
    }
}
