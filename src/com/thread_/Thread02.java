package com.thread_;

public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        // Runnable 没有start方法，可以
        Thread thread = new Thread(dog);
        //想要主线程退出后，子线程也就推出，就是把它设置为守护线程，它就可以自退出
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程序执行");
            if (i == 5) {
                thread.join(); //让子线程插队，等子线程执行完，才再执行主线程
            }
        }


    }
}

class Dog implements Runnable{
    //Runnable实现多线程，避免了单继承的限制
    int count;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello world hi "+ (++count)+ Thread.currentThread().getName());
            if (count == 8) {
                break;
            }

            //surround with try catch快捷键  ctrl+alt+t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}