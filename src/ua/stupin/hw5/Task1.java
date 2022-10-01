package ua.stupin.ua.stupin.hw5;

import java.util.Arrays;

//        Заполнение двумерного массива значениями индекса(от 1 и до кол-ва элементов в массиве),
//        при этом каждая вторая строка - отрицательными значениями.
//        Например
//        1 2 3
//        -4 -5 -6
//        7 8 9
//        -10 -11 -12
//        *Передать массив в метод, заполнить данный массив
public class Task1 {
    public static void main(String[] args) {
        int[][] twoDimensionalArray = new int[4][3];
        fillTwoDimensionalArray(twoDimensionalArray);
        printFilledArray(twoDimensionalArray);
    }

    public static int[][] fillTwoDimensionalArray(int[][] twoDimensionalArray) {
        int h = 1;
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                 if (i % 2 == 0) {
                    twoDimensionalArray[i][j] = h;
                    h++;
                } else {
                    twoDimensionalArray[i][j] = -h;
                    h++;
                }
            }
        }
        return twoDimensionalArray;
    }

    public static int[][] printFilledArray(int[][] twoDimensionalArray) {
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
        return twoDimensionalArray;
    }
}
