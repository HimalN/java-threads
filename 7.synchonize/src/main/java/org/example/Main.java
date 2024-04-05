package org.example;


class Calculation{
    int num;

    public synchronized void increment(){
        num++;
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calculation calculation = new Calculation();
        calculation.increment();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                calculation.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                calculation.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("count: " +calculation.num);

    }
}