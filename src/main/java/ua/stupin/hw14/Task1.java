package ua.stupin.hw14;

import java.util.Arrays;

/*
Создать обертку массива без дубликатов
MySet
- generic
- заданный изначальный размер через конструктор
- add() - проверка на наличие элемента в массиве и проверка на размер
- get() - получение элемента по индексу
- toString() - массив в строку
 */
public class Task1 {
    public static void main(String[] args) {
        MySet<Integer> arrayInteger = new MySet(Integer.class, 10);
        for (int i = 0; i < arrayInteger.array.length; i++) {
            arrayInteger.set(i, i);
        }
        System.out.println(arrayInteger.get(5));
        System.out.println(arrayInteger.add(10, 5));
        System.out.println(arrayInteger.toString());

    }
}

class MySet<T> {
    public T[] array;
    public int length;

    public MySet(Class<T> type, int length) {
        this.array = (T[]) java.lang.reflect.Array.newInstance(type, length);
    }

    void set(int i, T element) {
        array[i] = element;
    }

    public boolean add(int length, T element) {
        boolean checkLength = false;
        boolean checkElementExist = false;
        if (array.length == 10) {
            checkLength = true;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)){
                checkElementExist = true;
            }
        }
        return checkLength && checkElementExist;
    }

    public T get(int index) {
        return array[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
