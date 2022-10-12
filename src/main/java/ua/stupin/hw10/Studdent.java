package ua.stupin.hw10;

public class Studdent {
    String firstName;
    String lastName;
    String group;
    double averageMark;

    Studdent(String firstName, String lastName, String group, double averageMark) {
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

    public static void main(String[] args) {
        Studdent[] studdents = new Studdent[5];
        studdents[0] = new Studdent("Bob", "Marley", "A1", 5);
        studdents[1] = new Studdent("John", "Lennon", "A2", 4.38);
        studdents[2] = new Studdent("Bob", "Dylan", "A2", 2.5);
        studdents[3] = new Aspirant("Bob", "Dylan", "A2", 2.5, "Bob's science work");
        studdents[4] = new Aspirant("Freddie", "Mercury", "A1", 5, "Freddie's science work");
        for (int i = 0; i < studdents.length; i++) {
            System.out.println(studdents[i].getScholarship());
        }
    }
}



