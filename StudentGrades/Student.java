// Student.java
public class Student {
    private String lastName;
    private String firstName;
    private String studentID;
    private double[] marks;
    private double totalMarks;

    // Constructor to initialize student details
    public Student(String lastName, String firstName, String studentID, double[] marks) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.marks = marks;
        this.totalMarks = calculateTotalMarks();
    }

    // Calculate total marks from the three assignments
    private double calculateTotalMarks() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    // Getters for student details
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStudentID() {
        return studentID;
    }

    public double[] getMarks() {
        return marks;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    // Override toString method to print student details
    @Override
    public String toString() {
        return String.format("%s, %s (%s): A1=%.1f, A2=%.1f, A3=%.1f, Total=%.1f",
                lastName, firstName, studentID, marks[0], marks[1], marks[2], totalMarks);
    }
}
