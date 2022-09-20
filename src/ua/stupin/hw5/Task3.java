package ua.stupin.ua.stupin.hw5;

//Дан двумерный массив NxN(количество строк = количество столбцов),
// написать программу которая поменяет местами столбцы и строки.
//        *Необходимо создать новый массив, в котором выполняются превращения и вернуть его из метода.
//        Изначальный массив не должен измениться

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[][] twoDimensionalArray = new int[4][4];
        System.out.println("Filled array");
        fillTwoDimensionalArray(twoDimensionalArray);
        printFiledTwoDimensionalArray(twoDimensionalArray);
        System.out.println("Rotated array");
        for (int i = 0; i < rotateArray(twoDimensionalArray).length; i++) {
            for (int j = 0; j < rotateArray(twoDimensionalArray).length; j++) {
                System.out.print(rotateArray(twoDimensionalArray)[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Filled array after rotate");
        System.out.println(Arrays.deepToString(twoDimensionalArray));
    }
    public static int[][] fillTwoDimensionalArray(int[][] emptyTwoDimensionalArray) {
        for (int i = 0; i < emptyTwoDimensionalArray.length; i++) {
            for (int j = 0; j < emptyTwoDimensionalArray[i].length; j++) {
                emptyTwoDimensionalArray[i][j] = (int) (Math.random() * 10);
            }
        }
        return emptyTwoDimensionalArray;
    }
    public static int[][] printFiledTwoDimensionalArray(int[][] emptyTwoDimensionalArray) {
        for (int i = 0; i < emptyTwoDimensionalArray.length; i++) {
            for (int j = 0; j < emptyTwoDimensionalArray.length; j++) {
                System.out.print(emptyTwoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
        return emptyTwoDimensionalArray;
    }
    public static int[][] rotateArray(int[][] twoDimensionalArray) {
        int[][] newTwoDimensionalArray = new int[twoDimensionalArray[0].length][twoDimensionalArray.length];
        for (int i = 0; i < newTwoDimensionalArray.length; i++) {
            for (int j = 0; j < newTwoDimensionalArray[i].length; j++) {
                newTwoDimensionalArray[j][i] = twoDimensionalArray[i][j];
            }
        }
//        for (int i = 0; i < newTwoDimensionalArray.length; i++) {
//            for (int j = 0; j < newTwoDimensionalArray.length; j++) {
//                System.out.print(newTwoDimensionalArray[i][j] + " ");
//            }
//            System.out.println();
//        }
        return newTwoDimensionalArray;
    }
}