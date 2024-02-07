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

}
