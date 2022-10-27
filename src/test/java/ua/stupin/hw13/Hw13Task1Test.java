package ua.stupin.hw13;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class Hw13Task1Test {

    private Task1 task1;

    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    @Test
    public void bubbleSortTest1() {
        // expectation sorted array
        Assertions.assertArrayEquals((new int[]{1, 2, 3, 4, 5}), task1.bubbleSort(new int[]{5, 3, 1, 2, 4}));
    }

    @Test
    public void bubbleSortTest2() {
        // expectation sorted array
        Assertions.assertArrayEquals((new int[]{3, 4, 14, 78, 199}), task1.bubbleSort(new int[]{14, 78, 199, 3, 4}));
    }

}

