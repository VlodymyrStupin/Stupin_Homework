package ua.stupin.hw10;

import java.util.Objects;

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

    public int getScholarship() {
        if (averageMark == 5) {
            return 100;
        }
        return 80;
    }
    public boolean equals(ua.stupin.hw10.Aspirant aspirant) {
        return (this.firstName.equals(aspirant.firstName) &&
                this.lastName.equals(aspirant.lastName) &&
                this.group.equals(aspirant.group) &&
                this.averageMark == aspirant.averageMark);
    }


    public int hashCode() {
        return Objects.hash(firstName, lastName, group, averageMark);
    }
}



