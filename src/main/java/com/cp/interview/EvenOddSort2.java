package com.cp.interview;

/**
 * Time Complexity: O(n^2), and operate in-place with only a constant amount of extra space.
 * This function segregates evens and odds, and it produces the output in the same order as the sample.
 * but it's not the minimum time complexity.
 *
 * sample input  : 2,4,7,6,1,3,5,4
 * sample output : 2,4,6,4,7,1,3,5
 */

public class EvenOddSort2 {
    static void orderEvenOdd(int items[]) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length-1; j++) {
                if (items[j]%2 == 1 && items[j+1]%2 == 0) {
                    //Swap item[left] and item[right]
                    int temp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = temp;
                }
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
