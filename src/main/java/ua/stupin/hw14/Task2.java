package ua.stupin.hw14;

import java.util.Arrays;

/*
Реализовать класс-утилиту которая содержит два generic метода (статический и не статический):
Метод 1: принимает любое значение и выводит ***{значение}***
Метод 2: принимает массив любого типа и выводит его содержание
 */
public class Task2 {
    public static void main(String[] args) {
        Integer[] myArray1 = new Integer[] {1, 5, 5, 5};
        Double[] myArray2 = new Double[] {1.16, 9.78, 5999.2, 50.0};
        Character[] myArray3 = new Character[] {'1', 'a', 'b', 'G'};
        System.out.println(Utility.getAnyVariable(true));
        System.out.println(Utility.getAnyVariable(0.57));
        System.out.println(Utility.getAnyVariable("true"));
        System.out.println(Utility.getAnyVariable('a'));
        System.out.println(Utility.getAnyArray(myArray1));
        System.out.println(Utility.getAnyArray(myArray2));
        System.out.println(Utility.getAnyArray(myArray3));

    }

    public static class Utility {
        public static <T> T getAnyVariable(T anyVariable) {
            // ***{значение}*** - цей запис означає, що в такому форматі потрібно виводитит змінну,
            // чи це просто написано у такий спосіб?
            return anyVariable;
        }

        public static <T> String getAnyArray(T[] array) {
            return Arrays.toString(array);
        }
    }
}

