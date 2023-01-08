package ua.stupin.multithread.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class CounterCallable implements Callable<Long> {
    List<Integer> numberList = new ArrayList<>();

    public CounterCallable(List<Integer> numberList) {
        this.numberList = numberList;
    }

    @Override
    public Long call() {
        return numberList.stream()
                .filter(CounterCallable::isPrime)
                .count();
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

}
