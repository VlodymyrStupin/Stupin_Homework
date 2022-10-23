package ua.stupin.hw16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    private Task1 task1;

    @BeforeEach
    void setUp() {

        task1 = new Task1();
    }

    @Test
    public void fromListToMapTest1() {
        Map<String, Integer> testNewMap = new HashMap<>();
        testNewMap.put("home", 4);
        testNewMap.put("chair", 5);
        Assertions.assertEquals(testNewMap, task1.fromListToMap(List.of("home", "chair")));
    }
    @Test
    public void fromListToMapTest2() {
        Map<String, Integer> testNewMap = new HashMap<>();
        testNewMap.put("hotel", 5);
        testNewMap.put("Barbados", 8);
        Assertions.assertEquals(testNewMap, task1.fromListToMap(List.of("Barbados", "hotel")));
    }
}