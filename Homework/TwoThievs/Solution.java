package Homework.TwoThievs;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public int minDifference(int[] nums) {
        int[][] cache = new int[nums.length+1][nums.length+1];
        for(int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        return DP(nums, 0, 0, 0, 0, cache);
    }

    public int DP(int[] nums, int leftAmount, int rightAmount, int leftIndex, int rightIndex, int[][] cache) {
        if((leftIndex + rightIndex) == nums.length) return Math.abs(rightAmount - leftAmount);
        if(cache[leftIndex][rightIndex] != Integer.MAX_VALUE) return cache[leftIndex][rightIndex];

        cache[leftIndex][rightIndex] = Math.min(DP(nums, leftAmount + nums[leftIndex + rightIndex], rightAmount, leftIndex + 1, rightIndex, cache), 
            DP(nums, leftAmount, rightAmount + nums[leftIndex + rightIndex], leftIndex, rightIndex + 1, cache));

        return cache[leftIndex][rightIndex];
    }

    public int minDifferenceBottomUp(int[] nums) {
        int[][] cache = new int[nums.length+1][nums.length+1];
        for(int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], Integer.MAX_VALUE);

        for(int i = nums.length - 1; i >= 0; i--) 
            for(int j = nums.length - 1; j >= 0; j--) {
                
            }

   
    }

    public static void main(String[] args) {
        Solution soluzione = new Solution();
        System.out.println(soluzione.minDifferenceBottomUp(new int[] {1, 4, 7, 4, 8}));
        System.out.println(soluzione.minDifferenceBottomUp(new int[] {5, 4, 9, 1}));
        System.out.println(soluzione.minDifferenceBottomUp(new int[] {50}));
    }
    
}
