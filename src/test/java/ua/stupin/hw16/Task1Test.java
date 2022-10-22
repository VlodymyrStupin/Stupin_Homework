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
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("home", 4);
        newMap.put("chair", 5);
        Assertions.assertEquals(newMap, task1.fromListToMap(List.of("home", "chair")));
    }
    @Test
    public void fromListToMapTest2() {
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("hotel", 5);
        newMap.put("Barbados", 8);
        Assertions.assertEquals(newMap, task1.fromListToMap(List.of("Barbados", "hotel")));
    }
}