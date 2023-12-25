package model;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Student implements Comparable<Student> {
    private String studentID,firstName,lastName,gender;
    private LocalDate dob;
    
    public Student(){
        
    }
    // Method 2:
    public Student(String id){
        this.studentID = id;
    }
    public Student(String studentID, String firstName, String lastName, String gender, String dob) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dob = LocalDate.parse(dob,f);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

   

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob + '}';
    }
    @Override
    public int compareTo(Student o) {
        return this.lastName.compareTo(o.lastName);
    }

}
