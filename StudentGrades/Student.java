
/**
 * Write a description of class Student here.
 *
 * @author (Nishant Rayamajhi)
 * @version (a version number or a date)
 */
public class Student {
    private String name;
    private String id;
    private int mark1, mark2, mark3;
    private int totalMarks;

    // Constructor
    public Student(String name, String id, int mark1, int mark2, int mark3) {
        this.name = name;
        this.id = id;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.totalMarks = mark1 + mark2 + mark3;
    }

    // Getters for attributes
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    // Display details
    @Override
    public String toString() {
        return String.format("%-15s %-10s %-5d %-5d %-5d %-5d", name, id, mark1, mark2, mark3, totalMarks);
    }
}
