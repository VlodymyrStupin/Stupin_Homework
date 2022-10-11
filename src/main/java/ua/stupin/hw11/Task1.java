package ua.stupin.hw11;

import ua.stupin.hw10.Aspirant;
import ua.stupin.hw10.Studdent;

public class Task1 {
    public static void main(String[] args) {
        Studdent[] studdents = new Studdent[4];
        studdents[0] = new Studdent("Bob", "Marley", "A1", 5);
        studdents[1] = new Studdent("John", "Lennon", "A1", 4.38);
        studdents[2] = new Aspirant("Bob", "Dylan", "A2", 2.5, "Bob's science work");
        studdents[3] = new Aspirant("Freddie", "Mercury", "A1", 5, "Freddie's science work");
        for (int i = 0; i < studdents.length - 1; i++) {
            for (int j = i + 1; j < studdents.length; j++) {
                if (studdents[i].getScholarship() > 100 && studdents[j].getScholarship() > 100){
                    System.out.println("Aspirant " + (i) + " and aspirant " + (j) + ": compare equals = "
                            + studdents[i].equals(studdents[j]) + ", compare hash code = "
                            + (studdents[i].hashCode() == studdents[j].hashCode()));
                } else if(studdents[i].getScholarship() <= 100 && studdents[j].getScholarship() <= 100) {
                    System.out.println("Studdent " + (i) + " and student " + (j) + ": compare equals = "
                            + studdents[i].equals(studdents[j]) + ", compare hash code = "
                            + (studdents[i].hashCode() == studdents[j].hashCode()));
                }
            }
        }
    }
}




