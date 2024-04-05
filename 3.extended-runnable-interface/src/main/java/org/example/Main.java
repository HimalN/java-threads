package org.example;

class one implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("one");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class two implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("two");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        one one = new one();
        two two = new two();

        Thread threadOne = new Thread(one);
        Thread threadTwo = new Thread(two);

        threadOne.start();
        Thread.sleep(10);
        threadTwo.start();
    }
}