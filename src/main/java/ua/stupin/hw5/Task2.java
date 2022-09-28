package ua.stupin.hw5;

import java.util.Arrays;

//Проверить, заданный массив на упорядоченность по невозрастанию,
// т. е. определить, верно ли, что каждый его элемент, начиная со второго, не больше предыдущего.
//        *передать массив в метод, получить boolean
public class Task2 {
    public static void main(String[] args) {
        int[] noneOrderedArray = {5, 10, 3, 2, 1, 1};
        int[] copyNoneOrderedArray = new int[noneOrderedArray.length];
        System.arraycopy(noneOrderedArray, 0, copyNoneOrderedArray, 0, copyNoneOrderedArray.length);
        System.out.println(Arrays.toString(noneOrderedArray));
        System.out.println("Array is ordered by increase: " + checkArrayByNonIncrease(copyNoneOrderedArray));
    }

    public static boolean checkArrayByNonIncrease(int[] copyNoneOrderedArray) {
        boolean arrayIsOrderedByIncrease = false;
        for (int i = 1; i < copyNoneOrderedArray.length; i++) {
            if (copyNoneOrderedArray[i - 1] < copyNoneOrderedArray[i]) {
                arrayIsOrderedByIncrease = false;
                break;
            } else {
                arrayIsOrderedByIncrease = true;
            }
        }
        return arrayIsOrderedByIncrease;
    }
}
