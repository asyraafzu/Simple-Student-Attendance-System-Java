package util;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {

    // Name of file
    private static final String FILE = "students.txt";

    // Method to save
    public static void save(List<Student> students) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE));

            for (Student s : students) {

                writer.write(s.getId() + "," + s.getName());
                writer.newLine();

            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving file.");
        }
    }

    // Method to load
    public static List<Student> load() {

        List<Student> students = new ArrayList<>();

        File file = new File(FILE);

        if (!file.exists()) {
            return students;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE));

            String line;

            while ((line = reader.readLine()) != null) {

                String [] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];

                students.add(new Student(id, name));
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error loading file!");
        }

        return students;
    }
}