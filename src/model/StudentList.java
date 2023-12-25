package model;

import inputter.Inputter;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class StudentList extends ArrayList<Student> {

    // this 
    public void listStudent() {
        Collections.sort(this, (o1,o2)->o1.getStudentID().compareTo(o2.getStudentID()));
        System.out.println("List:");
        for (Student t : this) {
            System.out.println(t.toString());
        }
    }

    public boolean readTextFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        }
        try ( Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                String part[] = sc.nextLine().split(",");
                if (part.length == 6) {
                    String id = part[0].substring(11);
                    String fname = part[1].substring(11).trim();
                    String lname = part[2].substring(10).trim();
                    String age = part[3].substring(4).trim();
                    String d = part[4].substring(6).trim();
                    String gen = part[5].substring(8).trim();
                    Student s = new Student(id, fname, lname, gen, d);
                    this.add(s);
                }
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public int searchId(String id){
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).getStudentID().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }

    public boolean seachIf(Predicate<Student> predicate) {
        for (Student p : this) {
            if (predicate.test(p)) {
                System.out.println(p.toString());
                return true;
            }
        }
        return false;
    }
    
    public boolean addNewStudent(){
        String id = Inputter.getInputString("Enter ID: ");
        if(searchId(id)!= -1)
            return false;
        
        String fname = Inputter.getInputString("Enter FirstName: ");
        String lname = Inputter.getInputString("Enter FirstName: ");
        String dob = Inputter.inputStr("Enter DOB: ", "dd/MM/yyyy");
        String gen = Inputter.getInputString("Enter gender: ");
        this.add(new Student(id, fname, lname, gen, dob));
        
        return true;
    }
    
}
