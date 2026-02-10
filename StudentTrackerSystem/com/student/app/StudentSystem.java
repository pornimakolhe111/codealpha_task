package com.student.app;
import com.student.service.*;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int roll_number;
        String name;
        int choice;
        // Creating object for service class which provides all services to manage student.
        StudentService service = new StudentService();

        while (true) { 
            System.out.println("\n==== Student Grade Tracker System ====");
            System.out.println("1. Add student.");
            System.out.println("2. Remove student.");
            System.out.println("3. Display student.");
            System.out.println("4. Display student count.");
            System.out.println("0. EXIT.!");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter student roll number: ");
                    roll_number = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter student name: ");
                    name = sc.nextLine();

                    service.addStudent(roll_number, name);
                    break;

                case 2:
                    System.out.println("Enter student roll number to remove: ");
                    roll_number = Integer.parseInt(sc.nextLine());
                    
                    service.removeStudent(roll_number);
                    break;

                case 3:
                    System.out.println("Displaying student details: ");
                    
                    service.displayAllStudents();
                    break;

                case 4:
                    System.out.println("Total student added in system: " + service.getStudentCount());
                    break;

                case 0:
                    sc.close();
                    System.exit(0);

                default:
                    throw new AssertionError("Invalid choice.!");
            }
        }
    }

}
