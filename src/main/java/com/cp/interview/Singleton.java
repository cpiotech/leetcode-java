package com.cp.interview;

/**
 * Created by curry on 5/24/17.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton () {}
    public static Singleton getSingleton() {
        return singleton;
    }
}
