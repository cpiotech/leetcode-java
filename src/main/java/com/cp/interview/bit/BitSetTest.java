package com.cp.interview.bit;

import java.util.BitSet;

/**
 * Created by curry on 2/3/18.
 */
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bm = new BitSet();
        System.out.println(" --- init bit set ---");
        System.out.println("size : " + bm.size());
        System.out.println("length : " + bm.length());
        bm.set(0);
        System.out.println("set 0 --->");
        System.out.println("size : " + bm.size());
        System.out.println("length : " + bm.length());
        bm.set(2);
        System.out.println("set 2 --->");
        System.out.println("size : " + bm.size());
        System.out.println("length : " + bm.length());
        bm.set(63);
        System.out.println("set 63 --->");
        System.out.println("size : " + bm.size());
        System.out.println("length : " + bm.length());
        bm.set(64);
        System.out.println("set 64 --->");
        System.out.println("size : " + bm.size());
        System.out.println("length : " + bm.length());
    }
}
