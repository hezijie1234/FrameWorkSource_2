package com.zijie.a2_7memory.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by hezijie on 2019/12/3.
 */
public class TestThread {
    static class DemoThread extends Thread{
        @Override
        public void run() {
            System.out.println("start-------" + isInterrupted());
            while (!isInterrupted()){
                try {
                    //抛出异常时线程不会中断，必须要在catch里面主动中断线程。
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    interrupt();
                }
                System.out.println("DemoThread");
                System.out.println("middle-------" + isInterrupted());
            }
            System.out.println("end-------" + isInterrupted());
        }
    }
    static class DemoRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("DemoRunnable");
        }
    }

    static  class DemoCallbale implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("DemoCallbale");
            return "zijie";
        }
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        DemoThread demoThread = new DemoThread();
//        Thread thread = new Thread(new DemoRunnable());
//        DemoCallbale demoCallbale = new DemoCallbale();
//        FutureTask<String> futureTask = new FutureTask<>(demoCallbale);
//        Thread futureThread = new Thread(futureTask);
//        System.out.println(futureTask.get());
//        thread.start();
//        futureThread.start();
        demoThread.start();
        Thread.sleep(10);
        demoThread.interrupt();
    }
}
