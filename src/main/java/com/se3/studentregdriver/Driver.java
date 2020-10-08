/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se3.studentregdriver;

import com.se3.studentregistration.Course;
import com.se3.studentregistration.Student;
import com.se3.studentregistration.Module;
import java.util.ArrayList;
import org.joda.time.LocalDate;

/**
 *
 * @author Aaron
 */
public class Driver {
    
    public static void main(String[] args) {
        LocalDate startDate = new LocalDate(2020, 9, 28);
        LocalDate endDate = new LocalDate(2021, 5, 28);

        // Courses
        Course cs = new Course("CS & IT", startDate, endDate);
        Course ee = new Course("Electronic & Computer Engineering", startDate, endDate);
        Course be = new Course("Biomedical Engineering", startDate, endDate);

        // Modules
        Module ma180 = new Module("Mathematics", 180, "Mathematics...", "Dr. Patrick Flynn");
        Module ma181 = new Module("Calculus", 180, "Calculus...", "Dr. Patrick Flynn");
        Module cs100 = new Module("Programming", 100, "Programming", "Dr. Jane Walsh");
        Module cs101 = new Module("Computer Hardware", 101, "Computer Hardware...", "Dr. Jane Walsh");
        Module cs102 = new Module("Software Engineering", 180, "Software Engineering...", "Dr. Alex Blake");
        Module en150 = new Module("Engineering Fundamentals", 150, "Engineering Fundamentals...", "Dr. John O'Connor");
        Module ph160 = new Module("Physics", 160, "Physics...", "Dr. Anne O'Reilly");
        Module cm170 = new Module("Chemistry", 170, "Chemistry...", "Dr. Peter Ward");

        // Students
        Student s1 = new Student("Ciaran Hughes", 21, "22/04/1999", 100, "ch@gmail.com", "Address....", "08623144444");
        Student s2 = new Student("Jack Kennedy", 20, "02/06/2000", 101, "jk@gmail.com", "Address....", "08623144445");
        Student s3 = new Student("Hugh O'Connell", 21, "20/07/1999", 102, "hoc@gmail.com", "Address....", "08623144446");
        Student s4 = new Student("Jake Tiernan", 21, "15/08/1999", 103, "jt@gmail.com", "Address....", "08623144447");
        Student s5 = new Student("Hugh Black", 23, "23/08/1998", 104, "hb@gmail.com", "Address....", "08623144448");
        Student s6 = new Student("Cathal O'Grady", 21, "09/03/1999", 105, "cog@gmail.com", "Address....", "08623144449");
        Student s7 = new Student("Arshia Loughnane", 20, "12/11/1999", 106, "al@gmail.com", "Address....", "08623144450");
        Student s8 = new Student("Kerri Dhiman ", 21, "22/04/1999", 107, "kd@gmail.com", "Address....", "08623144451");
        Student s9 = new Student("Shauna Gallagher", 21, "07/02/1999", 100, "sg@gmail.com", "Address....", "086231444452");
        Student s10 = new Student("Katie O'Connor", 21, "10/09/1999", 100, "koc@gmail.com", "Address....", "08623144453");

        // Add Students to Courses
        cs.addStudent(s1);
        cs.addStudent(s2);
        cs.addStudent(s3);
        cs.addStudent(s4);
        ee.addStudent(s5);
        ee.addStudent(s6);
        ee.addStudent(s7);
        be.addStudent(s8);
        be.addStudent(s9);
        be.addStudent(s10);

        // Add Modules to Courses
        cs.addModule(ma180);
        cs.addModule(cs100);
        cs.addModule(cs101);
        cs.addModule(cs102);
        
        ee.addModule(en150);
        ee.addModule(ma181);
        ee.addModule(ph160);
        ee.addModule(cs101);
        
        be.addModule(cm170);
        be.addModule(ma180);
        be.addModule(ph160);
        be.addModule(en150);

        // Add Students and courses to Modules
        Course[] courses = {cs, ee, be};
        
        for (Course c : courses) {
            c.getModules().stream().forEach(m -> {
                m.addCourse(c);
                c.getStudents().stream().forEach(s -> {
                    m.addStudent(s);
                    s.addModule(m);
                });
            });
            c.getStudents().stream().forEach(s -> s.addCourse(c));
        }
        
        // Print out Courses & their Modules
        for(Course c : courses) {
            System.out.println(c);
            c.getModules().stream().forEach(m -> System.out.println(m));
            System.out.println("\n");
        }
        
        
        Student[] students = { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 };
        // Print out Students, their courses & modules
        for(Student s : students) {
            System.out.println(s);
            s.getCourses().stream().forEach(c -> System.out.println(c));
            s.getModules().stream().forEach(m -> System.out.println(m));
            System.out.println("\n");
        }
    }
}
