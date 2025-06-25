package Day36; //problem 3423. Maximum Difference Between Adjacent Elements in a Circular Array

import java.util.Scanner;

class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff = 0;
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            diff = Math.max(diff,Math.abs(nums[i+1] - nums[i]));
        }
        diff = Math.max(diff,Math.abs(nums[n-1] - nums[0]));
        return diff;
    }
}
public class MaxDifference {
     public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String numbers[] = str.split(",");

        int nums[] = new int[numbers.length];

        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }

        Solution ob = new Solution();
        int difference = ob.maxAdjacentDistance(nums);
        System.out.println(difference);
    }
}
