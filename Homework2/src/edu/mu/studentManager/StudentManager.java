package edu.mu.studentManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.mu.student.Student;

public class StudentManager {
	private Student[] students = new Student[50];





	public boolean readFromFile(String fileName) {
		
		/*
		 * Goals
		 * -read input from a file
		 * -initialize student objects
		 * -return true if file was read successfully
		 * -false if file was not read successfully
		 */
		try {
			
			File studentData = new File(fileName);
			Scanner fileScanner = new Scanner(studentData);
			
			for(int i = 0; i < students.length; i++) {
				if(fileScanner.hasNext()) { //Checks if EOF
					Student student = new Student();
					
					int id = fileScanner.nextInt();
					String name = fileScanner.next() + " " + fileScanner.next();
					double grade = fileScanner.nextDouble();
					
					student.setId(id);
					student.setName(name);
					student.setGrade(grade);
					
					//adds student object to array
					students[i] = student;
					
					System.out.println(students[i].toString());
				}
				else { //EOF has been reached
					break;
				}
			}
			fileScanner.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("FILE COULD NOT BE OPENED!");
		}
		return false;
	}
	
	public boolean searchStudentById(int id) {
		// Check if the array is null or empty
		if (students == null || students.length == 0) {
			System.out.print("No students to display");
			return false;
		}
		// Search through the array of students for the specified ID
		for(Student student : students) {
			if(student.getId() == id) { 
				System.out.println(student.toString()); // Display the student details
				return true;
			}
		}
		// If no student is found, display a message
		System.out.println("No student found with ID " + id);
		return false;
	}

	public void displayStudents() {
        //Check if the array is null or empty
		if (students == null || students.length == 0) {
			//Print out message if there are no students to display
            System.out.println("No students to display");
        } else {
        	//Print out a header to display the list of students
            System.out.println("Details of Students:");
            //Go through the students array
            for (Student student : students) {
            	//Print out the details of each student using the .toString() method
                System.out.println(student.toString());
            }
        }
    }
	
	public boolean updateStudentGradeById(int id, double grade) { 
		if ( students == null || students.length == 0) {// test to see if student exsist or if students array has a student in it at all 
			System.out.println("No Student to Update.");
			return false;
		}
		
		boolean studentDoesExist = searchStudentById(id);// call  searchStudent function to check if the id that was inserted matches with the id of a student in the array 
		if (studentDoesExist) {// if student does exist then go to change grade 
			
			 for (Student student : students) {// loop through students 
				 if (student.getId()==id) {// check to make sure ID match 
				 student.setGrade(grade);// change grade 
				 System.out.println("Student Grade updated");//print
				 return true;
				 }
			 }
		}
		else {
			System.out.println("Can not find a student with ID" + id + " please insert working Id #");// failes to find student with id 
		}
		return false ;
	}

}
