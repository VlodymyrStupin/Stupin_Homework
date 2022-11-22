package ua.stupin.hw18;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
Задан список строк в формате даты YYYY/MM/DD,
преобразовать строки в даты, проверить что присутствует хотя-бы одна дата за 2022 год.
 */
public class Task3 {
    public static void main(String[] args) {
        List<String> dateListInString = new ArrayList<>();
        dateListInString.add("1996/07/28");
        dateListInString.add("2022/04/22");
        dateListInString.add("2010/11/11");
        dateListInString.add("2020/09/14");
        dateListInString.add("2022/08/30");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        List<LocalDate> dateList = getDateListInStringToDateList(dateListInString, format);
        System.out.println("Is present year 2022: " + checkForDate2022(dateList));
        System.out.println(dateListInString);
        System.out.println(dateList);
    }

    private static List<LocalDate> getDateListInStringToDateList(List<String> dateListInString, DateTimeFormatter format) {
        List<LocalDate> dateListInStringToDateList = dateListInString.stream()
                .map(date -> LocalDate.parse(date, format))
                .toList();
        return dateListInStringToDateList;
    }

    private static boolean checkForDate2022(List<LocalDate> dateList) {
        return dateList.stream()
                .anyMatch(it -> it.getYear() == 2022);
    }
}