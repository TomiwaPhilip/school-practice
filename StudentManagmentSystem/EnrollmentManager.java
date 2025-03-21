package StudentManagmentSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class to manage student enrollment and grades
public class EnrollmentManager {
    private Map<String, List<String>> studentCourses; // studentId -> List of courseIds
    private Map<String, Map<String, String>> studentGrades; // studentId -> (courseId -> grade)

    public EnrollmentManager() {
        this.studentCourses = new HashMap<>();
        this.studentGrades = new HashMap<>();
    }

    // Enroll a student in a course
    public void enrollStudentInCourse(String studentId, String courseId) {
        if (!studentCourses.containsKey(studentId)) {
            studentCourses.put(studentId, new ArrayList<>());
        }
        if (!studentCourses.get(studentId).contains(courseId)) { //prevent duplicate enrollments
             studentCourses.get(studentId).add(courseId);
        }

        if (!studentGrades.containsKey(studentId)) {
            studentGrades.put(studentId, new HashMap<>());
        }
    }

    // Get courses a student is enrolled in
    public List<String> getCoursesForStudent(String studentId) {
        return studentCourses.getOrDefault(studentId, new ArrayList<>());
    }

    // Assign a grade to a student for a course
    public void assignGrade(String studentId, String courseId, String grade) {
        if (studentGrades.containsKey(studentId)) {
            studentGrades.get(studentId).put(courseId, grade);
        } else {
            // Consider throwing an exception or handling the case where the student is not enrolled.
            System.out.println("Student is not enrolled in any courses or student does not exist.");
        }
    }

     // Get grade of a student for a course
    public String getGrade(String studentId, String courseId) {
        if (studentGrades.containsKey(studentId) && studentGrades.get(studentId).containsKey(courseId)) {
            return studentGrades.get(studentId).get(courseId);
        }
        return "N/A"; // Or handle as appropriate (e.g., return null, throw exception)
    }

    //Get all student grades.
    public Map<String, Map<String, String>> getStudentGrades() {
        return studentGrades;
    }
}
