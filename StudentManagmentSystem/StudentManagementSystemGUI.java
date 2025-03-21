package StudentManagmentSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


// Main class for the Student Management System GUI
public class StudentManagementSystemGUI extends JFrame {

    private List<Student> studentList;
    private List<Course> courseList;
    private EnrollmentManager enrollmentManager;
    private JTable studentTable;
    private DefaultTableModel studentTableModel;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> studentComboBox; //for grade assignment
    private JComboBox<String> studentListComboBox; // for enrolling student to course
    private JComboBox<String> courseListComboBox;  //for grade assignment
    private JTextField studentIdField, firstNameField, lastNameField, majorField;
    private JTextField updateStudentIdField, updateFirstNameField, updateLastNameField, updateMajorField;
    private JTextField gradeField; // for grade assignment
    private JTextArea studentDetailsTextArea; // for viewing student details
    private JButton addStudentButton, updateStudentButton, viewStudentButton;
    private JButton enrollStudentButton;
    private JButton assignGradeButton;
    private JMenuBar menuBar;
    private JMenu fileMenu, studentMenu, courseMenu;
    private JMenuItem addStudentMenuItem, updateStudentMenuItem, viewStudentMenuItem;
    private JMenuItem enrollStudentMenuItem;
    private JMenuItem assignGradeMenuItem;

    // Constructor to initialize the GUI
    public StudentManagementSystemGUI() {
        // Initialize data structures
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
        enrollmentManager = new EnrollmentManager();

        // Initialize GUI components
        initializeUI();
        // Load initial data (optional, for demonstration)
        loadInitialData();
    }

    // Method to initialize the GUI components
    private void initializeUI() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Top panel for title
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Student Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Center panel for main content (using GridBagLayout for more flexibility)
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

        // Student Management Section
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        JLabel studentManagementLabel = new JLabel("Student Management");
        studentManagementLabel.setFont(new Font("Arial", Font.BOLD, 18));
        centerPanel.add(studentManagementLabel, gbc);
        gbc.gridwidth = 1; //reset

        // Student ID Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel studentIdLabel = new JLabel("Student ID:");
        centerPanel.add(studentIdLabel, gbc);

        gbc.gridx = 1;
        studentIdField = new JTextField(10);
        centerPanel.add(studentIdField, gbc);

        // First Name Label and Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel firstNameLabel = new JLabel("First Name:");
        centerPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        firstNameField = new JTextField(10);
        centerPanel.add(firstNameField, gbc);

        // Last Name Label and Field
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lastNameLabel = new JLabel("Last Name:");
        centerPanel.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        lastNameField = new JTextField(10);
        centerPanel.add(lastNameField, gbc);

        // Major Label and Field
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel majorLabel = new JLabel("Major:");
        centerPanel.add(majorLabel, gbc);

        gbc.gridx = 1;
        majorField = new JTextField(10);
        centerPanel.add(majorField, gbc);

        // Add Student Button
        gbc.gridx = 0;
        gbc.gridy = 5;
        addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        centerPanel.add(addStudentButton, gbc);

        // Update Student Section
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        JLabel updateStudentLabel = new JLabel("Update Student");
        updateStudentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        centerPanel.add(updateStudentLabel, gbc);
        gbc.gridwidth = 1;

        // Update Student ID Label and Field
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel updateStudentIdLabel = new JLabel("Student ID to update:");
        centerPanel.add(updateStudentIdLabel, gbc);
        gbc.gridx = 1;
        updateStudentIdField = new JTextField(10);
        centerPanel.add(updateStudentIdField, gbc);

        // Update First Name Label and Field
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel updateFirstNameLabel = new JLabel("First Name:");
        centerPanel.add(updateFirstNameLabel, gbc);

        gbc.gridx = 1;
        updateFirstNameField = new JTextField(10);
        centerPanel.add(updateFirstNameField, gbc);

        // Update Last Name Label and Field
        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel updateLastNameLabel = new JLabel("Last Name:");
        centerPanel.add(updateLastNameLabel, gbc);

        gbc.gridx = 1;
        updateLastNameField = new JTextField(10);
        centerPanel.add(updateLastNameField, gbc);

        // Update Major Label and Field
        gbc.gridx = 0;
        gbc.gridy = 10;
        JLabel updateMajorLabel = new JLabel("Major:");
        centerPanel.add(updateMajorLabel, gbc);

        gbc.gridx = 1;
        updateMajorField = new JTextField(10);
        centerPanel.add(updateMajorField, gbc);

        // Update Student Button
        gbc.gridx = 0;
        gbc.gridy = 11;
        updateStudentButton = new JButton("Update Student");
        updateStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });
        centerPanel.add(updateStudentButton, gbc);

        // View Student Button
        gbc.gridx = 1;
        gbc.gridy = 11;
        viewStudentButton = new JButton("View Students");
        viewStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudents();
            }
        });
        centerPanel.add(viewStudentButton, gbc);

        // Student Details Text Area
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        studentDetailsTextArea = new JTextArea(5, 20);
        studentDetailsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(studentDetailsTextArea);
        centerPanel.add(scrollPane, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // Course Enrollment Section
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        JLabel courseEnrollmentLabel = new JLabel("Course Enrollment");
        courseEnrollmentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        centerPanel.add(courseEnrollmentLabel, gbc);
        gbc.gridwidth = 1;

        // Student List ComboBox for enrolling
        gbc.gridx = 0;
        gbc.gridy = 14;
        JLabel studentListLabel = new JLabel("Select Student:");
        centerPanel.add(studentListLabel, gbc);

        gbc.gridx = 1;
        studentListComboBox = new JComboBox<>();
        centerPanel.add(studentListComboBox, gbc);

        // Course List ComboBox for enrolling
        gbc.gridx = 0;
        gbc.gridy = 15;
        JLabel courseListLabel = new JLabel("Select Course:");
        centerPanel.add(courseListLabel, gbc);

        gbc.gridx = 1;
        courseListComboBox = new JComboBox<>();
        centerPanel.add(courseListComboBox, gbc);

        // Enroll Student Button
        gbc.gridx = 0;
        gbc.gridy = 16;
        enrollStudentButton = new JButton("Enroll Student");
        enrollStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enrollStudent();
            }
        });
        centerPanel.add(enrollStudentButton, gbc);

        // Grade Assignment Section
        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        JLabel gradeAssignmentLabel = new JLabel("Grade Assignment");
        gradeAssignmentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        centerPanel.add(gradeAssignmentLabel, gbc);
        gbc.gridwidth = 1;

        // Student ComboBox
        gbc.gridx = 0;
        gbc.gridy = 18;
        JLabel studentLabel = new JLabel("Select Student:");
        centerPanel.add(studentLabel, gbc);

        gbc.gridx = 1;
        studentComboBox = new JComboBox<>();
        centerPanel.add(studentComboBox, gbc);

        // Course ComboBox
        gbc.gridx = 0;
        gbc.gridy = 19;
        JLabel courseLabel = new JLabel("Select Course:");
        centerPanel.add(courseLabel, gbc);

        gbc.gridx = 1;
        courseComboBox = new JComboBox<>();
        centerPanel.add(courseComboBox, gbc);

        // Grade Label and Field
        gbc.gridx = 0;
        gbc.gridy = 20;
        JLabel gradeLabel = new JLabel("Grade:");
        centerPanel.add(gradeLabel, gbc);

        gbc.gridx = 1;
        gradeField = new JTextField(5);
        centerPanel.add(gradeField, gbc);

        // Assign Grade Button
        gbc.gridx = 0;
        gbc.gridy = 21;
        assignGradeButton = new JButton("Assign Grade");
        assignGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignGrade();
            }
        });
        centerPanel.add(assignGradeButton, gbc);

        // Add the center panel to the main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Bottom panel for status messages (optional)
        JPanel statusPanel = new JPanel();
        JLabel statusLabel = new JLabel("Ready");
        statusPanel.add(statusLabel);
        mainPanel.add(statusPanel, BorderLayout.SOUTH);

        // Set the main panel as the content pane
        setContentPane(mainPanel);

        // Create menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create menus
        fileMenu = new JMenu("File");
        studentMenu = new JMenu("Student");
        courseMenu = new JMenu("Course");

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(studentMenu);
        menuBar.add(courseMenu);

        // Create menu items
        addStudentMenuItem = new JMenuItem("Add Student");
        updateStudentMenuItem = new JMenuItem("Update Student");
        viewStudentMenuItem = new JMenuItem("View Students");
        enrollStudentMenuItem = new JMenuItem("Enroll Student");
        assignGradeMenuItem = new JMenuItem("Assign Grade");

        // Add menu items to menus
        studentMenu.add(addStudentMenuItem);
        studentMenu.add(updateStudentMenuItem);
        studentMenu.add(viewStudentMenuItem);
        courseMenu.add(enrollStudentMenuItem);
        courseMenu.add(assignGradeMenuItem);

        // Add action listeners to menu items (using the same methods as buttons)
        addStudentMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        updateStudentMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });
        viewStudentMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudents();
            }
        });
        enrollStudentMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enrollStudent();
            }
        });
        assignGradeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignGrade();
            }
        });

        // Create the student table
        studentTableModel = new DefaultTableModel(new Object[]{"Student ID", "First Name", "Last Name", "Major"}, 0);
        studentTable = new JTable(studentTableModel);
        JScrollPane tableScrollPane = new JScrollPane(studentTable);
        tableScrollPane.setPreferredSize(new Dimension(700, 100)); // Adjust size as needed
        gbc.gridx = 0;
        gbc.gridy = 22;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        centerPanel.add(tableScrollPane, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // Make the window visible
        setVisible(true);
    }

    // Method to load initial data (for demonstration purposes)
    private void loadInitialData() {
        // Add some initial students
        studentList.add(new Student("1001", "Alice", "Smith", "Computer Science"));
        studentList.add(new Student("1002", "Bob", "Johnson", "Engineering"));
        studentList.add(new Student("1003", "Charlie", "Brown", "Business"));

        // Add some initial courses
        courseList.add(new Course("CS101", "Introduction to Programming"));
        courseList.add(new Course("EN202", "Circuit Analysis"));
        courseList.add(new Course("BA301", "Principles of Marketing"));

        // Populate the combo boxes
        populateStudentComboBoxes();
        populateCourseComboBoxes();
    }

    // Method to populate student combo boxes
    private void populateStudentComboBoxes() {
        studentComboBox.removeAllItems();
        studentListComboBox.removeAllItems();
        for (Student student : studentList) {
            studentComboBox.addItem(student.getStudentId() + " - " + student.getFullName());
            studentListComboBox.addItem(student.getStudentId() + " - " + student.getFullName());
        }
    }

     // Method to populate course combo boxes
    private void populateCourseComboBoxes() {
        courseComboBox.removeAllItems();
        courseListComboBox.removeAllItems();
        for (Course course : courseList) {
            courseComboBox.addItem(course.getCourseId() + " - " + course.getCourseName());
            courseListComboBox.addItem(course.getCourseId() + " - " + course.getCourseName());
        }
    }

    // Method to add a new student
    private void addStudent() {
        String studentId = studentIdField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String major = majorField.getText().trim();

        if (studentId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || major.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if student ID already exists
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                JOptionPane.showMessageDialog(this, "Student ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Student newStudent = new Student(studentId, firstName, lastName, major);
        studentList.add(newStudent);
        populateStudentComboBoxes(); // Update combo boxes after adding
        clearInputFields();
        JOptionPane.showMessageDialog(this, "Student added successfully.");
    }

    // Method to update an existing student
    private void updateStudent() {
        String studentIdToUpdate = updateStudentIdField.getText().trim();
        String newFirstName = updateFirstNameField.getText().trim();
        String newLastName = updateLastNameField.getText().trim();
        String newMajor = updateMajorField.getText().trim();

        if (studentIdToUpdate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the Student ID to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Student student : studentList) {
            if (student.getStudentId().equals(studentIdToUpdate)) {
                // Update student information
                if (!newFirstName.isEmpty()) {
                    student.setFirstName(newFirstName);
                }
                if (!newLastName.isEmpty()) {
                    student.setLastName(newLastName);
                }
                if (!newMajor.isEmpty()) {
                    student.setMajor(newMajor);
                }
                populateStudentComboBoxes();
                clearUpdateFields();
                JOptionPane.showMessageDialog(this, "Student information updated successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Student ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to view student details
    private void viewStudents() {
        studentTableModel.setRowCount(0); // Clear the table
        if (studentList.isEmpty()) {
            studentDetailsTextArea.setText("No students available.");
            return;
        }
        studentDetailsTextArea.setText(""); // Clear the text area
        for (Student student : studentList) {
            studentTableModel.addRow(new Object[]{student.getStudentId(), student.getFirstName(), student.getLastName(), student.getMajor()});
            studentDetailsTextArea.append(student.toString() + "\n");
        }
    }

    // Method to enroll a student in a course
    private void enrollStudent() {
        String studentCourseId = studentListComboBox.getSelectedItem().toString().split(" - ")[0];
        String courseIdToEnroll = courseListComboBox.getSelectedItem().toString().split(" - ")[0];

        // Input validation
        if (studentCourseId == null || courseIdToEnroll == null) {
            JOptionPane.showMessageDialog(this, "Please select a student and a course.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        enrollmentManager.enrollStudentInCourse(studentCourseId, courseIdToEnroll);
        JOptionPane.showMessageDialog(this, "Student enrolled in course successfully.");
    }

    // Method to assign a grade to a student for a course
    private void assignGrade() {
        String studentId = studentComboBox.getSelectedItem().toString().split(" - ")[0];
        String courseId = courseComboBox.getSelectedItem().toString().split(" - ")[0];
        String grade = gradeField.getText().trim();

        if (studentId == null || courseId == null || grade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a student, a course, and enter a grade.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Basic grade validation (you can customize this)
        if (!grade.matches("[A-F][+-]?|W|I|N/A")) {
            JOptionPane.showMessageDialog(this, "Invalid grade format.  Use A, B, C, D, E or F, optionally followed by + or -.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<String> courses = enrollmentManager.getCoursesForStudent(studentId);
        if (!courses.contains(courseId)){
            JOptionPane.showMessageDialog(this, "Student is not enrolled in this course.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        enrollmentManager.assignGrade(studentId, courseId, grade);
        gradeField.setText(""); // Clear grade field after assigning
        JOptionPane.showMessageDialog(this, "Grade assigned successfully.");
        displayStudentGrades(studentId);

    }

    // Method to display student grades.  Called after grade assignment.
    private void displayStudentGrades(String studentId) {
        Map<String, Map<String, String>> grades = enrollmentManager.getStudentGrades();
        if (grades == null || grades.isEmpty() || !grades.containsKey(studentId)) {
            studentDetailsTextArea.setText("No grades available for this student.");
            return;
        }

        Map<String, String> studentCourseGrades = grades.get(studentId);
        if (studentCourseGrades == null || studentCourseGrades.isEmpty())
        {
            studentDetailsTextArea.setText("No grades available for this student.");
            return;
        }
        StringBuilder sb = new StringBuilder("Student ID: " + studentId + "\n");
        sb.append("Course  \t\tGrade\n");
        for (Map.Entry<String, String> entry : studentCourseGrades.entrySet()) {
            String courseId = entry.getKey();
            String grade = entry.getValue();
            String courseName = "";
             for (Course course : courseList) {
                if (course.getCourseId().equals(courseId)) {
                    courseName = course.getCourseName();
                    break;
                }
            }
            sb.append(courseId + " - " + courseName +  "\t\t" + grade + "\n");
        }
        studentDetailsTextArea.setText(sb.toString());
    }

    // Method to clear input fields after adding a student
    private void clearInputFields() {
        studentIdField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        majorField.setText("");
    }

    // Method to clear update fields after updating a student
      private void clearUpdateFields() {
        updateStudentIdField.setText("");
        updateFirstNameField.setText("");
        updateLastNameField.setText("");
        updateMajorField.setText("");
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentManagementSystemGUI();
            }
        });
    }
}
