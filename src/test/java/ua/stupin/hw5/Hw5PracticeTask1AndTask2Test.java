package ua.stupin.hw5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;



public class Hw5PracticeTask1AndTask2Test {
    private PrakticeTask1 practiceTask1;
    private PracticeTask2 practiceTask2;
    @BeforeEach
    void setUp() {
        practiceTask1 = new PrakticeTask1();
        practiceTask2 = new PracticeTask2();
    }
    @Test
    public void testSumProductPriceMoreThanThousand1() {
        // expectation true
        Assertions.assertEquals(5566220, practiceTask1.sumProductPriceMoreThanThousand(new int[]{1576, 945, 1, 999999, 4564645}));
    }
    @Test
    public void testSumProductPriceMoreThanThousand2() {
        // expectation true
        Assertions.assertEquals(234582292, practiceTask1.sumProductPriceMoreThanThousand(new int[]{1234545, 186678001, 45645645, 45456, 978645}));
    }
    @Test
    public void testMediumGirlsHigh1() {
        // expectation true
        Assertions.assertEquals(189, practiceTask2.mediumGirlsHigh(new int[]{176, 200, 154, 225, 190}));
    }
    @Test
    public void testMediumGirlsHigh2() {
        // expectation true
        Assertions.assertEquals(169, practiceTask2.mediumGirlsHigh(new int[]{168, 163, 144, 198, 176}));
    }
    @Test
    public void testMediumBoysHigh1() {
        // expectation true
        Assertions.assertEquals(188, practiceTask2.mediumBoysHigh(new int[]{-154, -195, -254, -160, -180}));
    }
    @Test
    public void testMediumBoysHigh2() {
        // expectation true
        Assertions.assertEquals(167, practiceTask2.mediumBoysHigh(new int[]{-174, -155, -177, -134, -199}));
    }

}

