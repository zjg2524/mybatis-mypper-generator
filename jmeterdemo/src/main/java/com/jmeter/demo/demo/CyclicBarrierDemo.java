package com.jmeter.demo.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 2018/12/16
 * Administrator
 * com.jmeter.demo.demo
 */
public class CyclicBarrierDemo {

    private static int i = 0;
    static CyclicBarrier barrier = new CyclicBarrier(5 );
//    static CyclicBarrier barrier = new CyclicBarrier(5,new PreCondition() );

    static class PreCondition implements Runnable {

        @Override
        public void run() {
            System.out.println("barrier condition executor.............");
        }
    }
public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
        new Thread(new Work()).start();
    }
    }
    static class Work implements Runnable {

        @Override
        public void run() {
            i = i + 1;
            try {
                System.out.println("i --> "+i);
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                TimeUnit.SECONDS.sleep(2);
                System.out.println("result --> "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
