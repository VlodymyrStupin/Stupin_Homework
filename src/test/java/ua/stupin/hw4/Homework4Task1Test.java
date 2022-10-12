package ua.stupin.hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Homework4Task1Test {
    private Task1 task1;
    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    @Test
    public void testArithmeticAverage1() {
        // expectation true
        Assertions.assertEquals(1605.6, task1.getArithmeticAverage(new int[]{15, 10, 124, 19, 7860}));
    }
    @Test
    public void testArithmeticAverage2() {
        // expectation true
        Assertions.assertEquals(13662.4, task1.getArithmeticAverage(new int[]{864, 522, 113, 246, 66567}));
    }
    @Test
    public void testGetGeometricMean1() {
        // expectation true
        Assertions.assertEquals(565.2168047014487, task1.getGeometricMean(new int[]{762, 994, 589, 937, 138}));
    }
    @Test
    public void testGetGeometricMean2() {
        // expectation true
        Assertions.assertEquals(485.31133763149427, task1.getGeometricMean(new int[]{128, 821, 837, 468, 654}));
    }
}
