package ua.stupin.hw18;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


/*
Задан список случайных чисел, отфильтровать числа >= 0 и получить обьект IntSummaryStatistics.
Вывести на экране все его показатели
 */
public class Task2 {
    public static void main(String[] args) {
        List<Integer> filteredList = Stream.generate(new Random()::nextInt)
                .limit(7)
                .filter(number -> number >= 0)
                .toList();
        getIntSummaryStatistics(filteredList);

    }

    private static void getIntSummaryStatistics(List<Integer> filteredList) {
        IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();
        for (Integer integer : filteredList) {
            intSummaryStatistics.accept(integer);
        }
        System.out.println("The count of values is "
                + intSummaryStatistics.getCount());
        System.out.println("The average of values is "
                + intSummaryStatistics.getAverage());
        System.out.println("The sum of values is "
                + intSummaryStatistics.getSum());
        System.out.println("The maximum of values is "
                + intSummaryStatistics.getMax());
        System.out.println("The minimum of values is "
                + intSummaryStatistics.getMin());
        System.out.println("The string representation is");
        System.out.println(intSummaryStatistics.toString());
    }
}
