package ua.stupin.hw11;

import ua.stupin.hw10.Aspirant;
import ua.stupin.hw10.Student;

public class Task1 {
    public static void main(String[] args) {
        Student[] students = new Student[8];
        students[0] = new Student("Bob", "Marley", "A1", 5);
        students[1] = new Student("John", "Lennon", "A1", 4.38);
        students[2] = new Student("Bob", "Dylan", "A1", 2.5);
        students[3] = new Student("Bob", "Dylan", "A1", 2.5);
        students[4] = new Aspirant("Bob", "Dylan", "A2", 2.5, "Bob's science work");
        students[5] = new Aspirant("Freddie", "Mercury", "A1", 5, "Freddie's science work");
        students[6] = new Aspirant("Freddie", "Mercury", "A1", 5, "Freddie's science work");
        students[7] = new Aspirant("Freddie", "Cruger", "A1", 5, "Freddie's science work");
        for (int i = 0; i < 4; i++) {
            System.out.println("Equals for student[0] with other students - " + students[0].equals(students[i]));
            System.out.println("Equals for student[1] with other students - " + students[1].equals(students[i]));
            System.out.println("Equals for student[2] with other students - " + students[2].equals(students[i]));
            System.out.println("Equals for student[3] with other students - " + students[3].equals(students[i]));
        }
        for (int i = 4; i <= 7; i++) {
            System.out.println("Equals for student[4] with other students - " + students[4].equals(students[i]));
            System.out.println("Equals for student[5] with other students - " + students[5].equals(students[i]));
            System.out.println("Equals for student[6] with other students - " + students[6].equals(students[i]));
            System.out.println("Equals for student[7] with other students - " + students[7].equals(students[i]));
        }
        for (int i = 4; i < students.length; i++) {
            System.out.println("Hash code for student[0] " + students[i].hashCode());
        }
    }
}
