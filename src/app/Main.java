package app;

import controller.AttendanceController;
import repository.StudentRepository;
import service.AttendanceService;
import view.StudentView;

public class Main {
    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();

        AttendanceService service = new AttendanceService(repository);

        StudentView view = new StudentView();

        AttendanceController controller = new AttendanceController(service, view);

        controller.start();
    }
}
