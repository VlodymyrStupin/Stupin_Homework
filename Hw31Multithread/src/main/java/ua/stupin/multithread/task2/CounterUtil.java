package ua.stupin.multithread.task2;

import java.util.ArrayList;
import java.util.List;

public class CounterUtil {
    public List<Integer> getNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            numberList.add(i);
        }
        return numberList;
    }

    public List<Integer> getFirstHalfOfNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < getNumberList().size() / 2; i++) {
            numberList.add(i, getNumberList().get(i));
        }
        return numberList;
    }

    public List<Integer> getSecondHalfOfNumberList() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = getNumberList().size() - 1; i >= getNumberList().size() / 2; i--) {
            numberList.add(getNumberList().get(i));
        }
        return numberList;
    }
}
