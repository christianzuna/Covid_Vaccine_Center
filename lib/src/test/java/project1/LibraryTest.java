package project1;

import project1.repository.AppointmentDao;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    // @Test void testSomeLibraryMethod() {
    //     Library classUnderTest = new Library();
    //     assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    // }

    public static void main(String[] args) {
     
        // List<Appointment> list = new ArrayList<>(); 
        AppointmentDao aDao = new AppointmentDao(); 
        // System.out.println(aDao.getAllAppts());
        // System.out.println(aDao.searchApptByPat(2));
        System.out.println(aDao.searchApptbyEmp(3));
         

        // LibraryTest obj = new LibraryTest(); 
        // String bro = "bro@patient";

        
        
    }

    public void isEmpOrPat (String userName) {
        String temp = userName.substring(userName.length()-7, userName.length()); 
         
        System.out.println(temp.equals("patient")); 
        return; 
    }
}
