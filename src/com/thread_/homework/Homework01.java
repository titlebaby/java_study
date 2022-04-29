package com.thread_.homework;

import java.util.Locale;
import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        a.start();
        B b = new B(a);
        /**
         * 主线车工起动两个线程，B线程输入Q时，a线程b线程退出
         */
    }
}


class A extends Thread {


    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    private  boolean loop = true;
    @Override
    public void run() {
        super.run();
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class B extends Thread {

    private A a;
    private Scanner scanner =  new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("请输入你指令");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                a.setLoop(false);
                System.out.println("b线程退出");
                break;
            }
        }

    }
}