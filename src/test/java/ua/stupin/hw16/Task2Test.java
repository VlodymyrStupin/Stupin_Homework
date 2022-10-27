package ua.stupin.hw16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {


    private Task2 task2;

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }

    @Test
    void fromListToMap1() {
        Map<Integer, List<String>> newMap = new HashMap<>();
        List<String> firstTestListFourLettersWords = List.of("home", "girl", "hood");
        List<String> secondTestListFiveLettersWords = List.of("chair", "chain");
        newMap.put(4, firstTestListFourLettersWords);
        newMap.put(5, secondTestListFiveLettersWords);
        Assertions.assertEquals(newMap, task2.fromListToMap(List.of("home", "chair", "girl", "hood", "chain")));
    }

    @Test
    void fromListToMap2() {
        Map<Integer, List<String>> newMap = new HashMap<>();
        List<String> firstTestListFourLettersWords = List.of("open", "beer", "bear");
        List<String> secondTestListThreeLettersWords = List.of("ice", "eye", "pig", "bee", "dog", "cat");
        List<String> thirdTestListSevenLettersWords = List.of("chariot", "knights", "Roggers");
        newMap.put(4, firstTestListFourLettersWords);
        newMap.put(3, secondTestListThreeLettersWords);
        newMap.put(7, thirdTestListSevenLettersWords);
        Assertions.assertEquals(newMap, task2.fromListToMap(List.of("open", "beer", "bear"
                , "ice", "eye", "pig", "bee", "dog", "cat", "chariot", "knights", "Roggers")));
    }
}