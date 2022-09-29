package ua.stupin.hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Hw4Task1Test {
    private Task1 task1;
    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    @Test
    public void testArithmeticAverage1() {
        // expectation true
        Assertions.assertEquals(10, task1.getArithmeticAverage(new int[]{10, 10, 10, 10, 10}));
    }
    @Test
    public void testArithmeticAverage2() {
        // expectation false
        Assertions.assertEquals(10, task1.getArithmeticAverage(new int[]{10, 10, 10, 10, 9}));
    }
    @Test
    public void testGetGeometricMean1() {
        // expectation true
        Assertions.assertEquals(5, task1.getGeometricMean(new int[]{5, 5, 5, 5, 5}));
    }
    @Test
    public void testGetGeometricMean2() {
        // expectation false
        Assertions.assertEquals(10, task1.getGeometricMean(new int[]{10, 10, 10, 10, 9}));
    }
}
