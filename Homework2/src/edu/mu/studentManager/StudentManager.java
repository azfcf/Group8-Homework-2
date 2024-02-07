package edu.mu.studentManager;

import edu.mu.student.Student;

public class StudentManager {
	private Student[] students;
	
	public boolean searchStudentById(int id) {
		for(Student student : students) {
			if(student.getId() == id) {
				System.out.println(student.toString());
				return true;
			}
		}
		return false;
	}

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
