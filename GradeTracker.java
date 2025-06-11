// GradeTracker.java
// Console-based student grade tracker using ArrayList

import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n Student Grade Tracker Menu");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Summary Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> showSummary();
                case 4 -> System.out.println(" Exiting program. Goodbye!");
                default -> System.out.println(" Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    private static void addStudent() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int subjectCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        ArrayList<Integer> marks = new ArrayList<>();
        for (int i = 1; i <= subjectCount; i++) {
            int mark;
            while (true) {
                System.out.print("Enter marks for subject " + i + " (0-100): ");
                mark = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (mark >= 0 && mark <= 100) break;
                System.out.println("Invalid marks. Please enter a number between 0 and 100.");
            }
            marks.add(mark);
        }

        students.add(new Student(name, marks));
        System.out.println(" Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println(" No students to display.");
            return;
        }

        System.out.println("\n List of Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void showSummary() {
    if (students.isEmpty()) {
        System.out.println(" No data available for summary.");
        return;
    }

    double total = 0;
    double highest = Double.MIN_VALUE;
    double lowest = Double.MAX_VALUE;
    String highestScorer = "";
    String lowestScorer = "";

    for (Student s : students) {
        double avg = s.getAverageMarks();
        total += avg;

        if (avg > highest) {
            highest = avg;
            highestScorer = s.getName();
        }
        if (avg < lowest) {
            lowest = avg;
            lowestScorer = s.getName();
        }
    }

    double overallAverage = total / students.size();

    System.out.println("\n Summary Report:");
    System.out.println("Total Students: " + students.size());
    System.out.printf("Average Marks (Overall): %.2f\n", overallAverage);
    System.out.printf("Highest Average Marks: %.2f by %s\n", highest, highestScorer);
    System.out.printf("Lowest Average Marks: %.2f by %s\n", lowest, lowestScorer);
}
}
