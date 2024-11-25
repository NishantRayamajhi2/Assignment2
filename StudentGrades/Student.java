
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String lastName;
    private String firstName;
    private int StudentID;
    private double a1, a2, a3;
    
    public Student(String lastName,String firstName,int StudentID,  double a1, double a2, double a3){
        this.lastName=lastName;
        this.firstName=firstName;
        this.StudentID=StudentID;
        this.a1=a1;
        this.a2=a2;
        this.a3=a3;
    }
    public double getTotalMarks(){
        double total = a1+a2+a3;
        return total;
    }
    @Override
    public String toString(){
        return String.format("%10  ")
    }
}