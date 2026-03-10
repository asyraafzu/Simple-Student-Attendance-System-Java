package controller;

import service.AttendanceService;
import view.StudentView;
import util.FileStorage;

public class AttendanceController {

    private AttendanceService service;
    private StudentView view;

    public AttendanceController(AttendanceService service, StudentView view) {
        this.service = service;
        this.view = view;
    }

    // Method start
    public void start() {

        int choice;

        do {
            choice = view.showMenu();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    markAttendance();
                    break;
                case 4:
                    view.displayStudents(service.getAllStudents());
                    break;
                case 0:
                    FileStorage.save(service.getAllStudents());
                    view.showMessage("System exiting...");
                    break;
                default:
                    view.showMessage("Invalid choice!");

            }
        } while (choice != 0);
    }

    // Create method: add student
    private void addStudent() {

        int id = view.inputStudentId();
        String name = view.inputStudentName();

        service.addStudent(id, name);
    }
    // Create method: delete student
    private void deleteStudent() {

        int id = view.inputStudentId();

        service.deleteStudent(id);
    }
    // Create method: mark attendance
    private void markAttendance() {

        int id = view.inputStudentId();
        boolean present = view.inputAttendance();

        service.markAttendance(id, present);
    }
}
