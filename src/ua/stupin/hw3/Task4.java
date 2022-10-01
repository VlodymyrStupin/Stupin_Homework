package ua.stupin.hw3;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Welcome to the show 'Guess the number'");
        int computerNumber = riddleNumber();
        int guestNumber = fortuitousNumber();
        checkNumber(computerNumber, guestNumber);
    }
    private static int riddleNumber() {
        Scanner a = new Scanner(System.in);
        System.out.println("Dear computer, please generate a number: ");
        int numberA = a.nextInt();
        return numberA;
    }
    private static int fortuitousNumber() {
        Scanner b = new Scanner(System.in);
        System.out.println("Dear guest, try to guess the number: ");
        int numberB = b.nextInt();
        return numberB;
    }
    private static int newNumber() {
        Scanner newNum = new Scanner(System.in);
        System.out.println(" Dear guest, try one more");
        int newNumber = newNum.nextInt();
        return newNumber;
    }
    private static void checkNumber(int computerNumber, int guestNumber) {
        while (computerNumber != guestNumber) {
            if (guestNumber > computerNumber) {
                System.out.print("Too much.");
                guestNumber = newNumber();
            } else if (guestNumber < computerNumber) {
                System.out.print("Too small.");
                guestNumber = newNumber();
            }
        }
        if (computerNumber == guestNumber){
            System.out.println("Congratulations, you guess the number");
        }
    }
}
