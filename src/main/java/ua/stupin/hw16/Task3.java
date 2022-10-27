package ua.stupin.hw16;

import java.util.*;

/*
Напишите метод, который добавляет 1 000 000 элементов в ArrayList и LinkedList.
Напишите еще один метод, который выбирает из заполненного списка элемент наугад 1 000 000 раз.
Замерьте время, которое потрачено на это.

https://www.baeldung.com/java-measure-elapsed-time - for time measure
 */
public class Task3 {
    public static List<Integer> addOneMillionElementToList(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            list.add(random.nextInt(1000000) + 1);
        }
        return list;
    }

    public static void pickElementFromListOneMillionTimes(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            System.out.println(list.get(random.nextInt(1000000) + 1));
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        List<Integer> filledArrayList = addOneMillionElementToList(arrayList);
        System.out.println("Time for fill element to array list: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        List<Integer> filledLinkedList = addOneMillionElementToList(linkedList);
        System.out.println("Time for fill element to linked list: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        pickElementFromListOneMillionTimes(addOneMillionElementToList(filledArrayList));
        System.out.println("Time for pick element from array list: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        pickElementFromListOneMillionTimes(addOneMillionElementToList(filledLinkedList));
        System.out.println("Time for pick element from linked list: " + (System.currentTimeMillis() - startTime));
    }

}
