package com.mirea.prac1;

import java.util.stream.IntStream;

public class PongPrintingTask implements Runnable {

    private final Printer printer;

    public PongPrintingTask(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        IntStream.range(0, 100).forEach(i -> {
            synchronized (printer) {
                try {
                    printer.wait(1000);
                    printer.printPong();
                    printer.notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        System.out.println("Pong finished");
    }
}
