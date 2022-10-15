package ua.stupin.hw13;

import java.util.Arrays;

// Реалізувати сортування пухирцем / бульбашкою
public class Task1 {
    public static void main(String[] args) {
        int[] array = {11, 3, 14, 16, 7};
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(array));
    }

    public static int[] bubbleSort(int[] array) {
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, sortedArray.length);
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    isSorted = false;

                    buf = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = buf;
                }
            }
        }
        return sortedArray;
    }
}
