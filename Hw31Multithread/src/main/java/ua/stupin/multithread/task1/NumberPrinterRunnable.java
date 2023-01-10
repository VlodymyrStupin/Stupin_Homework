package ua.stupin.multithread.task1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberPrinterRunnable implements Runnable{
    private Integer number;
    @Override
    public void run() {
        System.out.println("Hello from thread: " + number);
    }
}
