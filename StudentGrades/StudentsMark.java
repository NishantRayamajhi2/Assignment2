
/**
 * Write a description of class StudentsGrade here.
 *
 * @author (NishantRayamajhi)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class StudentsMark {
    private List<Student> students;

    // Constructor
    public StudentsMark() {
        this.students = new ArrayList<>();
    }

    // Method to read data from a file
    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                // Ignore comment lines
                if (line.startsWith("#") || line.isEmpty()) {
                    continue;
                }
                // Parse student data
                String[] parts = line.split(",");
                String name = parts[0].trim();
                String studentId = parts[1].trim();
                int[] marks = {
                    Integer.parseInt(parts[2].trim()),
                    Integer.parseInt(parts[3].trim()),
                    Integer.parseInt(parts[4].trim())
                };
                students.add(new Student(name, studentId, marks));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        for (Student student : students) {
            student.displayStudentDetails();
            System.out.println("---------------------");
        }
    }

    // Method to filter students by threshold
    public void filterStudentsByThreshold(int threshold) {
        System.out.println("Students with total marks less than " + threshold + ":");
        for (Student student : students) {
            if (student.getTotalMarks() < threshold) {
                student.displayStudentDetails();
                System.out.println("---------------------");
            }
        }
    }

    // Method to sort and display top/bottom 5 students
    public void displayTopAndBottom5Students() {
        // Sort students by total marks
        students.sort(Comparator.comparingInt(Student::getTotalMarks));

        System.out.println("Top 5 Students:");
        for (int i = students.size() - 1; i >= Math.max(0, students.size() - 5); i--) {
            students.get(i).displayStudentDetails();
            System.out.println("---------------------");
        }

        System.out.println("Bottom 5 Students:");
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            students.get(i).displayStudentDetails();
            System.out.println("---------------------");
        }
    }
}
