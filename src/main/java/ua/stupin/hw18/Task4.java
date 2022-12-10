package ua.stupin.hw18;

import java.util.ArrayList;
import java.util.List;

/*
Задан список случайных чисел, с помощью функции reduce найти минимальное число
 */
public class Task4 {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(-22);
        listOfNumbers.add(11);
        listOfNumbers.add(345);
        listOfNumbers.add(0);
        listOfNumbers.add(2);
        int filteredList = getFilteredList(listOfNumbers);
        System.out.println(filteredList);
    }

    private static int getFilteredList(List<Integer> listOfNumbers) {
        int filteredList = listOfNumbers.stream()
                .reduce(0, Integer::min);
        return filteredList;
    }
}