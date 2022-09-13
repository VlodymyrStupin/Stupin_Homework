package ua.stupin.ua.stupin.practice2;
//        Известен рост каждого из 25 учеников класса. Рост мальчиков условно задан
//        отрицательными числами. Определить средний рост мальчиков и средний рост девочек.

public class Task2 {
    public static void main(String[] args) {
        int[] high = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                     -200, -200, -200, -200, -200, -200, -200, -200, -200, -200, -200, -200};
        System.out.println("Medium high girls is: " + mediumGirlsHigh(high));
        System.out.println("Medium high boys is: " + mediumBoysHigh(high));
    }

    public static int mediumGirlsHigh(int[] high) {
        int sumGirlsHigh = 0;
        int howManyGirls = 0;
        for (int i : high) {
            if (i > 0) {
                howManyGirls++;
                sumGirlsHigh += i;
            }
        }
        return (int)  sumGirlsHigh / howManyGirls;
    }
    public static int mediumBoysHigh(int[] high) {
        int sumBoysHigh = 0;
        int howManyBoys = 0;
        for (int i : high) {
            if (i < 0) {
                howManyBoys++;
                sumBoysHigh += Math.abs(i);
            }
        }
        return (int)  sumBoysHigh / howManyBoys;
    }
}
