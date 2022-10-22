package ua.stupin.hw15;


import java.util.Comparator;
import java.util.TreeSet;

/*
Создать класс Box содержащий параметр объем.
- Создать отсортированный Set и поместить в него 5+ объектов Box
- Правила сортировки:
1) От большего к меньшему
2) Если объем равен 0, поместить в начало списка
 */
public class Task3 {
    public static class Box {
        private int capacity;

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public Box(int capacity) {
            this.capacity = capacity;
        }

    }

    static class BoxComparatorFromBigToSmall implements Comparator<Box> {
        public int compare(Box a, Box b) {
            if (b.getCapacity() == 0 || a.getCapacity() == 0){
                return a.getCapacity() - b.getCapacity();
            }
            return b.getCapacity() - a.getCapacity();
        }
    }


    public static void main(String[] args) {
        Comparator<Box> comparator = new BoxComparatorFromBigToSmall();
        TreeSet<Box> newBox = new TreeSet<>(comparator);
        newBox.add(new Box(92));
        newBox.add(new Box(9));
        newBox.add(new Box(14));
        newBox.add(new Box(125));
        newBox.add(new Box(111));
        newBox.add(new Box(0));
        for (Box capacity : newBox) {
            System.out.println(capacity.getCapacity());
        }

    }
}
