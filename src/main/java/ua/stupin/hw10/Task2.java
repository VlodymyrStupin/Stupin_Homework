package ua.stupin.hw10;

public class Task2 {
    public static void main(String[] args) {
        Pow power = (number, pow) -> {
            int resultOfCalculationNumberToPower = 1;
            for(int i = 0; i< pow; i++){
                resultOfCalculationNumberToPower *= number;
            }
            return resultOfCalculationNumberToPower;
        };
        System.out.println(power.calculate(5, 3));
    }
}

interface Pow {
    int calculate(int number, int pow);
}

