package com.jmeter.demo.demo;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.*;

/**
 * 2018/12/16
 * Administrator
 * com.jmeter.demo.demo
 */
public class FutureTaskDemo {
    private static int sum=0;
    
    
    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            for (int i = 0; i <= 100; i++) {
                sum +=i;
                TimeUnit.MILLISECONDS.sleep(10);
            }
            return sum;
        }
    }
    
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        Thread thread = new Thread(futureTask);
        System.out.println("开启线程--------");
        thread.start();

        Integer result = null;
        try {
            result = futureTask.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("isDone --> "+futureTask.isDone());
        System.out.println("isCancelled --> "+futureTask.isCancelled());
        System.out.println("result --> "+result);
        System.out.println("main over..............");

    }
}
