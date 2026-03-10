package view;

import model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {

    private Scanner scanner;

    public StudentView() {
        scanner = new Scanner(System.in);
    }

    // Terminal Main Menu
    public int showMenu() {

        System.out.println("\n===== Student Attendance System =====\n");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Mark Attendance");
        System.out.println("4. View All Students");
        System.out.println("0. Exit");

        System.out.print("Choice: ");

        return scanner.nextInt();
    }
    // Input student by Id
    public int inputStudentId() {
        System.out.println("Enter student ID: ");
        return scanner.nextInt();
    }
    // Input student name
    public String inputStudentName () {
        scanner.nextLine();
        System.out.println("Enter student name: ");
        return scanner.nextLine();
    }
    // Input attendance
    public boolean inputAttendance() {

        while (true) {
            System.out.println("Present? Yes/No : ");

            String input = scanner.next();

            if (input.equalsIgnoreCase("y")) {
                return true;
            }
            else if (input.equalsIgnoreCase("n")) {
                return false;
            }
            else
                System.out.println("Invalid input!");
        }
    }
    // Display all students
    public void displayStudents (List<Student> students) {

        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }

        for (Student student : students) {

            System.out.println("ID: " + student.getId() +
                    " | Name: " + student.getName() +
                    " | Present (Day): " + student.getPresentDays() +
                    " | Absent (Day): " + student.getAbsentDays() +
                    " | Attendance (%): " + student.getAttendancePercentage()
            );
        }
    }
    // Show message
    public void showMessage(String message) {
        System.out.println(message);
    }
}
