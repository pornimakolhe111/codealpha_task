package com.student.service;
import com.student.bean.Grade;
import com.student.bean.Student;
import java.util.ArrayList;

// service interface: includes all service methods for managing student.
public interface Service {
    Student createStudent(int roll_number, String name);
    double calculatePercentage(Student student);
    Grade calculateGrade(double percentage);
    void addStudent(int roll_number, String name);
    void removeStudent(int roll_number);
    ArrayList<Integer> acceptMarks();
    int calculateLowestMarks(Student student);
    int calculateHighestMarks(Student student);
    void displayAllStudents();

}
