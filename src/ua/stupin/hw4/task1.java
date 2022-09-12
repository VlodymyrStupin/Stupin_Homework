package ua.stupin.hw4;

public class task1 {
    public static void main(String[] args) {
        int[] arrayFourHundred = new int[400];
        for (int i = 0; i < arrayFourHundred.length; i++) {
            arrayFourHundred[i] = (1 + (int) (Math.random() * 11));
        }
        int arithmeticAverage = getArithmeticAverage(arrayFourHundred);
        System.out.println("Arithmetic average from arrays = " + arithmeticAverage);
        double geometricMean = getGeometricMean(arrayFourHundred);
        System.out.println("Geometric mean from arrays= " + geometricMean);
    }
    private static int getArithmeticAverage(int[] arrayFourHundred) {
        int sum = 0;
        int dividedNumber;
        for (int i = 0; i < arrayFourHundred.length; i++) {
            sum += arrayFourHundred[i];
        }
        dividedNumber = sum / arrayFourHundred.length;
        return dividedNumber;
    }
    private static double getGeometricMean(int[] arrayFourHundred) {
        double multiplication = 1;
        for (int i = 0; i < arrayFourHundred.length; i++) {
            multiplication *= arrayFourHundred[i];
        }
        return Math.pow(multiplication, 1.0/arrayFourHundred.length);
    }
}
