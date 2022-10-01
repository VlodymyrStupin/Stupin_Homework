package ua.stupin.ua.stupin.hw2;

public class Task4 {
    public static void main(String[] args) {
        int firstNumber = -4;
        int secondNumber = 2;
        int thirdNumber = 5;
        lessNumber(firstNumber, secondNumber, thirdNumber);
    }
    private static void lessNumber(int firstNumber, int secondNumber, int thirdNumber) {
        int moduleFirstNumber = firstNumber >= 0 ? firstNumber : -firstNumber;
        int moduleSecondNumber = secondNumber >= 0 ? secondNumber : -secondNumber;
        int moduleThirdNumber = thirdNumber >= 0 ? thirdNumber : -thirdNumber;
        if (moduleFirstNumber < moduleSecondNumber && moduleFirstNumber < moduleThirdNumber) {
            System.out.println(firstNumber);
        } else if (moduleSecondNumber < moduleThirdNumber) {
            System.out.println(secondNumber);
        }else{
            System.out.println(thirdNumber);
        }
    }
}
