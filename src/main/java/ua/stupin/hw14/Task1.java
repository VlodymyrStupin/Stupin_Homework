package ua.stupin.hw14;

import java.util.Arrays;
import java.util.Objects;

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
        for (int i = 0; i < arrayInteger.length; i++) {
            arrayInteger.add(i, i);
        }
        System.out.println(arrayInteger.get(5));
        String printedArray = arrayInteger.toString();
        System.out.println(printedArray);
    }
}

class MySet<T> {
    public T[] array;
    public int length;

    public MySet(Class<T> type, int length) {
        this.length = length;
        this.array = (T[]) java.lang.reflect.Array.newInstance(type, length);
    }

    public void add (int positionInArray, T element) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; i < length; i++) {
                if (array[j] != element && Objects.isNull(array[i])) {
                    array[positionInArray] = element;
                }
            }
        }
    }

    public T get(int index) {
        return array[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
