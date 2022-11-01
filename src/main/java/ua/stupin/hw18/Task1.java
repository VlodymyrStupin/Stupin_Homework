package ua.stupin.hw18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Задан массив строк. Используя средства StreamAPI отсортировать строки в лексикографическом порядке и вывести в консоль.
 */
public class Task1 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("home");
        stringList.add("rain");
        stringList.add("double");
        stringList.add("particle");
        stringList.add("dream");
        List<String> stringListToStream = stringList.stream()
                .sorted(Comparator.naturalOrder())
                .toList();
        System.out.println(stringList);
        System.out.println(stringListToStream);
    }
}
