package ua.stupin.hw18;

import java.util.*;

/*
Спроектировать класс Box который содержит клас Item, size. Item должен содержать поле name и cost
a. Создать коллекцию Box и инициализировать ее 10 коробками
b. Спроектировать метод, который поможет определить подходит ли коробка по размеру. Boolean isSuitable(minSizeLimit)
c. Применить фильтр к коллекции коробок,
d. У оставшихся коробок взять коллекции Item
e. Отсортировать по цене
f. Вывести цены в консоль
 */
public class Task5 {
    public static void main(String[] args) {
        Item item1 = new Item("pen", 14);
        Item item2 = new Item("woodenHorse", 27);
        Item item3 = new Item("doll", 64);
        Item item4 = new Item("pencil", 15);
        Item item5 = new Item("telephone", 29);
        Item item6 = new Item("rabbit", 69);
        Item item7 = new Item("rope", 77);
        Item item8 = new Item("table", 34);
        Item item9 = new Item("book", 11);
        Item item10 = new Item("firstAid", 66);
        Item item11 = new Item("socket", 2);
        Item item12 = new Item("woodenHouse", 28);
        Item item13 = new Item("woodenRabbit", 900);
        Item item14 = new Item("cigar", 44);
        Item item15 = new Item("paper", 13);
        Item item16 = new Item("copybook", 3);
        Item item17 = new Item("watermelon", 4);
        Item item18 = new Item("chair", 97);
        Item item19 = new Item("clock", 88);
        Item item20 = new Item("window", 155);
        List<Item> items1 = Arrays.asList(item1, item2);
        List<Item> items2 = Arrays.asList(item3, item4);
        List<Item> items3 = Arrays.asList(item5, item6);
        List<Item> items4 = Arrays.asList(item7, item8);
        List<Item> items5 = Arrays.asList(item9, item10);
        List<Item> items6 = Arrays.asList(item11, item12);
        List<Item> items7 = Arrays.asList(item13, item14);
        List<Item> items8 = Arrays.asList(item15, item16);
        List<Item> items9 = Arrays.asList(item17, item18);
        List<Item> items10 = Arrays.asList(item19, item20);
        Box box1 = new Box(2, items1);
        Box box2 = new Box(3, items2);
        Box box3 = new Box(4, items3);
        Box box4 = new Box(5, items4);
        Box box5 = new Box(6, items5);
        Box box6 = new Box(7, items6);
        Box box7 = new Box(8, items7);
        Box box8 = new Box(9, items8);
        Box box9 = new Box(10, items9);
        Box box10 = new Box(11, items10);
        List<Box> boxes = Arrays.asList(box1, box2, box3, box4, box5, box6, box7, box8, box9, box10);
        List<Item> sortedBoxes = boxes.stream()
                .filter(Box::isSuitable)
                .map(Box -> Box.items.get(args.length))
                .sorted(Comparator.comparing(Item::getCost))
                .toList();
        System.out.println(sortedBoxes);
    }
}

class Box {
    int size;
    List<Item> items;

    public Box(int size, List<Item> items) {
        this.size = size;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                ", items=" + items +
                '}';
    }

    public boolean isSuitable() {
        return this.size >= 4;
    }
}

class Item {
    public String name;
    public int cost;

    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}



