package com.mirea.prac1;

import java.util.stream.IntStream;

public class PingPrintingTask implements Runnable {

    private final Printer printer;

    public PingPrintingTask(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        IntStream.range(0, 100).forEach(i -> {
            synchronized (printer) {
                try {
                    printer.printPing();
                    printer.notify();
                    printer.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println("Ping finished");
    }
}
