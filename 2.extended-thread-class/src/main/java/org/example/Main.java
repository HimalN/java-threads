package org.example;

class one extends Thread{
    public void run(){
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
class two extends Thread{
    public void run(){
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

        one.start();
        Thread.sleep(10);
        two.start();
    }
}