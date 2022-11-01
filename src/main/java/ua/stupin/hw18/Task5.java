package ua.stupin.hw18;

import ua.stupin.hw15.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Box box = new Box();
        List<Box.Item> itemList = new ArrayList<>();
        itemList.add(0, new Box.Item("pen", 14));
        itemList.add(1, new Box.Item("woodenHorse", 27));
        List<Box.Item> itemList1 = new ArrayList<>();
        itemList.add(0, new Box.Item("doll", 64));
        itemList.add(1, new Box.Item("pencil", 15));
//        Box.Item item = box.createItem("pen", 15);
//        Box.Item item1 = box.createItem("woodenHorse", 27);
//        Box.Item item2 = box.createItem("chair", 97);
//        Box.Item item3 = box.createItem("clock", 88);
//        Box.Item item4 = box.createItem("window", 155);

        Map<Integer, List<Box.Item>> newBoxes = new HashMap<>();
        newBoxes.put(6, itemList);
        newBoxes.put(8, itemList1);
        System.out.println(newBoxes.get(8).get(1).getName());

//        newBoxes.put(new Box(), item1);

        Box.Item item5 = new Box.Item("doll", 64);
        Box.Item item6 = new Box.Item("pencil", 15);
        Box.Item item7 = new Box.Item("telephone", 27);
        Box.Item item8 = new Box.Item("rabbit", 69);
        Box.Item item9 = new Box.Item("rope", 77);
        Box.Item item10 = new Box.Item("watermelon", 4);
        Box.Item item11 = new Box.Item("table", 34);
        Box.Item item12 = new Box.Item("book", 11);
        Box.Item item13 = new Box.Item("aid", 66);
        Box.Item item14 = new Box.Item("socket", 2);
        Box.Item item15 = new Box.Item("woodenHouse", 27);
        Box.Item item16 = new Box.Item("woodenRabbit", 27);
        Box.Item item17 = new Box.Item("cigar", 44);
        Box.Item item18 = new Box.Item("paper", 13);
        Box.Item item19 = new Box.Item("copybook", 3);

//
//        newBoxes.get(4).pu
//        newBoxes.get(0).setItem(itemsForBox);
//        newBoxes.get(1).setSize(5);
//        newBoxes.get(1).setItem(itemsForBox1);
//        newBoxes.get(2).setSize(6);
//        newBoxes.get(2).setItem(itemsForBox2);
//        newBoxes.get(3).setSize(7);
//        newBoxes.get(3).setItem(itemsForBox3);
//        newBoxes.get(4).setSize(8);
//        newBoxes.get(4).setItem(itemsForBox4);
//        newBoxes.get(5).setSize(9);
//        newBoxes.get(5).setItem(itemsForBox5);
//        newBoxes.get(6).setSize(10);
//        newBoxes.get(6).setItem(itemsForBox6);
//        newBoxes.get(7).setSize(8);
//        newBoxes.get(7).setItem(itemsForBox7);
//        newBoxes.get(8).setSize(5);
//        newBoxes.get(8).setItem(itemsForBox8);
//        newBoxes.get(9).setSize(6);
//        newBoxes.get(9).setItem(itemsForBox9);
        List<Map.Entry<Integer, List<Box.Item>>> sortedBox = newBoxes.entrySet().stream()
                .filter(c -> c.getKey()>8)
                .sorted((o1, o2) -> Integer.compare(o1.getValue().get(0).getCost(), o2.getValue().get(1).getCost()))
                .toList();
        System.out.println(sortedBox);
    }

}

class Box {

    public Box() {

    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                '}';
    }

    static class Item {
        public String name;
        public int cost;

        public Item(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        public void createItem(String name, int cost) {
            name = this.name;
            cost = this.cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }


    int size;


    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public boolean isSuitable(int minSizeLimit) {
        return minSizeLimit >= 5;
    }


}



