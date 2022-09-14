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
        int[][] twoDimensionalArray = new int[5][5];
        int[][] emptyTwoDimensionalArray = new int[twoDimensionalArray.length][twoDimensionalArray.length];
        System.arraycopy(twoDimensionalArray, 0, emptyTwoDimensionalArray, 0, emptyTwoDimensionalArray.length);
        fillTwoDimensionalArray(emptyTwoDimensionalArray);
    }

    public static int[][] fillTwoDimensionalArray(int[][] emptyTwoDimensionalArray){
        for (int i = 0; i < emptyTwoDimensionalArray.length; i++) {
            for (int j = 0; j < emptyTwoDimensionalArray[i].length; j++) {
                if(i % 2 == 0){
                    emptyTwoDimensionalArray[i][j] = -j - 1;
                } else {
                    emptyTwoDimensionalArray[i][j] = j + 1;
                }
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
}
