package com.company;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int middle = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;

        if(nums.length==0)
            return -1;

        System.out.println(String.format("target %d, nums: %s", target, IntStream.of(nums).boxed().collect(Collectors.toList())));



        while (left < right - 1) {
            System.out.println(String.format("left: %d, middle: %d, right: %d, nums[middle]: %d", left, middle, right, nums[middle]));
            middle = left + (right - left) / 2 ;
            if (nums[middle] > target) {
                right = middle;
            }
            else {
                left = middle;
            }

        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }


        return -1;
    }

    public static int squareRoot(int x){
        if(x==0 || x==1){
            return x;
        }

        int limit = x/2+1;


        float middle = limit / 2;
        float left = 1;
        float right = limit;

        while (left < right - 1) {
//            System.out.println(String.format("left: %d, middle: %d, right: %d, middle: %d", left, middle, right, middle));
            middle = left + (right - left) / 2 ;
            if (middle*middle > x) {
                right = middle;
            }
            else {
                left = middle;
            }

        }
        float r = 0;
        if ((int)left*(int)left <= x) {
            r = left;
        }
        if ((int)right*(int)right <= x) {
            r = right;
        }

        return (int) r;
    }

}
