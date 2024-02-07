package edu.mu.studentManager;

import edu.mu.student.Student;

public class StudentManager {
	private Student[] students;

	public void displayStudents() {
        if (students == null || students.length == 0) {
            System.out.println("No students to display");
        } else {
            System.out.println("Details of Students:");
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }
}
