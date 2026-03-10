package service;

import model.Student;
import repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

public class AttendanceService {

    private StudentRepository repository;

    public AttendanceService(StudentRepository repository) {
        this.repository = repository;
    }

    // Logic to add student
    public void addStudent(int id, String name) {

        Student s = repository.findStudentById(id);

        if (s != null) {
            System.out.println("Student Id already exists!");
            return;
        }
        else {
            Student student = new Student(id, name);

            repository.addStudent(student);
        }
    }
    // Logic to remove student
    public void deleteStudent(int id) {

        Student s = repository.findStudentById(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        repository.removeStudent(s);
    }
    // Logic to mark attendance
    public void markAttendance(int id, boolean present) {

        Student s = repository.findStudentById(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        s.markAttendance(LocalDate.now(), present);
    }
    // Logic to get all student
    public List<Student> getAllStudents() {
        return repository.getStudentList();
    }
    // Logic to find student id
}
