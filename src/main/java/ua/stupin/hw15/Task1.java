package ua.stupin.hw15;
/*
Напишите Java-программу для обхода ArrayList с использованием:
• цикла for,
• for-each,
• while,
• итератора.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);

        list.add(100);
        list.add(252);
        list.add(348);
        list.add(422);
        list.add(511);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("");
        int i = 0;
        while (i < list.size()) {
            System.out.println(list.get(i));
            i++;
        }
        System.out.println("");
        Iterator<Integer> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
