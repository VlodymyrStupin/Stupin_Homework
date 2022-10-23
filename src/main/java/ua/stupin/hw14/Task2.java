package ua.stupin.hw14;

import java.util.Arrays;

/*
Реализовать класс-утилиту которая содержит два generic метода (статический и не статический):
Метод 1: принимает любое значение и выводит ***{значение}***
Метод 2: принимает массив любого типа и выводит его содержание
 */
public class Task2 {
    public static void main(String[] args) {
        Integer[] myArray1 = new Integer[]{1, 5, 5, 5};
        Double[] myArray2 = new Double[]{1.16, 9.78, 5999.2, 50.0};
        Character[] myArray3 = new Character[]{'1', 'a', 'b', 'G'};
        Utility.getAnyVariable(true);
        Utility.getAnyVariable(0.57);
        Utility.getAnyVariable("true");
        Utility.getAnyVariable('a');
        Utility.getAnyArray(myArray1);
        Utility.getAnyArray(myArray2);
        Utility.getAnyArray(myArray3);
    }

    public static class Utility {
        public static <T> void getAnyVariable(T anyVariable) {
            System.out.println(anyVariable);
        }

        public static <T> void getAnyArray(T[] array) {
            System.out.println(Arrays.toString(array));
        }
    }
}

