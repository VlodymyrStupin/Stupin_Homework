package ua.stupin.hw2;

public class task3 {
    public static void main(String[] args) {
        int number = 1;
        checkNumberEvenOrOddN(number);
    }
    private static void checkNumberEvenOrOddN(int number) {
        if (number %2==0){
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }
}
