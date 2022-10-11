package ua.stupin.hw10;

import java.util.Objects;

public class Studdent {
    public String firstName;
    public String lastName;
    public String group;
    public double averageMark;

    public Studdent(String firstName, String lastName, String group, double averageMark) {
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

    public boolean equals(Studdent studdent) {
        return (this.firstName.equals(studdent.firstName) &&
                this.lastName.equals(studdent.lastName) &&
                this.group.equals(studdent.group) &&
                this.averageMark == studdent.averageMark);
    }

    public int hashCode(){
        return Objects.hash(firstName, lastName, group, averageMark);
    }
}
