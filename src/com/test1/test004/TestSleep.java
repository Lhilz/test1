package com.test1.test004;


public class TestSleep  implements Runnable{

    private  int  ticketNum=10;

    @Override
    public void run() {
        while (true)
        {
            if (ticketNum<1)
            {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum--+"票");
        }
    }

    public static void main(String[] args) {

       TestSleep testSleep=new TestSleep();

       new Thread(testSleep,"小明").start();
        new Thread(testSleep,"老师").start();
        new Thread(testSleep,"黄牛").start();

    }
}
