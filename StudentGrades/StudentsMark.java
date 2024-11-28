
/**
 * Write a description of class Student here.
 *
 * @author (Nishant Rayamajhi)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentsMark {
    private ArrayList<Student> students;

    public StudentsMark() {
        students = new ArrayList<>();
    }

    // Read data from a file
    public void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue; // Skip comments and empty lines
                }
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    String id = parts[1];
                    int mark1 = Integer.parseInt(parts[2].trim());
                    int mark2 = Integer.parseInt(parts[3].trim());
                    int mark3 = Integer.parseInt(parts[4].trim());
                    students.add(new Student(name, id, mark1, mark2, mark3));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Filter students by a threshold
    public void filterStudentsByThreshold(int threshold) {
        System.out.println("\nStudents with total marks below " + threshold + ":");
        for (Student student : students) {
            if (student.getTotalMarks() < threshold) {
                System.out.println(student);
            }
        }
    }

    // Display top 5 and bottom 5 students
    public void displayTopAndBottom5Students() {
        students.sort((s1, s2) -> Integer.compare(s2.getTotalMarks(), s1.getTotalMarks()));
        System.out.println("\nTop 5 Students:");
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            System.out.println(students.get(i));
        }
        System.out.println("\nBottom 5 Students:");
        for (int i = students.size() - 1; i >= Math.max(0, students.size() - 5); i--) {
            System.out.println(students.get(i));
        }
    }

    // Main method
    public static void main(String[] args) {
        StudentsMark studentsMark = new StudentsMark();
        Scanner scanner = new Scanner(System.in);
        String fileName;
        int choice;

        System.out.println("Welcome to the Student Marks Management System!");

        // Load student data from file
        System.out.print("Enter the file name to load student data (e.g., 'students_data.csv'): ");
        fileName = scanner.nextLine();
        studentsMark.readFromFile(fileName);

        // Menu loop
        do {
            System.out.println("\nMENU:");
            System.out.println("1. Display all students");
            System.out.println("2. Filter students below a mark threshold");
            System.out.println("3. Display top 5 and bottom 5 students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display all students
                    System.out.println("\nAll Students:");
                    studentsMark.displayAllStudents();
                    break;

                case 2:
                    // Filter students by threshold
                    System.out.print("\nEnter the threshold marks: ");
                    int threshold = scanner.nextInt();
                    studentsMark.filterStudentsByThreshold(threshold);
                    break;

                case 3:
                    // Display top 5 and bottom 5 students
                    System.out.println("\nTop 5 and Bottom 5 Students:");
                    studentsMark.displayTopAndBottom5Students();
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
