package com.thread_.tickets;

public class SellTicket {
    public static void main(String[] args) {
      /*  SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();
        //这里会出现超卖，三个线程会同时进入1张票的判断，会超卖两张
        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();

       */
        System.out.println("使用Runnable实现多线程");
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start(); //第1个线程-窗口
        new Thread(sellTicket02).start();//第2个线程-窗口
        new Thread(sellTicket02).start();//第3个线程-窗口

    }
}


//使用thread方式

class SellTicket01 extends Thread {//这个不能保证多个线程是同一个对象，它就锁不住，要synchronized 锁必须用同一个对象
    private static int  ticketNum = 100; //让多个线程共享 ticketNum


    @Override
    public  void run() {
        super.run();
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口="+ Thread.currentThread().getName() + "售出一张票，剩余票数"+ (--ticketNum));
        }

    }
}


class SellTicket02 implements Runnable {
    private  int  ticketNum = 100; //这里不用static 因为以后指挥创建一个SellTicket02 对象
    private boolean loop = true;// 控制run方法变量

    @Override
    public void run() {
        sell();
//        while (true) {
//            if (ticketNum <= 0) {
//                System.out.println("售票结束");
//                break;
//            }
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("窗口="+ Thread.currentThread().getName() + "售出一张票，剩余票数"+ (--ticketNum));
//        }

    }

    // synchronized 同步，同一时刻，只能有一个线程操作这个方法
    public synchronized void sell(){
        while (loop) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                loop = false;
                return ;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口="+ Thread.currentThread().getName() + "售出一张票，剩余票数"+ (--ticketNum));
        }
    }
}