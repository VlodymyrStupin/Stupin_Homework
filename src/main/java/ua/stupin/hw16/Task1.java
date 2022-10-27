package ua.stupin.hw16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Реализовать метод, принимающий список строк и возвращающий Map,
где ключ - строка, значение - количество букв в строке.
Покрыть код тестами. Проверка через main не нужна.
Пример:
[“тут”, “там”, “стол”] ->[ {“тут”, 3}, {“там”, 3}, {“стол”, 4}]
 */
public class Task1 {
    public Map<String, Integer> fromListToMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), list.get(i).length());
        }
        return map;
    }

}
