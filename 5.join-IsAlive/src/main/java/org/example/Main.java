package org.example;
class two implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("two");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("one");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        );
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("two");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadOne.start();
        Thread.sleep(10);

        System.out.println("Thread one status: "+threadOne.isAlive());
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
        System.out.println("Thread one status: "+threadOne.isAlive());

        System.out.println("BYE");
    }
}