package com.cp.interview.math;

/**
 * Created by curry on 5/24/17.
 */
public class PerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int temp = 1;
        for(int i=2; i*i <= num; i++){
            if(num % i == 0){
                temp += i;
                temp += num/i;
            }
            if (temp > num) {
                return false;
            }
        }
        if(temp == num){
            System.out.println("It is a perfect number");
            return true;
        } else {
            System.out.println("It is not a perfect number");
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
