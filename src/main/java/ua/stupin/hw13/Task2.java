package ua.stupin.hw13;

import java.util.Arrays;

public class Task2 {

    public static void main(String args[]) {
        int[] array = {18, 22, 58, 49, 14, 2};
        Arrays.sort(array);
        int itemForSearch = 2;
        System.out.println("Element for binary search: " + itemForSearch);
        binarySearchInArray(array, itemForSearch);
    }

    public static int binarySearchInArray(int[] array, int itemForSearch) {
        int firstPosition = 0;
        int lastPosition = array.length - 1;
        int startPosition = (firstPosition + lastPosition) / 2;
        while ((array[startPosition] != itemForSearch) && (firstPosition <= lastPosition)) {
            if (array[startPosition] > itemForSearch) {
                lastPosition = startPosition - 1;
            } else {
                firstPosition = startPosition + 1;
            }
            startPosition = (firstPosition + lastPosition) / 2;
        }
        if (firstPosition <= lastPosition) {
            System.out.println(itemForSearch + " is " + ++startPosition + " element in array");
        } else {
            System.out.println("Array does not have wanted item");
        }
        return startPosition;
    }
}

