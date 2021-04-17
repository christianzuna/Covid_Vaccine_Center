package project1;

import project1.repository.EmployeeDao;

public class Library {
    public static void main(String[] args) {
        EmployeeDao test = new EmployeeDao(); 

        System.out.println("Attempting to insert data in my db");
        test.insert();
    }
}