package ua.stupin.ua.stupin.hw5;



//Удаление из массива k-го элемента со сдвигом всех расположенных справа от него элементов на одну позицию влево.
//Необходимо создать новый массив, в котором удаляется элемент и вернуть его из метода.
//Изначальный массив не должен измениться
//        [1, 2, 3, 4] -> [1, 2, 4]

import java.util.Arrays;
public class Task4 {
    public static void main(String[] args) {
        int[] justArray = {8, 6, 13, 4};
        int indexElementInArray = 2;
        int[] copyJustArray = new int[justArray.length];
        System.arraycopy(justArray, 0, copyJustArray, 0, justArray.length);
        deleteElementFromArrayAndShiftToLeft(copyJustArray, indexElementInArray);
        System.out.println("Original array " + Arrays.toString(justArray));
    }
    public static int[] deleteElementFromArrayAndShiftToLeft (int[] copyJustArray, int indexElementInArray) {
        int[] arrayWithDeleteElement = new int[copyJustArray.length - 1];
        int remainingElements = copyJustArray.length - ( indexElementInArray + 1 );
        System.arraycopy(copyJustArray, 0, arrayWithDeleteElement, 0, indexElementInArray);
        System.arraycopy(copyJustArray, indexElementInArray + 1, arrayWithDeleteElement, indexElementInArray, remainingElements);
        System.out.println("Array with deleted element and shift to left " +
                 Arrays.toString(arrayWithDeleteElement));
        return arrayWithDeleteElement;
    }
}
