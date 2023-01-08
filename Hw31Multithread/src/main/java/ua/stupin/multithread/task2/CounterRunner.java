package ua.stupin.multithread.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CounterRunner implements Runnable {
    private volatile int value;

    public CounterRunner(List<Integer> numberList) {
        this.numberList = numberList;
    }

    List<Integer> numberList = new ArrayList<>();

    @Override
    public void run() {
        System.out.println(numberList.stream()
                .filter(CounterRunner::isPrime)
                .count());
    }
    public int getValue() {
        return value;
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }
}
