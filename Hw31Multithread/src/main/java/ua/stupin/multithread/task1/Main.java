package ua.stupin.multithread.task1;

/*
Напишите приложение, которое создает 50 потоков один за одним, каждый из потоков выводит сообщение
"Hello from thread (number of thread)", особенность заключается в том,
что вывод должен быть строго в обратном порядке, от 49 до 0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 49; i >= 0; i--) {
            new Thread(new NumberPrinterRunnable(i)).start();
            Thread.sleep(500);
        }
    }
}
