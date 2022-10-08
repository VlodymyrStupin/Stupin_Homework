package ua.stupin.hw10;

import java.util.Objects;

public class Aspirant extends Student {
    public String scienceWork;

    public Aspirant(String firstName, String lastName, String group, double averageMark, String scienceWork) {
        super(firstName, lastName, group, averageMark);
        this.scienceWork = scienceWork;
    }

    @Override
    public int getScholarship() {
        if (averageMark == 5) {
            return 200;
        }
        return 180;
    }

    public boolean equals(Aspirant aspirant) {
        return (this.firstName.equals(aspirant.firstName) &&
                this.lastName.equals(aspirant.lastName) &&
                this.group.equals(aspirant.group) &&
                this.averageMark == aspirant.averageMark) &&
                this.scienceWork.equals(aspirant.scienceWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, group, averageMark, scienceWork);
    }
}
