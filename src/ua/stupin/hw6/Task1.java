package ua.stupin.ua.stupin.hw6;
//Класс Phone. а) Создайте класс Phone, который содержит переменные(поля) number, model и weight.
//        б) Добавить конструктор в класс Phone, который принимает на вход три параметра для инициализации переменных класса
//        - number, model и weight.
//        в) Добавить конструктор, который принимает на вход два параметра для инициализации переменных класса
//        - number, model.
//        г) Добавить конструктор без параметров.
//        д) Создайте три экземпляра этого класса.
//        ж) Присвоить значения полям класса.
//        з) Выведите на консоль значения их полей.
//        и) Добавить в класс Phone методы: receiveCall, имеет один параметр – имя звонящего.
//        Выводит на консоль сообщение “Звонит {name}”. getNumber – возвращает номер телефона.
//        Вызвать эти методы для каждого из объектов.
public class Task1 {
    static class Phone {
        int number = 456;
        String model = "S6";
        int weight = 165;

        Phone(int number, String model, int weight) {
            this.number = number;
            this.model = model;
            this.weight = weight;
        }
        Phone(int number, String model) {
            this.number = number;
            this.model = model;
        }
        Phone(){
        }
        public void receiveCall(String whoCall){
            whoCall = "John";
            System.out.println("Calls " + whoCall);
        }

        public void getNumber(int number){
            number = 12345;
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        Phone myPhone = new Phone();
        System.out.println(myPhone.number);
        System.out.println(myPhone.model);
        System.out.println(myPhone.weight);
        myPhone.receiveCall("");
        myPhone.getNumber(0);
    }
}
