package edu.mu.studentManagement;

<<<<<<< HEAD


public class Main {
=======
import edu.mu.studentManager.StudentManager;
>>>>>>> branch 'main' of git@github.com:azfcf/Group8-Homework-2.git

public class Main {
    public static void main(String[] args) {
        // Instantiate StudentManager, perform operations based on the requirements.
        StudentManager studentManager = new StudentManager();
        // Read student data from a file and initialize Student objects.
        boolean fileReadStatus = studentManager.readFromFile("studentData.txt");
        // Display all students.
        studentManager.displayStudents();
        // Search for a student by ID.
        boolean studentFound = studentManager.searchStudentById(101);
        // Update the grade of a student by ID.
        boolean studentGradeUpdateStatus = studentManager.updateStudentGradeById(102, 95);
        // Display all students after the update.
        studentManager.displayStudents();
    }
}
