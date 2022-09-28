package ua.stupin.hw6;
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
        int number;
        String model;
        int weight;

        public Phone(int number, String model, int weight) {
            this.number = number;
            this.model = model;
            this.weight = weight;
        }
        public Phone(int number, String model) {
            this.number = number;
            this.model = model;
        }
        public Phone(){
        }
        private void receiveCall(String whoCall){
            System.out.println("Calls " + whoCall);
        }

        private void getNumber(int number){
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        Phone firstPhone = new Phone(123, "S1", 1000);
        Phone secondPhone = new Phone(456, "S2");
        Phone thirdPhone = new Phone();
        System.out.println(firstPhone.number +" "+ firstPhone.model +" "+ firstPhone.weight);
        System.out.println(secondPhone.number +" "+ secondPhone.model+" "+ secondPhone.weight);
        System.out.println(thirdPhone.number +" "+ thirdPhone.model +" "+ thirdPhone.weight);
        firstPhone.receiveCall("John");
        firstPhone.getNumber(123);
        secondPhone.receiveCall("Clark");
        secondPhone.getNumber(456);
        thirdPhone.receiveCall("Samanta");
        thirdPhone.getNumber(789);
    }
}
