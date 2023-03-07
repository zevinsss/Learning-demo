package com.example.demo.juc;

public class JucDemo implements Runnable{

    int count =  0;

    @Override
    public synchronized void run() { //普通方法
        while (true) {
            System.out.println("你好-" + (++count) + Thread.currentThread().getName());
            if (count > 1000) {
                break;
            }
        }
    }




    public static void main(String[] args) {
        JucDemo jucDemo = new JucDemo();

        Thread thread1 = new Thread(jucDemo);
        Thread thread2 = new Thread(jucDemo);
        Thread thread3 = new Thread(jucDemo);
        Thread thread4 = new Thread(jucDemo);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
