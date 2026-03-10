package util;

import model.Student;

import java.io.FileWriter;
import java.util.List;

public class CSVExporter {

    public static void export(List<Student> students) {

        try {

            FileWriter writer = new FileWriter("attendance.csv");

            writer.write("ID,Name,Present,Absent,Percentage\n");

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                        s.getName() + "," +
                        s.getPresentDays() + "," +
                        s.getAbsentDays() + "," +
                        s.getAttendancePercentage() + "\n"
                );

            }

            writer.close();

            System.out.println("CSV exported.");

        } catch (Exception e) {

            System.out.println("Export error.");

        }

    }

}