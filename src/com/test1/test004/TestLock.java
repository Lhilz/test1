package com.test1.test004;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TestLock {
    public static void main(String[] args) {
        BuyTicket b=new BuyTicket();
        new Thread(b,"小明").start();

        new Thread(b,"小花").start();

        new Thread(b,"小白").start();
    }




}
class BuyTicket implements Runnable{

    private  int ticketNum=10;

    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        /*try{
            lock.lock();
            while (true){
                if (ticketNum<=0)
                {
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"："+ticketNum--);
            }

        }
        finally {
            lock.unlock();
        }*/
        while (true) {
            try {
                lock.lock();
                if (ticketNum <= 0) {
                    break;
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "：" + ticketNum--);

            } finally {
                lock.unlock();
            }
        }
    }
}
