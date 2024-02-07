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
	
	public boolean updateStudentGradeById(int id, double grade) { 
		if ( student == null || students.length == 0) {// test to see if student exsist or if students array has a student in it at all 
			System.out.println("No Student to Update.");
			return false;
		}
		
		boolean studentDoesExist = searchStudentById(id);// call  searchStudent function to check if the id that was inserted matches with the id of a student in the array 
		if (studentDoesExist) {// if student does exist then go to change grade 
			
			 for (Student student : students) {// loop through students 
				 if (student.getId()==id) {// check to make sure ID match 
				 student.setGrade(grade);// change grade 
				 System.out.println("Student Grade updated");
				 return true;
				 }
			 }
		}
		else {
			System.out.println("Can not find a student with ID" + id + " please insert working Id #")// failes to find student with id 
		}
		return false ;
	}


}
