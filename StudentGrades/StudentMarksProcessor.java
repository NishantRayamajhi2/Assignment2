import java.io.*;
import java.util.*;
import java.io.BufferedReader; // Import BufferedReader for reading text from a character-input stream
import java.io.FileReader; // Import FileReader for reading character files
import java.io.IOException; // Import IOException for handling input-output exceptions
import java.util.ArrayList; // Import ArrayList for resizable array implementation
import java.util.Comparator; // Import Comparator for comparing objects
import java.util.List; // Import List for ordered collection
import java.util.Scanner; // Import Scanner for parsing primitive types and strings
import java.util.Collections; // Import Collections for sorting
// StudentMarksProcessor.java

public class StudentMarksProcessor {
    private List<Student> students = new ArrayList<>();

    // Read student data from the CSV file
    public void readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Unit:") || line.startsWith("Last Name")) {
                continue; // Skip header and unit name lines
            }
            String[] parts = line.split(",");
            if (parts.length < 6) {
                continue; // Skip incomplete lines
            }
            String lastName = parts[0];
            String firstName = parts[1];
            String studentID = parts[2];
            double[] marks = new double[3];
            for (int i = 0; i < 3; i++) {
                marks[i] = parts[i + 3].isEmpty() ? 0 : Double.parseDouble(parts[i + 3]);
            }
            students.add(new Student(lastName, firstName, studentID, marks));
        }
        reader.close();
    }

    // Print all students' details
    public void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Filter and print students with total marks below a threshold
    public void filterAndPrintStudents(double threshold) {
        for (Student student : students) {
            if (student.getTotalMarks() < threshold) {
                System.out.println(student);
            }
        }
    }

    // Print top 5 and bottom 5 students based on total marks
    public void printTopAndBottomStudents() {
        students.sort(Comparator.comparingDouble(Student::getTotalMarks));
        System.out.println("Top 5 Students:");
        for (int i = students.size() - 1; i >= students.size() - 5; i--) {
            System.out.println(students.get(i));
        }
        System.out.println("Bottom 5 Students:");
        for (int i = 0; i < 5; i++) {
            System.out.println(students.get(i));
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        StudentMarksProcessor processor = new StudentMarksProcessor();
        Scanner scanner = new Scanner(System.in);
        try {
            // Ensure the file name is correct and located in the same directory
            String fileName = "prog5001_students_grade_2022.csv";
            processor.readFromFile(fileName);
            System.out.println("All Students:");
            processor.printAllStudents();

            // Input validation for threshold
            double threshold = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter the threshold: ");
                if (scanner.hasNextDouble()) {
                    threshold = scanner.nextDouble();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            System.out.println("Students with total marks less than " + threshold + ":");
            processor.filterAndPrintStudents(threshold);
            System.out.println("Top and Bottom 5 Students:");
            processor.printTopAndBottomStudents();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
