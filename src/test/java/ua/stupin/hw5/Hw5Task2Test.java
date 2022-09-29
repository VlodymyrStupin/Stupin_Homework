package ua.stupin.hw5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class Hw5Task2Test {
    private Task2 task2;

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }

    @Test
    public void testArrayIsOrderedByIncreaseTrue() {
        // expectation true
        Assertions.assertEquals(true, task2.checkArrayByNonIncrease(new int[]{5, 4, 3, 2, 2}));
    }

    @Test
    public void testArrayIsOrderedByIncreaseFalse() {
        // expectation false
        Assertions.assertEquals(false, task2.checkArrayByNonIncrease(new int[]{5, 4, 3, 2, 3}));
    }

}
