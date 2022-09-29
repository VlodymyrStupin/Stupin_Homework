package ua.stupin.hw5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class Hw5PracticeTask1AndTask2Test {
    private PracticeTask1 practiceTask1;
    private PracticeTask2 practiceTask2;

    @BeforeEach
    void setUp() {
        practiceTask1 = new PracticeTask1();
        practiceTask2 = new PracticeTask2();
    }

    @Test
    public void testSumProductPriceMoreThanThousand1() {
        // expectation true
        Assertions.assertEquals(5005, practiceTask1.sumProductPriceMoreThanThousand(new int[]{1001, 1001, 1001, 1001, 1001}));
    }
    @Test
    public void testSumProductPriceMoreThanThousand2() {
        // expectation false
        Assertions.assertEquals(5004, practiceTask1.sumProductPriceMoreThanThousand(new int[]{1000, 1001, 1001, 1001, 1001}));
    }
    @Test
    public void testMediumGirlsHigh1() {
        // expectation true
        Assertions.assertEquals(20, practiceTask2.mediumGirlsHigh(new int[]{20, 20, 20, 20, 20}));
    }
    @Test
    public void testMediumGirlsHigh2() {
        // expectation false
        Assertions.assertEquals(20, practiceTask2.mediumGirlsHigh(new int[]{20, 20, 20, 20, 51}));
    }
    @Test
    public void testMediumBoysHigh1() {
        // expectation true
        Assertions.assertEquals(10, practiceTask2.mediumBoysHigh(new int[]{-10, -10, -10, -10, -10}));
    }
    @Test
    public void testMediumBoysHigh2() {
        // expectation false
        Assertions.assertEquals(10, practiceTask2.mediumBoysHigh(new int[]{-10, -10, -10, -10, -21}));
    }
    @Test
    public void testMediumBoysHigh3() {
        // expectation false
        Assertions.assertEquals(10, practiceTask2.mediumBoysHigh(new int[]{-10, 10, -10, -10, -21}));
    }
}
