package com.thread_;

public class Threaduse {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start(); //启动线程 如果直接用cat.run() 则会直接找到cat中的run方法，就是一个普通的方法，是串行执行，先执行下面的run，再执行主线程的那个for循环
        /**
         * 底层的start0()方法才是实现线程的，JVM实现
         * 说明
         * 当main线程启动一个子线程thread-0 ，主线程不会阻塞，会继续执行
         * 这时，主线程和子线程是交替执行的
         */
        System.out.println("主线程继续执行name=" + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程i="+ i);
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("hello world cat  "+ (++times));
            //让该线程修改1s ctrl +alt +t

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(times == 80) {
                break;
            }
        }
    }


}
