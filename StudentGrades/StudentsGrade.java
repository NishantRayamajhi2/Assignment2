
/**
 * Write a description of class StudentsGrade here.
 *
 * @author (NishantRayamajhi)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class StudentsGrade {
    private List<Student> students;

    // Constructor
    public StudentsGrade() {
        students = new ArrayList<>();
    }

    // Load students from file
    public void loadStudentData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue; // Skip comments and blank lines
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0].trim();
                    String id = parts[1].trim();
                    int mark1 = Integer.parseInt(parts[2].trim());
                    int mark2 = Integer.parseInt(parts[3].trim());
                    int mark3 = Integer.parseInt(parts[4].trim());
                    students.add(new Student(name, id, mark1, mark2, mark3));
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    // Display all students
    public void displayAllStudents() {
        System.out.printf("%-15s %-10s %-5s %-5s %-5s %-5s%n", "Name", "ID", "A1", "A2", "A3", "Total");
        System.out.println("--------------------------------------------------");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Filter students below a threshold
    public void filterStudentsByThreshold(int threshold) {
        System.out.printf("%-15s %-10s %-5s%n", "Name", "ID", "Total");
        System.out.println("-------------------------------");
        for (Student student : students) {
            if (student.getTotalMarks() < threshold) {
                System.out.printf("%-15s %-10s %-5d%n", student.getName(), student.getId(), student.getTotalMarks());
            }
        }
    }

    // Display top and bottom 5 students
    public void displayTopAndBottomStudents() {
        students.sort(Comparator.comparingInt(Student::getTotalMarks));

        System.out.println("\nBottom 5 Students:");
        System.out.printf("%-15s %-10s %-5s%n", "Name", "ID", "Total");
        System.out.println("-------------------------------");
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            Student student = students.get(i);
            System.out.printf("%-15s %-10s %-5d%n", student.getName(), student.getId(), student.getTotalMarks());
        }

        System.out.println("\nTop 5 Students:");
        System.out.printf("%-15s %-10s %-5s%n", "Name", "ID", "Total");
        System.out.println("-------------------------------");
        for (int i = students.size() - 1; i >= Math.max(0, students.size() - 5); i--) {
            Student student = students.get(i);
            System.out.printf("%-15s %-10s %-5d%n", student.getName(), student.getId(), student.getTotalMarks());
        }
    }

    // Main menu
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display All Students");
            System.out.println("2. Filter Students by Threshold");
            System.out.println("3. Display Top and Bottom 5 Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> displayAllStudents();
                case 2 -> {
                    System.out.print("Enter threshold: ");
                    int threshold = scanner.nextInt();
                    filterStudentsByThreshold(threshold);
                }
                case 3 -> displayTopAndBottomStudents();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        StudentsGrade manager = new StudentsGrade();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        manager.loadStudentData(fileName);
        manager.showMenu();
    }
}

