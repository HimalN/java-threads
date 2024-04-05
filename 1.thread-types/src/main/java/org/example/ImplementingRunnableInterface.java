package org.example;

public class ImplementingRunnableInterface {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread thread = new Thread(myThread);

        thread.start();
    }
}
