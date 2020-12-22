package com.jzg.thinkingInJava.test.ThreadDemo;


import java.util.concurrent.TimeUnit;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/12/22 12:30
 */
public class InterruptedDemo {
    public static void main(String[] args){
        Thread sleepThread = new Thread(new SleepThread(),"SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyThread(),"BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupte is  = [" + sleepThread.isInterrupted() + "]");
        System.out.println("BusyThread interrupte is  = [" + busyThread.isInterrupted() + "]");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class SleepThread implements Runnable{


        @Override
        public void run() {
            while (true){

                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {

                }


            }
        }
    }

    static class BusyThread implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
