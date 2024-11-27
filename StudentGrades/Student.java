
/**
 * Write a description of class Student here.
 *
 * @author (Nishant Rayamajhi)
 * @version (a version number or a date)
 */
public class Student {
    private String name;
    private String studentId;
    private int[] marks; // Array to store marks for three assignments
    private int totalMarks;

    // Constructor
    public Student(String name, String studentId, int[] marks) {
        this.name = name;
        this.studentId = studentId;
        this.marks = marks;
        this.totalMarks = calculateTotalMarks();
    }

    // Method to calculate total marks
    private int calculateTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for studentId
    public String getStudentId() {
        return studentId;
    }

    // Getter for marks
    public int[] getMarks() {
        return marks;
    }

    // Getter for totalMarks
    public int getTotalMarks() {
        return totalMarks;
    }

    // Display student details
    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nTotal Marks: " + totalMarks);
    }
}
