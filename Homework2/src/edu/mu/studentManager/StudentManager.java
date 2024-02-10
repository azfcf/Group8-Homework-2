package edu.mu.studentManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.mu.student.Student;

public class StudentManager {
	private Student[] students = new Student[50];





	public boolean readFromFile(String fileName) {

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
					
				}
				else { //EOF has been reached
					break;
				}
			}
			fileScanner.close();
			return true; //successfully opened file and initialized student objects
		} catch (FileNotFoundException e) { // in case file cannot be opened
			System.out.println("FILE COULD NOT BE OPENED!");
		}
		return false; //did not successfully open file and initialize student objects
	}
	
	public boolean searchStudentById(int id) {
		// Call findStudentByID method to search for students with given ID
		Student student = findStudentByID(id);
		// If a student is found, display the student details
		if(student != null) {
			System.out.println(student.toString()); // Display the student details
			return true;
		}
		// If no student is found, display a message
		System.out.println("No student found with ID " + id);
		return false;
	}
	
	private Student findStudentByID(int id) {
		// Check if the array is null or empty
		if (students == null || students.length == 0) {
			System.out.print("No students to display");
			return null;
		}
		
		// Search through the array of students for the specified ID
		for(Student student : students) {
			if(student.getId() == id) { 
				return student;
			}
		}

		return null;
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
            	//Check if current student is not null
            	if (student != null) {
            		//Print out the details of each student using the .toString() method
                	System.out.println(student.toString());
            	}
            }
        }
    }
	
	public boolean updateStudentGradeById(int id, double grade) { 
		Student student = findStudentByID(id);
		
		if(student != null) {
			 student.setGrade(grade);// change grade 
			 return true;
		}
		System.out.println("Can not find a student with ID" + id + " please insert working Id #");// failes to find student with id 
		return false;
	}

}
