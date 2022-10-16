package ua.stupin.hw10;

import java.util.Objects;

public class Student {
    public String firstName;
    public String lastName;
    public String group;
    public double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public int getScholarship() {
        if (averageMark == 5) {
            return 100;
        }
        return 80;
    }


    public boolean equals(Student student) {
        return (this.firstName.equals(student.firstName) &&
                this.lastName.equals(student.lastName) &&
                this.group.equals(student.group) &&
                this.averageMark == student.averageMark);
    }

    public int hashCode(){
        return Objects.hash(firstName, lastName, group, averageMark);
    }
}


    public boolean equals(Student student) {
        return (this.firstName.equals(student.firstName) &&
                this.lastName.equals(student.lastName) &&
                this.group.equals(student.group) &&
                this.averageMark == student.averageMark);
    }

    public int hashCode(){
        return Objects.hash(firstName, lastName, group, averageMark);
    }
}

