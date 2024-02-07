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

}
