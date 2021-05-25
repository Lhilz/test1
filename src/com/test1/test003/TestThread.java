package com.test1.test003;


public class TestThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("我在看书");
        }
    }

    public static void main(String[] args) {
        TestThread testThread=new TestThread();
        new Thread(testThread).start();

        for(int i=0;i<200;i++){
            System.out.println("我在写代码");
        }
    }
}
