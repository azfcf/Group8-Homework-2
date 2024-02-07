package edu.mu.studentManager;

import edu.mu.student.Student;

public class StudentManager {
	private Student[] students;
	
	public boolean searchStudentById(int id) {
		// Search through the array of students for the specified ID
		for(Student student : students) {
			if(student.getId() == id) { 
				System.out.println(student.toString()); // Display the student details
				return true;
			}
		}
		// If no student is found, display a method
		System.out.println("No student found with ID " + id);
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
