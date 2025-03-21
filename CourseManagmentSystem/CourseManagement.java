package CourseManagmentSystem;

import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        courses.add(new Course(courseCode, name, maxCapacity));
        System.out.println("Course added: " + name);
    }

    public static void enrollStudent(Student student, String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                student.enrollInCourse(course);
                return;
            }
        }
        System.out.println("Course not found: " + courseCode);
    }

    public static void assignGrade(Student student, String courseCode, double grade) {
        for (Course course : student.getEnrolledCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                student.assignGrade(course, grade);
                return;
            }
        }
        System.out.println("Student is not enrolled in the course: " + courseCode);
    }

    public static List<Course> getCourses() {
        return courses;
    }
}
