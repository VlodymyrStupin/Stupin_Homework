package ua.stupin.multithread.task2;

import java.util.concurrent.*;

/*
Напишите приложение, которое в 2 потока будет считать количество простых чисел,
которые заданы в List, выводить результат и возвращать его в главный поток.
Главный поток подсчитывает и выводит общее количество.
 */
public class Main {
    private final static CounterUtil counterUtil = new CounterUtil();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new Thread(new CounterRunner(counterUtil.getFirstHalfOfNumberList())).start();
//        new Thread(new CounterRunner(counterUtil.getSecondHalfOfNumberList())).start();
        CounterCallable callable1 = new CounterCallable(counterUtil.getFirstHalfOfNumberList());
        CounterCallable callable2 = new CounterCallable(counterUtil.getSecondHalfOfNumberList());
        FutureTask<Long> futureTask1 = new FutureTask<>(callable1);
        FutureTask<Long> futureTask2 = new FutureTask<>(callable2);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);
        //sum
        System.out.println(futureTask1.get() + futureTask2.get());
        executor.shutdown();
//        while (true) {
//            try {
//
//                if (futureTask1.isDone() && futureTask2.isDone()) {
//                    System.out.println(futureTask1.get() + futureTask2.get());
//                    executor.shutdown();
//                    return;
//                }
//                if (futureTask1.isDone()) {
//                    System.out.println("Future task 1 result " + futureTask1.get());
//                }
//                Long l = futureTask2.get(200L, TimeUnit.MILLISECONDS);
//                if (l != 0){
//                    System.out.println("Future task 2 result " + l);
//                }
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            } catch (TimeoutException e) {
//
//            }
//        }

    }
}
