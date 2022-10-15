package ua.stupin.hw13;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class Hw13Task2Test {

    private Task2 task2;

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }

    @Test
    public void binarySearchInArray1() {
        // expectation true
        Assertions.assertEquals(5, task2.binarySearchInArray(new int[]{5, 3, 1, 2, 4}, 4));
    }

    @Test
    public void binarySearchInArray2() {
        // expectation true
        Assertions.assertEquals(3, task2.binarySearchInArray(new int[]{14, 8, 22, 5, 9}, 22));
    }


}
