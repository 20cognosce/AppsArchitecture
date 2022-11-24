package com.mirea.prac1;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer();

        PingPrintingTask pingTask = new PingPrintingTask(printer);
        PongPrintingTask pongTask = new PongPrintingTask(printer);

        Thread thread1 = new Thread(pingTask);
        Thread thread2 = new Thread(pongTask);

        thread1.start();
        thread2.start();
    }
}
