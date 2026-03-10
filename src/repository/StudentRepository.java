package repository;

import model.Student;
import util.FileStorage;

import java.util.List;

public class StudentRepository {

    private List<Student> studentList;

    // Public method for Student Repository
    public StudentRepository() {
        studentList = FileStorage.load();
    }

    // Method to add student
    public  void addStudent(Student student) {
        studentList.add(student);
    }
    // Method to remove student
    public  void removeStudent(Student student) {
        studentList.remove(student);
    }

    // Method to get all student
    public  List<Student> getStudentList() {
        return studentList;
    }

    // Logic to find student id
    public Student findStudentById(int id) {
        // Loop to compare array with Student class
        for (Student student : studentList) {

            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}