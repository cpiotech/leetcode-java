package com.cp.interview;

/**
 * Created by curryshih on 2/19/17.
 */

/**
 * Time Complexity: O(n), and operate in-place with only a constant amount of extra space.
 * This function segregates evens and odds,
 * but it doesn't produce the output in exactly the same order as this sample.
 *
 * sample input  : 2,4,7,6,1,3,5,4
 * sample output : 2,4,6,4,7,1,3,5 -> 2,4,4,6,1,3,5,7
 */

public class EvenOddSort1 {
    static void orderEvenOdd(int items[]) {
        /* Initialize left and right indexes */
        int left = 0;
        int right = items.length - 1;
        while (left < right) {
            /* increase left index if it's even */
            while (items[left]%2 == 0 && left < right) {
                left++;
            }

            /* decrease right index if it's odd */
            while (items[right]%2 == 1 && left < right) {
                right--;
            }

            if (left < right) {
                //Swap item[left] and item[right]
                int temp = items[left];
                items[left] = items[right];
                items[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int items[] = {2,4,7,6,1,3,5,4};
        orderEvenOdd(items);
        System.out.print("Array after reorder: ");
        for (int i = 0; i < items.length; i++)
            System.out.print(items[i]+" ");
    }
}