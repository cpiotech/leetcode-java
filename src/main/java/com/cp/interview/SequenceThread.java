package com.cp.interview;

import java.util.concurrent.Semaphore;

/**
 * Created by curryshih on 2/19/17.
 */

/*
The same instance of Foo will be passed to three different threads.
Thread A will call first(), Thread B will call second(), and Thread C will call third().
Design a mechanism to ensure that first() is called before second() and second() is called before third().
 */
class Foo {
    private int pauseTime = 500;
    private Semaphore sem1;
    private Semaphore sem2;

    public Foo() {
        try {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);
            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first() {
        try {
            System.out.println("Started Executing 1");
            Thread.sleep(pauseTime);
            System.out.println("Finished Executing 1");
            sem1.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void second() {
        try {
            //wait first() finishs
            sem1.acquire();
            sem1.release();
            System.out.println("Started Executing 2");
            Thread.sleep(pauseTime);
            System.out.println("Finished Executing 2");
            sem2.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            //wait second() finishs
            sem2.acquire();
            sem2.release();
            System.out.println("Started Executing 3");
            Thread.sleep(pauseTime);
            System.out.println("Finished Executing 3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class FooThread extends Thread {
    private Foo foo;
    private String method;

    public FooThread(Foo foo, String method) {
        this.method = method;
        this.foo = foo;
    }

    public void run() {
        if ("first".equals(method)) {
            foo.first();
        } else if ("second".equals(method)) {
            foo.second();
        } else if ("third".equals(method)) {
            foo.third();
        }
    }
}

public class SequenceThread {
    public static void main(String[] args){
        //demo
        Foo foo = new Foo();
        FooThread thread1 = new FooThread(foo, "first");
        FooThread thread2 = new FooThread(foo, "second");
        FooThread thread3 = new FooThread(foo, "third");

        thread3.start();
        thread2.start();
        thread1.start();
    }
}