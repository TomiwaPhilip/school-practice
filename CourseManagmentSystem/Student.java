package CourseManagmentSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Course> enrolledCourses;
    private Map<Course, Double> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            System.out.println(name + " is already enrolled in " + course.getName());
            return;
        }
        if (course.getEnrolledStudents() >= course.getMaxCapacity()) {
            System.out.println("Course " + course.getName() + " is already full!");
            return;
        }
        enrolledCourses.add(course);
        course.incrementEnrolledStudents();
        System.out.println(name + " has been enrolled in " + course.getName());
    }

    public void assignGrade(Course course, double grade) {
        if (!enrolledCourses.contains(course)) {
            System.out.println(name + " is not enrolled in " + course.getName());
            return;
        }
        grades.put(course, grade);
        System.out.println("Grade assigned: " + name + " received " + grade + " in " + course.getName());
    }

    public double calculateOverallGrade() {
        if (grades.isEmpty()) return 0.0;
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }
}
