package ua.stupin.hw19;
/*
Реализовать программу которая считывает текст с консоли и строит CSV файл.
● Если пользователь ввел next то происходит переход строки
● Если пользователь вводит end то программа завершается
 */

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException, IllegalStateException {
        String fileName = "D:\\Java study\\Homework_Stupin\\Homework\\src\\main\\resources\\test.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String value = scanner.next();
                if (value.equals("end")){
                    scanner.close();
                    writer.close();

                }  else if (!value.equals("next")){
                    writer.write(value);
                    writer.write(',');
                } else {
                    writer.append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e){
            e.getMessage();
        }
    }

}



