package com.student.bean;
import java.util.ArrayList;

// Student entity class
public class Student {
    // Private fields: student details
    private int roll_number; // unique for all students
    private String name;
    private ArrayList<Integer> marks; // array for subject-wise marks
    private int lowest; // stores lowest marks
    private int highest; // stores highest marks
    private double percentage; // calculated from marks array
    private Grade grade; // calculated from percentage

    // Parameterised constructor: setting roll no and name
    public Student(int roll_number, String name) {
        this.roll_number = roll_number;
        this.name = name;
    }

    // Setters
    public void setMarks(ArrayList<Integer> marks) {this.marks = marks;}
    public void setRollNumber(int roll_number) {this.roll_number = roll_number;}
    public void setName(String name) {this.name = name;}
    public void setPercentage(double percentage) {this.percentage = percentage;}
    public void setGrade(Grade grade) {this.grade = grade;}
    public void setLowestMark(int lowest) {this.lowest = lowest;}
    public void setHighestMark(int highest) {this.highest = highest;}
    
    // Getters
    public int getRollNumber() {return roll_number;}
    public String getName() {return name;}
    public double getPercentage() {return percentage;}
    public Grade getGrade() {return grade;}
    public ArrayList<Integer> getMarks() {return marks;}
    public int getLowestMark() {return lowest;}
    public int getHighestMark() {return highest;}

    // toString() method to display all details in one print statement.
    @Override
    public String toString() {
        return "Student [" + roll_number + "] |Name: " + name + "\t|Lowest mark: " + lowest + "\t|Highest mark: " + highest + "\t|Percentage: " + percentage + "\t|Grade: " + grade;
    }
}