// Student.java
// Represents a student with multiple subject marks and a calculated grade

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> marks;
    private String grade;

    public Student(String name, ArrayList<Integer> marks) {
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    // Calculate grade based on average marks
    private String calculateGrade() {
        double average = getAverageMarks();

        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 60) return "C";
        else if (average >= 40) return "D";
        else return "F";
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public double getAverageMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return marks.isEmpty() ? 0 : total / (double) marks.size();
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Marks: " + marks + ", Average: " + String.format("%.2f", getAverageMarks()) + ", Grade: " + grade;
    }
}
