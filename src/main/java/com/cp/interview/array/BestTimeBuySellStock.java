package com.cp.interview.array;

/**
 * Created by curry on 5/30/17.
 */
public class BestTimeBuySellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }
}
