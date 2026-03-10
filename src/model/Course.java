package model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    // Attributes
    private String courseName;
    private List<Student> students;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Getter name
    public String getCourseName() {
        return courseName;
    }
    // Getter student id
    public List<Student> getStudents() {
        return students;
    }
    // Method to add student course
    public void addStudent(Student student) {
        students.add(student);
    }
}
