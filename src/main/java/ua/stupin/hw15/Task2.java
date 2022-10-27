package ua.stupin.hw15;

import java.util.ArrayList;
import java.util.List;

/*
Реализовать утильный класс со статическими методами:
• getSum(List<Integer> numbers) - возвращает сумму элементов списка
• getOddNumber(List<Integer> numbers) - возвращает новый список нечетных чисел
• convertToStringList(List<Integer> numbers) - возвращает новый список строк
• doubling(List<String> strings) - дублирует строку и конкатенирует ее
- input: “2”
- output: “22”
 */
public class Task2 {
    static class Utils {
        public int getSum(List<Integer> numbers) {
            int sum = 0;
            for (Integer number : numbers) {
                sum = sum + number;
            }
            return sum;
        }

        public List<Integer> getOddNumber(List<Integer> numbers) {
            List<Integer> newList = new ArrayList<>(numbers);
            for (int i = 0; i < newList.size(); i++) {
                if (newList.get(i) % 2 == 0) {
                    newList.remove(i);
                }
            }
            return newList;
        }

        public List<String> convertToStringList(List<Integer> numbers) {
            List<String> newList = new ArrayList<>(numbers.size());
            for (Integer number : numbers) {
                newList.add(String.valueOf(number));
            }
            return newList;
        }

        public List<String> doubling(List<String> strings) {
            List<String> newStrings = new ArrayList<>(strings);
            newStrings.replaceAll(s -> (s.concat(s)));
            return newStrings;
        }
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        List<String> newStringList = utils.convertToStringList(newList);
        System.out.println(utils.getSum(newList));
        System.out.println(utils.getOddNumber(newList));
        System.out.println(newStringList);
        System.out.println(utils.doubling(newStringList));
    }
}
