package ua.stupin.hw16;

import java.util.*;

/*
Реализовать метод, который принимает список строк и возвращает Map с
ключом в виде количества букв в строке и значением - список строк соответствующей длины.
Покрыть код тестами. Проверка через main не нужна.
Пример:
[“тут”, “там”, “стол”] ->[ {3, [“тут”, “там”]}, {4, [“стол”]}]
 */
public class Task2 {
    public Map<Integer, List<String>> fromListToMap(List<String> list) {
        List<String> newList = new ArrayList<>();
        newList.add(list.get(0));
        int numberOfLettersInAString = 0;
        Map<Integer, List<String>> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).length() == list.get(j).length()) {
                    newList.add(list.get(j));
                    map.put(list.get(i).length(), new ArrayList<>(newList));
                }
            }
            newList.clear();
        }
        return map;
    }
}
