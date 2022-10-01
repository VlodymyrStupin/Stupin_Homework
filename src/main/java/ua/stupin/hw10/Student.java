package ua.stupin.hw10;

public class Student {
    String firstName;
    String lastName;
    String group;
    double averageMark;

    Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public String getScholarship() {
        if (averageMark == 5) {
            return "Scholarship for " + firstName + " " + lastName + " = 100 UAH";
        }
        return "Scholarship for " + firstName + " " + lastName + " = 80 UAH";
    }
}

class Aspirant extends Student {
    String scienceWork;

    Aspirant(String firstName, String lastName, String group, double averageMark, String scienceWork) {
        super(firstName, lastName, group, averageMark);
        this.scienceWork = scienceWork;
    }

    @Override
    public String getScholarship() {
        if (averageMark == 5) {
            return "Scholarship for " + firstName + " " + lastName + " = 200 UAH";
        }
        return "Scholarship for " + firstName + " " + lastName + " = 180 UAH";
    }

    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("Bob", "Marley", "A1", 5);
        students[1] = new Student("John", "Lennon", "A2", 4.38);
        students[2] = new Student("Bob", "Dylan", "A2", 2.5);
        students[3] = new Aspirant("Bob", "Dylan", "A2", 2.5, "Bob's science work");
        students[4] = new Aspirant("Freddie", "Mercury", "A1", 5, "Freddie's science work");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getScholarship());
        }
    }
}



