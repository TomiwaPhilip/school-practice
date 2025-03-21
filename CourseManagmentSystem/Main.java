package CourseManagmentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Example Students
        Student student1 = new Student("Alice", "S1001");
        Student student2 = new Student("Bob", "S1002");

        while (running) {
            System.out.println("\n=== Course Management System ===");
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll a student");
            System.out.println("3. Assign a grade");
            System.out.println("4. Calculate student’s overall grade");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter maximum capacity: ");
                    int maxCapacity = scanner.nextInt();
                    CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                    break;

                case 2:
                    System.out.print("Enter student ID (S1001 for Alice, S1002 for Bob): ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String enrollCourseCode = scanner.nextLine();

                    if (studentId.equals("S1001")) {
                        CourseManagement.enrollStudent(student1, enrollCourseCode);
                    } else if (studentId.equals("S1002")) {
                        CourseManagement.enrollStudent(student2, enrollCourseCode);
                    } else {
                        System.out.println("Invalid student ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    String gradeStudentId = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String gradeCourseCode = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();

                    if (gradeStudentId.equals("S1001")) {
                        CourseManagement.assignGrade(student1, gradeCourseCode, grade);
                    } else if (gradeStudentId.equals("S1002")) {
                        CourseManagement.assignGrade(student2, gradeCourseCode, grade);
                    } else {
                        System.out.println("Invalid student ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    String calcStudentId = scanner.nextLine();

                    if (calcStudentId.equals("S1001")) {
                        System.out.println("Overall Grade: " + student1.calculateOverallGrade());
                    } else if (calcStudentId.equals("S1002")) {
                        System.out.println("Overall Grade: " + student2.calculateOverallGrade());
                    } else {
                        System.out.println("Invalid student ID.");
                    }
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        scanner.close();
    }
}
