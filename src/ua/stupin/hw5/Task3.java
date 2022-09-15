package ua.stupin.ua.stupin.hw5;

//Дан двумерный массив NxN(количество строк = количество столбцов),
// написать программу которая поменяет местами столбцы и строки.
//        *Необходимо создать новый массив, в котором выполняются превращения и вернуть его из метода.
//        Изначальный массив не должен измениться

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[][] twoDimensionalArray = new int [2][2];
        int[][] emptyTwoDimensionalArray = new int[twoDimensionalArray.length][twoDimensionalArray.length];
        System.arraycopy(twoDimensionalArray, 0, emptyTwoDimensionalArray, 0, emptyTwoDimensionalArray.length);
        twoDimensionalArray = filedTwoDimensionalArray(emptyTwoDimensionalArray);
        System.out.println("");
        rotateArray(twoDimensionalArray);
    }


    public static int[][] filedTwoDimensionalArray(int[][] emptyTwoDimensionalArray){
        for (int i = 0; i < emptyTwoDimensionalArray.length; i++) {
            for (int j = 0; j < emptyTwoDimensionalArray[i].length; j++) {
                emptyTwoDimensionalArray[i][j] = (int)(Math.random()*10);
            }
        }
        for (int i = 0; i < emptyTwoDimensionalArray.length; i++){
            for (int j = 0; j < emptyTwoDimensionalArray.length; j++){
                System.out.print(emptyTwoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
        return  emptyTwoDimensionalArray;
    }

    public static int[][] rotateArray (int[][] twoDimensionalArray){
        int [][] newTwoDimensionalArray = new int[twoDimensionalArray[0].length][twoDimensionalArray.length];
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                newTwoDimensionalArray[j][i] = twoDimensionalArray[i][j];
            }
        }
        for (int i = 0; i < newTwoDimensionalArray.length; i++){
            for (int j = 0; j < newTwoDimensionalArray.length; j++){
                System.out.print(newTwoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
        return  newTwoDimensionalArray;
    }

}
