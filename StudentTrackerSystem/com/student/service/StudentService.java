package com.student.service;
import com.student.bean.*;
import java.util.ArrayList;
import java.util.Scanner;

// Service class to implement services to manage students.
public class StudentService implements Service {
    private final ArrayList<Student> students; // final field: only one student list is created.
    private int student_count; // stores how many students are added in the list.

    // Constructor: allocates memory to list of students and initialize count to 0.
    public StudentService() {
        students = new ArrayList<>();
        student_count = 0;
    }

    // returns new memory to a student object.
    @Override
    public Student createStudent(int roll_number, String name) {
        return new Student(roll_number, name);
    }

    // ask user to enter marks for a student and stores in list in list.
    // returns the mark list
    @Override
    public ArrayList<Integer> acceptMarks() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();
        System.out.print("Enter 5 subject marks: ");
        for(int i=0; i<5; i++) {
            int mark = Integer.parseInt(sc.next());
            marks.add(mark);
        }
        return marks;
    }

    // returns the lowest mark a student have.
    @Override
    public int calculateLowestMarks(Student student) {
        ArrayList<Integer> marks = student.getMarks();
        int lowest_mark = marks.get(0);
        for(int mark : marks)
            if(mark < lowest_mark)
                lowest_mark = mark;
        return lowest_mark;
    }

    // returns the highest mark a student have.
    @Override
    public int calculateHighestMarks(Student student) {
        ArrayList<Integer> marks = student.getMarks();
        int highest_mark = marks.get(0);
        for(int mark : marks)
            if(mark > highest_mark)
                highest_mark = mark;
        return highest_mark;
    }

    // add a student in the list after seting all fields of student object.
    // contains calling to all the helper functions.
    @Override
    public void addStudent(int roll_number, String name) {
        Student student = createStudent(roll_number, name);
        if(student == null) {
            System.out.println("Can't add empty(null) student.!");
            return;
        }

        student.setMarks(acceptMarks());
        student.setLowestMark(calculateLowestMarks(student));
        student.setHighestMark(calculateHighestMarks(student));
        double percentage = calculatePercentage(student);
        student.setPercentage(percentage);
        student.setGrade(calculateGrade(percentage));

        students.add(student);
        student_count++; // increment student count while inserting a student in the list.
        System.out.println("Student added successfully.");
    }

    @Override
    public void removeStudent(int roll_number) {
        Student toDeleteStudent = null;
        for(Student s : students) {
            if(s.getRollNumber() == roll_number){
                toDeleteStudent = s;
                break;
            }
        }

        if(toDeleteStudent != null) {
            students.remove(toDeleteStudent);
            student_count--;
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found in system.!");
        }
    }

    // calculate the total percentage (average marks) of student and return it.
    @Override
    public double calculatePercentage(Student student) {
        ArrayList<Integer> marks = student.getMarks();
        double per = 0;
        for(int mark : marks) {
            per += mark;
        }
        return (double) per/marks.size();
    }

    // return appropriate grade according to the percentage a student have.
    @Override
    public Grade calculateGrade(double per) {
        if(per > 90) {
            return Grade.A;
        } else if(per > 80) {
            return Grade.B;
        } else if(per > 60) {
            return Grade.C;
        } else {
            return Grade.F;
        }
    }

    // displays all student details in the list.
    @Override
    public void displayAllStudents() {
        for(Student s : students) {
            System.out.println(s);
        }
    }

    // Getter for student count.
    public int getStudentCount() {return student_count;}
}