import java.io.*;
import java.util.*;

// Student class to hold student details
class Student implements Serializable {
    private String name;
    private int rollNumber;
    private int marks;
    private String grade;

    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    // Calculate grade based on marks
    private String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "D";
    }

    public void displayInfo() {
        System.out.println("=== Student Details ===");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

// Main CLI System
public class StudentGradeSystemCLI {
    private static Map<Integer, Student> students = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        // Load saved students
        loadStudents();

        int mainChoice;
        do {
            System.out.println("\n=== STUDENT GRADE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. Login Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            mainChoice = safeIntInput();

            switch (mainChoice) {
                case 1 -> addStudent();
                case 2 -> loginStudent();
                case 3 -> {
                    saveStudents();
                    System.out.println("Exiting... Data saved successfully.");
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (mainChoice != 3);

        sc.close();
    }

    private static void addStudent() {
        System.out.print("Enter roll number: ");
        int roll = safeIntInput();
        if (students.containsKey(roll)) {
            System.out.println("Student with this roll number already exists!");
            return;
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks: ");
        int marks = safeIntInput();

        Student s = new Student(name, roll, marks);
        students.put(roll, s);
        saveStudents();
        System.out.println("Student record added successfully!");
    }

    private static void loginStudent() {
        System.out.print("Enter roll number: ");
        int roll = safeIntInput();

        Student s = students.get(roll);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        int choice;
        do {
            System.out.println("\n=== STUDENT MENU ===");
            System.out.println("1. View Student Info");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");

            choice = safeIntInput();

            switch (choice) {
                case 1 -> s.displayInfo();
                case 2 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 2);
    }

    // Input safety
    private static int safeIntInput() {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.nextLine();
        }
        int val = sc.nextInt();
        sc.nextLine(); // clear buffer
        return val;
    }

    // Save student data
    private static void saveStudents() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load student data
    @SuppressWarnings("unchecked")
    private static void loadStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (HashMap<Integer, Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
