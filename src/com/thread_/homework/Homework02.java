package com.thread_.homework;

public class Homework02 {
    public static void main(String[] args) {
        /**
         * 两个用户取钱（1000），不能超取出
         */
        T1 t1 = new T1();
        T1 t2 = new T1();
        new Thread(t1).start();
        new Thread(t1).start(); //需求时同一个对象t1或者t2


    }
}
// 共享资源 要用Runnable 只能创建一个对象
class T1 implements Runnable {
    private int money =10000;
    @Override
    public void run() {

        while (true) {
            /**
             * 1。 synchronized 实现了线程同步
             * 2. 当多个线程执行到这里时，就会去争夺this对象*（必须时同一个对象）
             * 3. 代码块执行完，就会释放this对象
             * 4. 争夺不到this锁，就blocked，准备继续争夺
             * 5. this对象是非公平锁
             */
            synchronized (this) {
                if (money <= 0) {
                    System.out.println("余额不足");
                    break;
                }
                money -= 1000;
                System.out.println("T1取钱,当前余额=" + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class T2 implements Runnable {
    private int money =10000;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money <= 0) {
                    break;
                }
                money -= 1000;
                System.out.println("T2取钱,当前余额=" + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
