/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import inputter.Inputter;
import model.StudentList;

/**
 *
 * @author Khoa Bug
 */
public class StudentManagement {

    public static void menu() {
        System.out.println("1. List\n2. Search\n3.Add new\n4.Exit");
    }

    public static void menu_search() {
        System.out.println("1.Search Gender\n2.Search ID");
    }

    public static void main(String[] args) {
        StudentManagement s11= new StudentManagement();
        
        StudentList s = new StudentList();
        if(s.readTextFile("src\\model\\student.txt")) 
            System.out.println("Success!");
        StudentManagement.menu();
        int choice = Inputter.getInputInt("Enter your choice:");
        do {
            switch (choice) {
                case 1:
                    s.listStudent();
                    return;
                case 2:
                    StudentManagement.menu_search();
                    int choice2 = Inputter.getInputInt("Enter your chocie: ");
                    switch (choice2) {
                        case 1:
                            String gender = Inputter.getInputString("Enter gender to search: ");
                            s.seachIf(t->t.getGender().equalsIgnoreCase(gender));
                            break;
                        case 2: 
                            String Id = Inputter.getInputString("Enter ID to search: ");
                            s.seachIf(t->t.getStudentID().equalsIgnoreCase(Id));
                            break;
                    }
                    break;
                case 3:
                    if(!s.addNewStudent()){
                        System.out.println("--");
                    }
                    break;
                case 4:
                    System.out.println("GoodBye!!!");
                    break;

                default:
                    System.out.println("Invalid Input!!\n");
                    break;
            }
        } while (choice != 4);
    }

}
