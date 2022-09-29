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
    public void testArrayIsOrderedByIncrease1() {
        // expectation true
        Assertions.assertEquals(true, task2.checkArrayByNonIncrease(new int[]{5, 4, 3, 2, 1}));
    }
    @Test
    public void testArrayIsOrderedByIncrease2() {
        // expectation false
        Assertions.assertEquals(false, task2.checkArrayByNonIncrease(new int[]{6, 8, 4, 3, 2}));
    }
    @Test
    public void testArrayIsOrderedByIncrease3() {
        // expectation false
        Assertions.assertEquals(true, task2.checkArrayByNonIncrease(new int[]{74, 70, 52, 30, 31}));
    }
    @Test
    public void testArrayIsOrderedByIncrease4() {
        // expectation true
        Assertions.assertEquals(false, task2.checkArrayByNonIncrease(new int[]{80, 32, 20, 10, 1}));
    }
}
