package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Student {

    // Private attributes
    private int id;
    private String name;
    private Map<LocalDate, Boolean> attendance;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.attendance = new HashMap<>();
    }

    // Getter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    // Method to mark attendance with date and boolean
    public void markAttendance(LocalDate date, boolean present) {
        attendance.put(date, present);
    }

    // Method to get present day
    public int getPresentDays() {

        int count = 0;

        for (Boolean present : attendance.values()) {

            if (present) {
                count++;
            }

        }

        return count;
    }
    // Method to get absent day
    public int getAbsentDays() {

        int count = 0;

        for (Boolean present : attendance.values()) {

            if (!present) {
                count++;
            }

        }

        return count;
    }

    // Method to get percentage of attendance
    public double getAttendancePercentage() {

        int total = attendance.size();

        if (total>0) {
            int present = getPresentDays();
            return (double) (present * 100) /total;
        }
        else {
            return 0;
        }
    }

    // Method to print out attendance history
    public void printAttendanceHistory() {

        for (LocalDate date : attendance.keySet()) {

            boolean present = attendance.get(date);

            System.out.println(date + ": " + (present ? "Present" : "Absent"));
        }
    }

}
